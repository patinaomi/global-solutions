package br.com.fiap.model.dao.impl;

import br.com.fiap.model.connection.ConexaoFactory;
import br.com.fiap.model.dao.LoginDao;
import br.com.fiap.model.vo.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {

    @Override
    public void inserir(Login login) {
        String sql = "INSERT INTO Login (email_login, senha_login, sucesso_login, data_login) VALUES (?, ?, ?, sysdate)";

        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login.getEmail());
            stmt.setString(2, login.getSenha());
            stmt.setString(3, login.isSucesso() ? "S" : "N");

            int result = stmt.executeUpdate();
            if (result > 0) {
                System.out.println("Registro de login " + (login.isSucesso() ? "bem-sucedido" : "falhou") + " !");
            } else {
                System.err.println("Erro ao registrar tentativa de login.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados para inserir login.");
            e.printStackTrace();
        }
    }

    public boolean verificarCredenciais(String email, String senha) {
        String sql = "SELECT COUNT(*) FROM Usuario WHERE email_usuario = ? AND senha_usuario = ?";
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao verificar credenciais.");
            e.printStackTrace();
        }
        return false;
    }
}
