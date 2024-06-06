package br.com.fiap.controller;

import br.com.fiap.model.bo.LoginBo;
import br.com.fiap.model.dao.impl.LoginDaoImpl;
import br.com.fiap.model.vo.Login;
import br.com.fiap.model.vo.Usuario;

import java.sql.SQLException;

/**
 * Controlador responsável por gerenciar as operações relacionadas ao login.
 * Ele delega as operações para a camada de negócio (LoginBo).
 */
public class LoginController {

    private LoginBo loginBo;

    /**
     * Construtor da classe LoginController.
     * Inicializa a camada de negócios com a implementação DAO (LoginDaoImpl).
     */
    public LoginController() {
        this.loginBo = new LoginBo(new LoginDaoImpl());
    }

    /**
     * Realiza o login de um usuário com base em suas credenciais.
     *
     * @param email O email do usuário.
     * @param senha A senha do usuário.
     * @return O objeto Usuario se as credenciais estiverem corretas, null caso contrário.
     * @throws SQLException Se ocorrer um erro ao verificar as credenciais no banco de dados.
     */
    public int realizarLogin(String email, String senha) throws SQLException {
        int userId = loginBo.autenticarUsuario(email, senha);

        Login login = new Login();
        login.setEmail(email);
        login.setSenha(senha);
        login.setSucesso(userId != -1);

        inserirLogin(login);

        return userId;
    }


    /**
     * Registra um novo login.
     *
     * @param login O objeto Login a ser registrado.
     * @throws SQLException Se ocorrer um erro ao registrar o login no banco de dados.
     */
    public void inserirLogin(Login login) throws SQLException {
        loginBo.registrarLogin(login);
    }
}
