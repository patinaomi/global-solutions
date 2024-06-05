package br.com.fiap.controller;

import br.com.fiap.model.bo.LoginBo;
import br.com.fiap.model.dao.impl.LoginDaoImpl;
import br.com.fiap.model.vo.Login;

import java.sql.SQLException;

public class LoginController {

    private LoginBo loginBo;

    public LoginController() {
        this.loginBo = new LoginBo(new LoginDaoImpl());
    }

    public boolean realizarLogin(String email, String senha) throws SQLException {
        boolean autenticado = loginBo.autenticarUsuario(email, senha);

        Login login = new Login();
        login.setEmail(email);
        login.setSenha(senha);
        login.setSucesso(autenticado);

        inserirLogin(login);

        return autenticado;
    }

    public void inserirLogin(Login login) throws SQLException {
        loginBo.registrarLogin(login);
    }
}
