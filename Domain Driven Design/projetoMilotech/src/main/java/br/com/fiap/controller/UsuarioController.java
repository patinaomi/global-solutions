package br.com.fiap.controller;

import br.com.fiap.model.bo.UsuarioBo;
import br.com.fiap.model.dao.impl.UsuarioDaoImpl;
import br.com.fiap.model.vo.Usuario;

import java.sql.SQLException;

/**
 * Controlador responsável por gerenciar as operações relacionadas aos usuários.
 * Ele delega as operações para a camada de negócio (UsuarioBo).
 */
public class UsuarioController {

    private UsuarioBo usuarioBo;

    /**
     * Construtor da classe UsuarioController.
     * Inicializa a camada de negócio (UsuarioBo) com a implementação DAO (UsuarioDaoImpl).
     */
    public UsuarioController() {
        // Suponha que o UsuarioDaoImpl precise de uma conexão para ser inicializado. Aqui estamos simplificando.
        this.usuarioBo = new UsuarioBo(new UsuarioDaoImpl());
    }

    /**
     * Insere um novo usuário.
     *
     * @param usuario O objeto Usuario a ser inserido.
     * @throws SQLException Se ocorrer um erro ao inserir o usuário.
     */
    public void inserir(Usuario usuario) throws SQLException {
        usuarioBo.inserir(usuario);
    }

    /**
     * Atualiza um usuário existente.
     *
     * @param usuario O objeto Usuario a ser atualizado.
     * @throws SQLException Se ocorrer um erro ao atualizar o usuário.
     */
    public void atualizar(Usuario usuario) throws SQLException {
        usuarioBo.atualizar(usuario);
    }

    /**
     * Encontra um usuário por seu ID.
     *
     * @param id O ID do usuário a ser encontrado.
     * @return O objeto Usuario encontrado ou null se nenhum usuário for encontrado.
     * @throws SQLException Se ocorrer um erro durante a busca do usuário.
     */
    public Usuario encontrarUsuario(int id) throws SQLException {
        return usuarioBo.encontrarUsuario(id);
    }

    /**
     * Deleta um usuário existente.
     *
     * @param usuario O objeto Usuario a ser deletado.
     * @throws SQLException Se ocorrer um erro ao deletar o usuário.
     */
    public void deletar(Usuario usuario) throws SQLException {
        usuarioBo.deletar(usuario);
    }
}
