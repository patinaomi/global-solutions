package br.com.fiap.listener;

import br.com.fiap.config.Config;
import br.com.fiap.service.OpenAiService;
import br.com.fiap.service.TelegramService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BotInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Obtenha a chave de API do bot a partir de suas configurações
        String token = Config.getProperty("telegram.api.key");
        OpenAiService openAiService = new OpenAiService();

        // Inicialize e inicie o bot
        TelegramService telegramService = new TelegramService(token, openAiService);
        telegramService.startBot();

        System.out.println("Bot do Telegram iniciado com sucesso.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Limpeza quando o Tomcat é desligado, se necessário
    }
}
