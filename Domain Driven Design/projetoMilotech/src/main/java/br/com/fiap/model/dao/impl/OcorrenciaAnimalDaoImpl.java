package br.com.fiap.model.dao.impl;

import br.com.fiap.model.dao.OcorrenciaAnimalDao;
import br.com.fiap.model.vo.OcorrenciaAnimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.fiap.model.connection.ConexaoFactory;

/**
 * Implementação da interface OcorrenciaAnimalDao.
 * Realiza operações de persistência para a entidade OcorrenciaAnimal.
 */
public class OcorrenciaAnimalDaoImpl implements OcorrenciaAnimalDao {

    @Override
    public void inserir(OcorrenciaAnimal ocorrenciaAnimal) {
        String sql = """
        INSERT INTO Ocorrencia_Animal (nome_ocorr, email_ocorr, tel_ocorr, rua_ocorr, cep_ocorr,
        cidade_ocorr, estado_ocorr, msg_ocorr, data_ocorr, status_ocorr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, sysdate, 1)""";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configura os parâmetros da instrução SQL
            stmt.setString(1, ocorrenciaAnimal.getNome());
            stmt.setString(2, ocorrenciaAnimal.getEmail());
            stmt.setLong(3, ocorrenciaAnimal.getTelefone());
            stmt.setString(4, ocorrenciaAnimal.getRua());
            stmt.setString(5, ocorrenciaAnimal.getCep());
            stmt.setString(6, ocorrenciaAnimal.getCidade());
            stmt.setString(7, ocorrenciaAnimal.getEstado());
            stmt.setString(8, ocorrenciaAnimal.getMensagem());

            // Executa a inserção
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir ocorrência no banco de dados.", e);
        }
    }

    @Override
    public void inserirPeloChatbot(OcorrenciaAnimal ocorrenciaAnimal) {
        String sql = """
        INSERT INTO Ocorrencia_Animal (nome_ocorr, email_ocorr, tel_ocorr, rua_ocorr, cep_ocorr,
        cidade_ocorr, estado_ocorr, msg_ocorr, data_ocorr, status_ocorr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, sysdate, 1)""";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configura os parâmetros da instrução SQL
            stmt.setString(1, ocorrenciaAnimal.getNome());
            stmt.setString(2, ocorrenciaAnimal.getEmail());
            stmt.setLong(3, ocorrenciaAnimal.getTelefone());
            stmt.setString(4, ocorrenciaAnimal.getRua());
            stmt.setString(5, ocorrenciaAnimal.getCep());
            stmt.setString(6, ocorrenciaAnimal.getCidade());
            stmt.setString(7, ocorrenciaAnimal.getEstado());
            stmt.setString(8, ocorrenciaAnimal.getMensagem());

            // Executa a inserção
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir ocorrência no banco de dados.", e);
        }
    }

    @Override
    public void listar(OcorrenciaAnimal ocorrenciaAnimal) {
        // Implementação da listagem
    }

    @Override
    public void atualizar(OcorrenciaAnimal ocorrenciaAnimal) {
        // Implementação da atualização
    }
}
