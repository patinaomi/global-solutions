package br.com.fiap.model.dao.impl;

import br.com.fiap.model.connection.ConexaoFactory;
import br.com.fiap.model.dao.NewsletterDao;
import br.com.fiap.model.vo.Newsletter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Implementação da interface NewsletterDao.
 * Realiza operações de persistência para a entidade Newsletter.
 */
public class NewsletterDaoImpl implements NewsletterDao {

    /**
     * Insere um novo registro de newsletter no banco de dados.
     *
     * @param newsletter o registro de newsletter a ser inserido.
     */
    @Override
    public void inserir(Newsletter newsletter) {
        String sql = "INSERT INTO Newsletter (email_news, data_envio_news, status_news) VALUES (?, sysdate, 1)";
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configura os parâmetros da instrução SQL
            stmt.setString(1, newsletter.getEmail());

            // Executa a inserção
            int dadosAlterados = stmt.executeUpdate();
            if (dadosAlterados > 0) {
                System.out.println("Cadastro de Newsletter realizado com sucesso!");
            } else {
                System.err.println("Erro: Nenhum cadastro de Newsletter foi realizado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao salvar newsletter.");
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir newsletter no banco de dados.", e);
        }
    }
}
