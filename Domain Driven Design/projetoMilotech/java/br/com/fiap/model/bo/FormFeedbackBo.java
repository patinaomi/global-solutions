package br.com.fiap.model.bo;

import br.com.fiap.model.dao.FormFeedbackDao;
import br.com.fiap.model.vo.FormFeedback;
import java.sql.SQLException;

/**
 * Classe de negócios para operações relacionadas ao FormFeedback.
 * Contém regras de negócio e validações antes de interagir com o DAO.
 */
public class FormFeedbackBo {

    private FormFeedbackDao formFeedbackDao;

    /**
     * Construtor da classe FormFeedbackBo.
     * Inicializa a camada de negócios com a implementação DAO fornecida.
     *
     * @param formFeedbackDao A implementação de FormFeedbackDao a ser usada.
     */
    public FormFeedbackBo(FormFeedbackDao formFeedbackDao) {
        this.formFeedbackDao = formFeedbackDao;
    }

    /**
     * Insere um novo feedback após aplicar validações e regras de negócios.
     *
     * @param formFeedback O objeto FormFeedback a ser inserido.
     * @throws SQLException Se ocorrer um erro ao inserir o feedback.
     */
    public void inserir(FormFeedback formFeedback) throws SQLException, IllegalArgumentException {
        if (validarFeedback(formFeedback)) {
            formFeedbackDao.inserir(formFeedback);
        } else {
            throw new IllegalArgumentException("Dados de feedback inválidos.");
        }
    }

    /**
     * Valida o objeto FormFeedback aplicando regras de negócio.
     *
     * @param formFeedback O objeto FormFeedback a ser validado.
     * @return true se o feedback é válido, false caso contrário.
     */
    private boolean validarFeedback(FormFeedback formFeedback) {
        boolean isNomeValido = Validacoes.validarUsuario(formFeedback.getNome());
        boolean isEmailValido = Validacoes.validarEmail(formFeedback.getEmail());
        boolean isTelefoneValido = Validacoes.validarTelefone(String.valueOf(formFeedback.getTelefone()));

        return isNomeValido && isEmailValido && isTelefoneValido && formFeedback.getNota() >= 1 && formFeedback.getNota() <= 5;
    }
}
