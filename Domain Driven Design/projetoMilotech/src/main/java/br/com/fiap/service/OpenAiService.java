package br.com.fiap.service;

import br.com.fiap.config.Config;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;

import java.util.Arrays;

/**
 * Serviço para interagir com a API OpenAI, especificamente para gerar conteúdo de texto com base em modelos de linguagem.
 * Esta classe fornece métodos para solicitar e receber textos gerados pela API OpenAI sobre conservação marinha e vida marinha.
 */
public class OpenAiService {
    private com.theokanning.openai.service.OpenAiService service;

    /**
     * Constrói uma instância de OpenAiService configurando o cliente da API OpenAI.
     * A chave API é obtida de um arquivo de configuração.
     */
    public OpenAiService() {
        String token = Config.getProperty("openai.api.key");
        this.service = new com.theokanning.openai.service.OpenAiService(token);
    }

    /**
     * Gera informações educacionais sobre conservação marinha e vida marinha com base em uma consulta fornecida.
     * O texto gerado é formatado para ser educativo e informativo, conforme as instruções dadas ao modelo da OpenAI.
     *
     * @param consulta A consulta do usuário relacionada à vida marinha ou conservação dos mares.
     * @return Um texto educacional gerado ou null se ocorrer um erro na requisição.
     * @throws Exception Se ocorrer um erro ao fazer a requisição para a OpenAI.
     */
    public String gerarInformacaoMarinha(String consulta) {
        String systemText = """
                Você é um biólogo marinho.
                Seu papel é educar as pessoas sobre conservação marinha e vida marinha.
                Por favor, forneça informações precisas e detalhadas sobre os tópicos solicitados, evitando conteúdo fora do tema marinho.
                """;

        try {
            ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                    .model("gpt-3.5-turbo")
                    .messages(Arrays.asList(
                            new ChatMessage(ChatMessageRole.SYSTEM.value(), systemText),
                            new ChatMessage(ChatMessageRole.USER.value(), consulta)
                    ))
                    .build();

            StringBuilder resultado = new StringBuilder();

            service.createChatCompletion(completionRequest)
                    .getChoices()
                    .forEach(c -> resultado.append(c.getMessage().getContent()).append("\n"));

            return resultado.toString();
        } catch (Exception e) {
            System.err.println("Erro ao enviar requisição para OpenAI: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
