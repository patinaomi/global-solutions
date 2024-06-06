package br.com.fiap.model.dao.impl;

import br.com.fiap.model.dao.OcorrenciaPoluenteDao;
import br.com.fiap.model.vo.OcorrenciaPoluente;
import br.com.fiap.model.connection.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Implementação da interface OcorrenciaPoluenteDao.
 * Realiza operações de persistência para a entidade OcorrenciaPoluente.
 */
public class OcorrenciaPoluenteDaoImpl implements OcorrenciaPoluenteDao {

    /**
     * Insere uma nova ocorrência de poluente no banco de dados.
     *
     * @param ocorrenciaPoluente a ocorrência de poluente a ser inserida.
     */
    @Override
    public void inserir(OcorrenciaPoluente ocorrenciaPoluente) {
        String sql = """
                INSERT INTO Ocorrencia_Poluente (nome_ocorr, email_ocorr, tel_ocorr, id_tipo_residuo, qtd_residuo_ocorr, area_perigo_ocorr,
                cep_ocorr, estado_ocorr, cidade_ocorr, rua_ocorr, complemento_ocorr, msg_ocorr, foto_ocorr, lat_ocorr, long_ocorr, data_solicitacao, status_ocorr) 
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, 1)
                """;

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configura os parâmetros da instrução SQL
            stmt.setString(1, ocorrenciaPoluente.getNome());
            stmt.setString(2, ocorrenciaPoluente.getEmail());
            stmt.setLong(3, ocorrenciaPoluente.getTelefone());
            stmt.setInt(4, ocorrenciaPoluente.getIdTipoResiduo());
            stmt.setInt(5, ocorrenciaPoluente.getQtdResiduo());
            stmt.setString(6, ocorrenciaPoluente.getAreaPerigo());
            stmt.setString(7, ocorrenciaPoluente.getCep());
            stmt.setString(8, ocorrenciaPoluente.getEstado());
            stmt.setString(9, ocorrenciaPoluente.getCidade());
            stmt.setString(10, ocorrenciaPoluente.getRua());
            stmt.setString(11, ocorrenciaPoluente.getComplemento());
            stmt.setString(12, ocorrenciaPoluente.getMensagem());
            stmt.setString(13, ocorrenciaPoluente.getFoto());
            stmt.setString(14, ocorrenciaPoluente.getLatitude());
            stmt.setString(15, ocorrenciaPoluente.getLongitude());

            // Executa a inserção
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inserir ocorrência no banco de dados.", e);
        }
    }
}
