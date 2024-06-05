package br.com.fiap.model.dao;

import br.com.fiap.model.vo.Login;

/**
 * Interface que representa o DAO para a entidade Login.
 * Define as operações de persistência para a entidade Login.
 */
public interface LoginDao {

    /**
     * Insere um novo registro de login no banco de dados.
     *
     * @param login o registro de login a ser inserido.
     */
    void inserir(Login login);

    boolean verificarCredenciais(String email, String senha);
}
