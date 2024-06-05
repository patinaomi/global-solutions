package br.com.fiap.model.bo;

import br.com.fiap.model.dao.NewsletterDao;
import br.com.fiap.model.vo.Newsletter;

import java.sql.SQLException;

public class NewsletterBo {

    private NewsletterDao newsletterDao;

    public NewsletterBo(NewsletterDao newsletterDao) {
        this.newsletterDao = newsletterDao;
    }

    public void inserir(Newsletter newsletter) throws SQLException {
        if (!Validacoes.validarEmail(newsletter.getEmail())) {
            throw new IllegalArgumentException("Email inválido.");
        }
        newsletterDao.inserir(newsletter);
    }
}


