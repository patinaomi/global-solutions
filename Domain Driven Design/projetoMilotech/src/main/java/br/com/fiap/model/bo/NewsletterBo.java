package br.com.fiap.model.bo;

import br.com.fiap.model.dao.NewsletterDao;
import br.com.fiap.model.vo.Newsletter;

import java.sql.SQLException;

/**
 * Classe de negócios para operações relacionadas à Newsletter.
 * Contém regras de negócio e validações antes de interagir com o DAO.
 */
public class NewsletterBo {

    private NewsletterDao newsletterDao;

    /**
     * Construtor da classe NewsletterBo.
     * Inicializa a camada de negócios com a implementação DAO fornecida.
     *
     * @param newsletterDao A implementação de NewsletterDao a ser usada.
     */
    public NewsletterBo(NewsletterDao newsletterDao) {
        this.newsletterDao = newsletterDao;
    }

    /**
     * Insere um novo registro de newsletter após aplicar validações e regras de negócios.
     *
     * @param newsletter O objeto Newsletter a ser inserido.
     * @throws IllegalArgumentException Se o email for inválido.
     * @throws SQLException Se ocorrer um erro ao inserir a newsletter no banco de dados.
     */
    public void inserir(Newsletter newsletter) throws SQLException {
        if (!Validacoes.validarEmail(newsletter.getEmail())) {
            throw new IllegalArgumentException("Email inválido.");
        }
        newsletterDao.inserir(newsletter);
    }
}
