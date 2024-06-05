package br.com.fiap.model.dao.impl;

import br.com.fiap.model.connection.ConexaoFactory;
import br.com.fiap.model.dao.InvestidorDao;
import br.com.fiap.model.vo.Investidor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InvestidorDaoImpl implements InvestidorDao {

    @Override
    public void inserir(Investidor investidor) {
        // SQL query to insert a new record into the Investidor table
        String sql = "INSERT INTO Investidor (nome_inv, email_inv, telefone_inv, nome_empresa_inv, quantia_contribuida_inv, data_investimento_inv, msg_inv) " +
                "VALUES (?, ?, ?, ?, ?, sysdate, ?)";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configura os parâmetros da instrução SQL
            stmt.setString(1, investidor.getNome());
            stmt.setString(2, investidor.getEmail());
            stmt.setLong(3, investidor.getTelefone());
            stmt.setString(4, investidor.getNomeEmpresa());
            stmt.setDouble(5, investidor.getQuantiaContribuida());
            stmt.setString(6, investidor.getMensagem());

            // Execute the insert statement
            int dadosAlterados = stmt.executeUpdate();
            if (dadosAlterados > 0) {
                System.out.println("Investidor cadastrado com sucesso!");
            } else {
                System.err.println("Erro: Nenhum investidor foi cadastrado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir investidor.");
            e.printStackTrace();
        }
    }
}