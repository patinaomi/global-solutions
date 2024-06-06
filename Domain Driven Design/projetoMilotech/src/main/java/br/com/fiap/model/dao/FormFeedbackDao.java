package br.com.fiap.model.dao;

import br.com.fiap.model.vo.FormFeedback;

/**
 * Interface que representa o DAO para a entidade FormFeedback.
 * Define as operações de persistência para a entidade FormFeedback.
 */
public interface FormFeedbackDao {

    /**
     * Insere um novo formulário de feedback no banco de dados.
     *
     * @param formFeedback o formulário de feedback a ser inserido.
     */
    void inserir(FormFeedback formFeedback);
}
