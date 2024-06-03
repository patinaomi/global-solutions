package br.com.fiap.model.dao;

import br.com.fiap.model.vo.Newsletter;

/**
 * Interface que representa o DAO para a entidade Newsletter.
 * Define as operações de persistência para a entidade Newsletter.
 */
public interface NewsletterDao {

    /**
     * Insere um novo registro de newsletter no banco de dados.
     *
     * @param newsletter o registro de newsletter a ser inserido.
     */
    void inserir(Newsletter newsletter);
}
