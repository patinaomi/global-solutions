package br.com.fiap.model.bo;

import br.com.fiap.model.dao.LoginDao;
import br.com.fiap.model.vo.Login;

import java.sql.SQLException;

public class LoginBo {

    private LoginDao loginDao;

    public LoginBo(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public void registrarLogin(Login login) {
        if (login.getEmail() != null && !login.getEmail().isEmpty() &&
                login.getSenha() != null && !login.getSenha().isEmpty()) {
            loginDao.inserir(login);
        } else {
            throw new IllegalArgumentException("Email e senha são obrigatórios para o registro do login.");
        }
    }

    public boolean autenticarUsuario(String email, String senha) {
        return loginDao.verificarCredenciais(email, senha);
    }
}
