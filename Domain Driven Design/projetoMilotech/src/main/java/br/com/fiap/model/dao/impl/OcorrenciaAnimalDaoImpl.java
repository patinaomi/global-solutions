package br.com.fiap.model.dao.impl;

import br.com.fiap.model.dao.OcorrenciaAnimalDao;
import br.com.fiap.model.vo.OcorrenciaAnimal;
import br.com.fiap.model.connection.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Implementação da interface OcorrenciaAnimalDao.
 * Realiza operações de persistência para a entidade OcorrenciaAnimal.
 */
public class OcorrenciaAnimalDaoImpl implements OcorrenciaAnimalDao {

    /**
     * Insere uma nova ocorrência de animal no banco de dados.
     *
     * @param ocorrenciaAnimal a ocorrência de animal a ser inserida.
     */
    @Override
    public void inserir(OcorrenciaAnimal ocorrenciaAnimal) {
        String sql = """
                INSERT INTO Ocorrencia_Animal (nome_ocorr, email_ocorr, tel_ocorr, id_animal, id_condicao_animal,
                primeiros_socorros_ocorr, cep_ocorr, estado_ocorr, cidade_ocorr, rua_ocorr, complemento_ocorr, msg_ocorr,
                foto_ocorr, lat_ocorr, long_ocorr, data_solicitacao, status_ocorr) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
                 ?, ?, 0, ?, ?, sysdate, 1)""";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configura os parâmetros da instrução SQL
            stmt.setString(1, ocorrenciaAnimal.getNome());
            stmt.setString(2, ocorrenciaAnimal.getEmail());
            stmt.setLong(3, ocorrenciaAnimal.getTelefone());
            stmt.setInt(4, ocorrenciaAnimal.getIdAnimal());
            stmt.setInt(5, ocorrenciaAnimal.getIdCondAnimal());
            stmt.setString(6, ocorrenciaAnimal.getPrimeirosSocorros());
            stmt.setString(7, ocorrenciaAnimal.getCep());
            stmt.setString(8, ocorrenciaAnimal.getEstado());
            stmt.setString(9, ocorrenciaAnimal.getCidade());
            stmt.setString(10, ocorrenciaAnimal.getRua());
            stmt.setString(11, ocorrenciaAnimal.getComplemento());
            stmt.setString(12, ocorrenciaAnimal.getMensagem());
            stmt.setString(13, ocorrenciaAnimal.getFoto());
            stmt.setString(14, ocorrenciaAnimal.getLatitude());
            stmt.setString(15, ocorrenciaAnimal.getLongitude());

            // Executa a inserção
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir ocorrência no banco de dados.", e);
        }
    }

    /**
     * Insere uma nova ocorrência de animal no banco de dados pelo chatbot.
     *
     * @param ocorrenciaAnimal a ocorrência de animal a ser inserida.
     */
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

}
