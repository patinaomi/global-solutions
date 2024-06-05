package br.com.fiap.controller;

import br.com.fiap.model.bo.FormFeedbackBo;
import br.com.fiap.model.dao.impl.FormFeedbackDaoImpl;
import br.com.fiap.model.vo.FormFeedback;
import java.sql.SQLException;

/**
 * Controlador responsável por gerenciar as operações relacionadas ao FormFeedback.
 * Ele delega as operações para a camada de negócio (FormFeedbackBo).
 */
public class FormFeedbackController {

    private FormFeedbackBo formFeedbackBo;

    /**
     * Construtor da classe FormFeedbackController.
     * Inicializa a camada de negócios com a implementação DAO (FormFeedbackDaoImpl).
     */
    public FormFeedbackController() {
        this.formFeedbackBo = new FormFeedbackBo(new FormFeedbackDaoImpl());
    }

    /**
     * Insere um novo feedback.
     *
     * @param formFeedback O objeto FormFeedback a ser inserido.
     * @throws SQLException Se ocorrer um erro ao inserir o feedback.
     */
    public void inserir(FormFeedback formFeedback) throws SQLException {
        formFeedbackBo.inserir(formFeedback);
    }
}
