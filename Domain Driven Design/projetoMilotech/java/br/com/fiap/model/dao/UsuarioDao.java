package br.com.fiap.model.dao;

import br.com.fiap.model.vo.Usuario;

/**
 * Interface que representa o DAO para a entidade Usuario.
 * Define as operações de persistência para a entidade Usuario.
 */
public interface UsuarioDao {
    /**
     * Insere um novo registro de usuário no banco de dados.
     *
     * @param usuario o usuário a ser inserido.
     */
    void inserir(Usuario usuario);

    Usuario encontrarUsuario(int idUsuario);

    /**
     * Atualiza um registro de usuário no banco de dados.
     *
     * @param usuario o usuário a ser atualizado.
     */
    void atualizar(Usuario usuario);

    /**
     * Deleta um registro de usuário no banco de dados.
     *
     * @param usuario o usuário a ser deletado.
     */
    void deletar(Usuario usuario);
}
