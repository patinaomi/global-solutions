package br.com.fiap.model.dao.impl;

import br.com.fiap.model.connection.ConexaoFactory;
import br.com.fiap.model.dao.FormFeedbackDao;
import br.com.fiap.model.vo.FormFeedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Implementação da interface FormFeedbackDao.
 * Realiza operações de persistência para a entidade FormFeedback.
 */
public class FormFeedbackDaoImpl implements FormFeedbackDao {

    /**
     * Insere um novo Feedback no banco de dados.
     *
     * @param formFeedback O objeto formFeedback a ser inserido.
     */
    @Override
    public void inserir(FormFeedback formFeedback) {
        String sql = "INSERT INTO FORM_FEEDBACK(nome_feedback, email_feedback, tel_feedback, msg_feedback, nota_feedback, data_feedback) " +
                "VALUES(?, ?, ?, ?, ?, sysdate)";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configura os parâmetros da instrução SQL
            stmt.setString(1, formFeedback.getNome());
            stmt.setString(2, formFeedback.getEmail());
            stmt.setLong(3, formFeedback.getTelefone());
            stmt.setString(4, formFeedback.getMensagem());
            stmt.setInt(5, formFeedback.getNota());

            // Executa a inserção
            int dadosAlterados = stmt.executeUpdate();
            if (dadosAlterados > 0) {
                System.out.println("Formulário de feedback inserido com sucesso!");
            } else {
                System.err.println("Erro: Nenhum formulário de feedback foi inserido.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir formulário de feedback.");
            e.printStackTrace();
        }
    }
}
