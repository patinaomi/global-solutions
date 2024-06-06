package br.com.fiap.controller;

import br.com.fiap.model.bo.NewsletterBo;
import br.com.fiap.model.dao.impl.NewsletterDaoImpl;
import br.com.fiap.model.vo.Newsletter;

import java.sql.SQLException;

/**
 * Controlador responsável por gerenciar as operações relacionadas às newsletters.
 * Ele delega as operações para a camada de negócio (NewsletterBo).
 */
public class NewsletterController {

    private NewsletterBo newsletterBo;

    /**
     * Construtor da classe NewsletterController.
     * Inicializa a camada de negócios com a implementação DAO (NewsletterDaoImpl).
     */
    public NewsletterController() {
        this.newsletterBo = new NewsletterBo(new NewsletterDaoImpl());
    }

    /**
     * Inscreve um usuário para receber newsletters.
     *
     * @param newsletter O objeto Newsletter a ser inserido.
     * @throws SQLException Se ocorrer um erro ao inscrever a newsletter no banco de dados.
     */
    public void inscrever(Newsletter newsletter) throws SQLException {
        newsletterBo.inserir(newsletter);
    }
}
