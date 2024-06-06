package br.com.fiap.listener;

import br.com.fiap.config.Config;
import br.com.fiap.service.OpenAiService;
import br.com.fiap.service.TelegramService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Classe responsável por inicializar o bot do Telegram quando o contexto do servlet é inicializado.
 */
public class BotInitializer implements ServletContextListener {

    /**
     * Método chamado quando o contexto do servlet é inicializado.
     * Inicializa o bot do Telegram e o serviço OpenAI.
     *
     * @param sce o evento de contexto do servlet.
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String token = Config.getProperty("telegram.api.key");
        OpenAiService openAiService = new OpenAiService();

        // Inicializa e inicia o bot
        TelegramService telegramService = new TelegramService(token, openAiService);
        telegramService.startBot();

        System.out.println("Bot do Telegram iniciado com sucesso.");
    }

}
