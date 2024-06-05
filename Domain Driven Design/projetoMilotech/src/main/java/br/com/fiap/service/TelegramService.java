package br.com.fiap.service;

import br.com.fiap.model.bo.UsuarioBo;
import br.com.fiap.model.bo.Validacoes;
import br.com.fiap.model.dao.UsuarioDao;
import br.com.fiap.model.dao.impl.UsuarioDaoImpl;
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
import java.util.List;
import java.util.Map;

public class TelegramService {
    private TelegramBot bot;
    private OpenAiService openAiService;
    private TextToSpeechService textToSpeechService;
    private UsuarioDao usuarioDao;
    private UsuarioBo usuarioBo;
    private Map<String, String> userStates = new HashMap<>();
    private Map<String, Usuario> tempUsers = new HashMap<>();

    public TelegramService(String token, OpenAiService openAiService) {
        this.bot = new TelegramBot(token);
        this.openAiService = openAiService;
        this.textToSpeechService = new TextToSpeechService();
        this.usuarioDao = new UsuarioDaoImpl();
        this.usuarioBo = new UsuarioBo(usuarioDao);
    }


    private void processUpdates(List<Update> updates) {
        updates.forEach(this::processUpdate);
    }

    private void processUpdate(Update update) {
        Message message = update.message();
        if (message != null && message.text() != null && !message.text().isEmpty()) {
            handleUserMessage(message);
        }
    }

    private void handleUserMessage(Message message) {
        String chatId = String.valueOf(message.chat().id());
        String userText = message.text().trim().toLowerCase();

        switch (userText) {
            case "/start":
                sendWelcomeMessage(chatId);
                break;
            case "/cadastro":
                promptForEmail(chatId);
                break;
            case "/educacao":
                handleEducationOption(chatId, userText);
                break;
            case "/ocorrencia":
                handleIncidentReporting(chatId);
                break;
            default:
                handleUnknownCommand(chatId, userText);
                break;
        }
    }

    private void sendWelcomeMessage(String chatId) {
        String welcomeMessage = "Bem-vindo ao MiloBot! Utilize o menu inferior a esquerda para acessar as opções.";
        bot.execute(new SendMessage(chatId, welcomeMessage));
        userStates.put(chatId, null);
    }

    private void promptForEmail(String chatId) {
        bot.execute(new SendMessage(chatId, "Digite seu e-mail:"));
        userStates.put(chatId, "awaiting_email");
    }

    private void handleUserRegistration(String chatId, String userText) {
        String state = userStates.get(chatId);
        Usuario usuario = tempUsers.getOrDefault(chatId, new Usuario());

        try {
            switch (state) {
                case "awaiting_email":
                    if (!Validacoes.validarEmail(userText)) {
                        bot.execute(new SendMessage(chatId, "Erro: Email inválido. Por favor, insira um email válido."));
                        return;
                    }
                    usuario.setEmail(userText);
                    tempUsers.put(chatId, usuario);
                    userStates.put(chatId, "awaiting_password");
                    bot.execute(new SendMessage(chatId, "Por fim, digite sua senha:"));
                    break;
                case "awaiting_password":
                    if (!Validacoes.validarSenha(userText)) {
                        bot.execute(new SendMessage(chatId, "Erro: A senha deve conter no mínimo 6 caracteres, incluindo pelo menos um número, uma letra maiúscula, uma letra minúscula e um caractere especial."));
                        return;
                    }
                    usuario.setSenha(userText);
                    usuarioBo.inserir(usuario);
                    finalizeRegistration(chatId, true); // Assumindo sucesso aqui
                    break;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao registrar usuário: " + e.getMessage());
            finalizeRegistration(chatId, false);
        }
    }


    private void finalizeRegistration(String chatId, boolean success) {
        if (success) {
            bot.execute(new SendMessage(chatId, "Cadastro concluído com sucesso!"));
        } else {
            bot.execute(new SendMessage(chatId, "Erro: Tivemos um problema ao fazer seu cadastro!"));
        }
        tempUsers.remove(chatId);
        userStates.remove(chatId);
    }

    private void handleEducationOption(String chatId, String query) {
        // Implementação específica para opção de educação
    }

    private void handleIncidentReporting(String chatId) {
        // Implementação específica para relatar ocorrências
    }

    private void handleUnknownCommand(String chatId, String userText) {
        // Tratamento para comandos desconhecidos ou outros estados
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
}
