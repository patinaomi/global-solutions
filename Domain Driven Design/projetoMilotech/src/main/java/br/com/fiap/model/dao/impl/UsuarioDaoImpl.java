package br.com.fiap.model.dao.impl;

import br.com.fiap.model.dao.UsuarioDao;
import br.com.fiap.model.vo.Usuario;
import br.com.fiap.model.connection.ConexaoFactory;

import java.sql.*;

/**
 * Implementação da interface UsuarioDao.
 * Realiza operações de persistência para a entidade Usuario.
 */
public class UsuarioDaoImpl implements UsuarioDao {

    /**
     * Insere um novo registro de usuário no banco de dados.
     *
     * @param usuario o usuário a ser inserido.
     */
    @Override
    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nome_usuario, sobrenome_usuario, email_usuario, senha_usuario, tel_usuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Configura os parâmetros da instrução SQL
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.setLong(5, usuario.getTelefone());

            // Executa a inserção
            int dadosAlterados = stmt.executeUpdate();
            if (dadosAlterados > 0) {
                System.out.println("Cadastro inserido com sucesso!");
            } else {
                System.err.println("Erro: Nenhum cadastro foi inserido.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao salvar cadastro.");
            e.printStackTrace();
        }
    }

    /**
     * Encontra um usuário no banco de dados pelo ID.
     *
     * @param idUsuario o ID do usuário a ser encontrado.
     * @return o usuário encontrado ou null se não for encontrado.
     */
    @Override
    public Usuario encontrarUsuario(int idUsuario) {
        String sql = "SELECT * FROM Usuario WHERE id_usuario = ?";
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setSobrenome(rs.getString("sobrenome_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setTelefone(rs.getLong("tel_usuario"));
                return usuario;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário.");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Atualiza um registro de usuário no banco de dados.
     *
     * @param usuario o usuário a ser atualizado.
     */
    @Override
    public void atualizar(Usuario usuario) {
        String sql = "UPDATE Usuario SET nome_usuario = ?, sobrenome_usuario = ?, email_usuario = ?, senha_usuario = ?, tel_usuario = ? WHERE id_usuario = ?";
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.setLong(5, usuario.getTelefone());
            stmt.setInt(6, usuario.getIdUsuario());

            int dadosAlterados = stmt.executeUpdate();
            if (dadosAlterados > 0) {
                System.out.println("Cadastro atualizado com sucesso!");
            } else {
                System.err.println("Erro: Nenhum cadastro foi atualizado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cadastro.");
            e.printStackTrace();
        }
    }

    /**
     * Deleta um registro de usuário no banco de dados.
     *
     * @param usuario o usuário a ser deletado.
     */
    @Override
    public void deletar(Usuario usuario) {
        String sql = "DELETE FROM Usuario WHERE id_usuario = ?";
        try (Connection conn = ConexaoFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuario.getIdUsuario());

            int dadosAlterados = stmt.executeUpdate();
            if (dadosAlterados > 0) {
                System.out.println("Cadastro deletado com sucesso!");
            } else {
                System.err.println("Erro: Nenhum cadastro foi deletado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deletar cadastro.");
            e.printStackTrace();
        }
    }
}
