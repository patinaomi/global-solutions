package br.com.fiap.service;

import br.com.fiap.config.Config;
import br.com.fiap.model.bo.OcorrenciaAnimalBo;
import br.com.fiap.model.bo.UsuarioBo;
import br.com.fiap.model.bo.Validacoes;
import br.com.fiap.model.dao.OcorrenciaAnimalDao;
import br.com.fiap.model.dao.UsuarioDao;
import br.com.fiap.model.dao.impl.OcorrenciaAnimalDaoImpl;
import br.com.fiap.model.vo.Endereco;
import br.com.fiap.model.dao.impl.UsuarioDaoImpl;
import br.com.fiap.model.vo.OcorrenciaAnimal;
import br.com.fiap.model.vo.Usuario;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendAudio;
import com.pengrad.telegrambot.request.SendMessage;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TelegramService {
    private ViaCepService viaCepService;
    private TelegramBot bot;
    private OpenAiService openAiService;
    private TextToSpeechService textToSpeechService;
    private UsuarioDao usuarioDao;
    private UsuarioBo usuarioBo;
    private OcorrenciaAnimalDao ocorrenciaAnimalDao;
    private OcorrenciaAnimalBo ocorrenciaAnimalBo;
    private Map<String, String> userStates = new HashMap<>();
    private Map<String, Usuario> tempUsers = new HashMap<>();
    private Map<String, OcorrenciaAnimal> tempOcorrencias = new HashMap<>();

    public TelegramService(String token, OpenAiService openAiService) {
        this.bot = new TelegramBot(token);
        this.openAiService = openAiService;
        this.textToSpeechService = new TextToSpeechService();
        this.usuarioDao = new UsuarioDaoImpl();
        this.usuarioBo = new UsuarioBo(usuarioDao);
        this.ocorrenciaAnimalDao = new OcorrenciaAnimalDaoImpl();
        this.ocorrenciaAnimalBo = new OcorrenciaAnimalBo(ocorrenciaAnimalDao);
        this.viaCepService = new ViaCepService();
    }

    public void startBot() {
        this.bot = new TelegramBot(Config.getProperty("telegram.api.key"));
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::processUpdate);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }, e -> {
            if (e.response() != null) {
                System.err.println("Erro da API do Telegram: " + e.response().description());
            } else {
                System.err.println("Erro de rede ou de conexão: " + e.getMessage());
                e.printStackTrace();
            }
        });
        System.out.println("Bot iniciado com sucesso!");
    }

    private void processUpdate(Update update) {
        Message message = update.message();
        if (message != null && message.text() != null && !message.text().isEmpty()) {
            handleUserMessage(message);
        }
    }

    private void handleUserMessage(Message message) {
        String chatId = String.valueOf(message.chat().id());
        String userText = message.text().trim();

        String state = userStates.get(chatId);
        if (state != null) {
            opcaoAcoesUser(chatId, userText);
        } else {
            switch (userText.toLowerCase()) {
                case "/start":
                    opcaoStart(chatId);
                    break;
                case "/cadastro":
                    opcaoCadastro(chatId);
                    break;
                case "/educacao":
                    opcaoEducacao(chatId, userText);
                    break;
                case "/ocorrencia":
                    opcaoOcorrencia(chatId);
                    break;
                default:
                    opcaoDefault(chatId);
                    break;
            }
        }
    }

    private void opcaoStart(String chatId) {
        String welcomeMessage = "Bem-vindo ao MiloBot! Utilize o menu inferior a esquerda para acessar as opções.";
        bot.execute(new SendMessage(chatId, welcomeMessage));
        userStates.put(chatId, null);
    }

    private void opcaoCadastro(String chatId) {
        bot.execute(new SendMessage(chatId, "Digite seu nome:"));
        userStates.put(chatId, "awaiting_first_name");
    }

    private void fluxoCadastro(String chatId, String userText) {
        String state = userStates.get(chatId);
        Usuario usuario = tempUsers.getOrDefault(chatId, new Usuario());

        try {
            switch (state) {
                case "awaiting_first_name":
                    usuario.setNome(userText);
                    tempUsers.put(chatId, usuario);
                    userStates.put(chatId, "awaiting_last_name");
                    bot.execute(new SendMessage(chatId, "Digite seu sobrenome:"));
                    break;
                case "awaiting_last_name":
                    usuario.setSobrenome(userText);
                    tempUsers.put(chatId, usuario);
                    userStates.put(chatId, "awaiting_email");
                    bot.execute(new SendMessage(chatId, "Digite seu e-mail:"));
                    break;
                case "awaiting_email":
                    if (!Validacoes.validarEmail(userText)) {
                        bot.execute(new SendMessage(chatId, "Erro: Email inválido. Por favor, insira um email válido."));
                        return;
                    }
                    usuario.setEmail(userText);
                    tempUsers.put(chatId, usuario);
                    userStates.put(chatId, "awaiting_password");
                    bot.execute(new SendMessage(chatId, "Crie uma senha:"));
                    break;
                case "awaiting_password":
                    if (!Validacoes.validarSenha(userText)) {
                        bot.execute(new SendMessage(chatId, "Erro: A senha deve conter no mínimo 6 caracteres, incluindo pelo menos um número, uma letra maiúscula, uma letra minúscula e um caractere especial."));
                        return;
                    }
                    usuario.setSenha(userText);
                    tempUsers.put(chatId, usuario);
                    userStates.put(chatId, "awaiting_telephone");
                    bot.execute(new SendMessage(chatId, "Digite seu telefone:"));
                    break;
                case "awaiting_telephone":
                    if (!Validacoes.validarTelefone(userText)) {
                        bot.execute(new SendMessage(chatId, "Erro: Telefone inválido. Use apenas números."));
                        return;
                    }
                    usuario.setTelefone(Long.parseLong(userText.replaceAll("[^0-9]", "")));
                    usuarioBo.inserir(usuario);
                    bot.execute(new SendMessage(chatId, "Cadastro concluído com sucesso!"));
                    tempUsers.remove(chatId);
                    userStates.remove(chatId);
                    break;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao registrar usuário: " + e.getMessage());
            bot.execute(new SendMessage(chatId, "Erro: Tivemos um problema ao fazer seu cadastro!"));
            tempUsers.remove(chatId);
            userStates.remove(chatId);
        }
    }

    private void opcaoEducacao(String chatId, String query) {
        bot.execute(new SendMessage(chatId, "Escreva a sua pergunta:"));
        String responseText = openAiService.gerarInformacao(query);

        if (responseText != null) {
            File audioFile = textToSpeechService.synthesizeToFile(responseText);
            bot.execute(new SendMessage(chatId, "Aqui está a resposta em áudio:"));

            if (audioFile != null) {
                try {
                    bot.execute(new SendAudio(chatId, audioFile));
                } catch (Exception e) {
                    bot.execute(new SendMessage(chatId, "Erro ao enviar áudio: " + e.getMessage()));
                }
            } else {
                bot.execute(new SendMessage(chatId, "Erro ao gerar áudio."));
            }
        } else {
            bot.execute(new SendMessage(chatId, "Desculpe, não consegui gerar uma resposta no momento."));
        }
    }

    private void opcaoOcorrencia(String chatId) {
        bot.execute(new SendMessage(chatId, "Digite seu CEP:"));
        userStates.put(chatId, "awaiting_ocorrencia_cep");
    }

    private void fluxoOcorrencia(String chatId, String userText) {
        String state = userStates.get(chatId);
        OcorrenciaAnimal ocorrencia = tempOcorrencias.getOrDefault(chatId, new OcorrenciaAnimal());

        switch (state) {
            case "awaiting_ocorrencia_cep":
                Endereco endereco = viaCepService.getEndereco(userText);
                if (endereco == null || endereco.getCep() == null) {
                    bot.execute(new SendMessage(chatId, "CEP inválido. Por favor, tente novamente."));
                    return;
                }
                ocorrencia.setCep(endereco.getCep());
                ocorrencia.setRua(endereco.getLogradouro());
                ocorrencia.setCidade(endereco.getLocalidade());
                ocorrencia.setEstado(endereco.getUf());
                tempOcorrencias.put(chatId, ocorrencia);

                bot.execute(new SendMessage(chatId, "Por favor, confirme os dados do endereço:\n" +
                        "Rua: " + endereco.getLogradouro() + "\n" +
                        "Cidade: " + endereco.getLocalidade() + "\n" +
                        "Estado: " + endereco.getUf() + "\n" +
                        "Está correto? (Sim/Não)"));
                userStates.put(chatId, "awaiting_ocorrencia_confirmacao_endereco");
                break;
            case "awaiting_ocorrencia_confirmacao_endereco":
                if (userText.equalsIgnoreCase("sim")) {
                    bot.execute(new SendMessage(chatId, "Digite seu nome:"));
                    userStates.put(chatId, "awaiting_ocorrencia_nome");
                } else {
                    bot.execute(new SendMessage(chatId, "Digite seu CEP novamente:"));
                    userStates.put(chatId, "awaiting_ocorrencia_cep");
                }
                break;
            case "awaiting_ocorrencia_nome":
                ocorrencia.setNome(userText);
                tempOcorrencias.put(chatId, ocorrencia);
                userStates.put(chatId, "awaiting_ocorrencia_email");
                bot.execute(new SendMessage(chatId, "Digite seu e-mail:"));
                break;
            case "awaiting_ocorrencia_email":
                if (!Validacoes.validarEmail(userText)) {
                    bot.execute(new SendMessage(chatId, "Erro: Email inválido. Por favor, insira um email válido."));
                    return;
                }
                ocorrencia.setEmail(userText);
                tempOcorrencias.put(chatId, ocorrencia);
                userStates.put(chatId, "awaiting_ocorrencia_telefone");
                bot.execute(new SendMessage(chatId, "Digite seu telefone:"));
                break;
            case "awaiting_ocorrencia_telefone":
                if (!Validacoes.validarTelefone(userText)) {
                    bot.execute(new SendMessage(chatId, "Erro: Telefone inválido. Use apenas números."));
                    return;
                }
                ocorrencia.setTelefone(Long.parseLong(userText.replaceAll("[^0-9]", "")));
                tempOcorrencias.put(chatId, ocorrencia);
                userStates.put(chatId, "awaiting_ocorrencia_mensagem");
                bot.execute(new SendMessage(chatId, "Digite a mensagem da ocorrência:"));
                break;
            case "awaiting_ocorrencia_mensagem":
                ocorrencia.setMensagem(userText);
                ocorrenciaAnimalBo.inserirPeloChatbot(ocorrencia);
                bot.execute(new SendMessage(chatId, "Ocorrência registrada com sucesso!"));
                tempOcorrencias.remove(chatId);
                userStates.remove(chatId);
                break;
        }
    }


    private void opcaoAcoesUser(String chatId, String userText) {
        String state = userStates.get(chatId);
        if (state != null) {
            switch (state) {
                case "awaiting_first_name":
                case "awaiting_last_name":
                case "awaiting_email":
                case "awaiting_password":
                case "awaiting_telephone":
                    fluxoCadastro(chatId, userText);
                    break;
                case "awaiting_ocorrencia_cep":
                case "awaiting_ocorrencia_confirmacao_endereco":
                case "awaiting_ocorrencia_nome":
                case "awaiting_ocorrencia_email":
                case "awaiting_ocorrencia_telefone":
                case "awaiting_ocorrencia_mensagem":
                    fluxoOcorrencia(chatId, userText);
                    break;
                default:
                    opcaoDefault(chatId);
                    break;
            }
        } else {
            opcaoDefault(chatId);
        }
    }

    /**
     * Configura o listener para receber atualizações do bot do Telegram e processá-las.
     */
    public void setListener() {
        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                processUpdate(update);
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }, e -> {
            if (e.response() != null) {
                System.err.println("Erro da API do Telegram: " + e.response().description());
            } else {
                System.err.println("Erro de rede ou de conexão: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    /**
     * Responde a comandos desconhecidos ou inválidos.
     * Este método é chamado quando um comando fornecido pelo usuário não corresponde a nenhum comando conhecido.
     *
     * @param chatId O identificador do chat no Telegram, usado para interagir com o usuário.
     * Este método envia uma mensagem ao usuário informando que a opção selecionada é inválida e solicita que uma opção válida seja selecionada do menu.
     */
    private void opcaoDefault(String chatId) {
        bot.execute(new SendMessage(chatId, "Opção inválida, por favor selecione uma opção localizada no menu inferior a esquerda."));
    }


}
