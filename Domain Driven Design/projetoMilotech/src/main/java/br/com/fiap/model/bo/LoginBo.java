package br.com.fiap.model.bo;

import br.com.fiap.model.dao.LoginDao;
import br.com.fiap.model.vo.Login;
import br.com.fiap.model.vo.Usuario;

import java.sql.SQLException;

/**
 * Classe de negócios para operações relacionadas ao Login.
 * Contém regras de negócio e validações antes de interagir com o DAO.
 */
public class LoginBo {

    private LoginDao loginDao;

    /**
     * Construtor da classe LoginBo.
     * Inicializa a camada de negócios com a implementação DAO fornecida.
     *
     * @param loginDao A implementação de LoginDao a ser usada.
     */
    public LoginBo(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    /**
     * Registra um novo login após aplicar validações e regras de negócios.
     *
     * @param login O objeto Login a ser registrado.
     * @throws IllegalArgumentException Se o email ou a senha forem inválidos.
     * @throws SQLException Se ocorrer um erro ao inserir o login no banco de dados.
     */
    public void registrarLogin(Login login) throws SQLException {
        if (login.getEmail() != null && !login.getEmail().isEmpty() &&
                login.getSenha() != null && !login.getSenha().isEmpty()) {
            loginDao.inserir(login);
        } else {
            throw new IllegalArgumentException("Email e senha são obrigatórios para o registro do login.");
        }
    }

    /**
     * Autentica um usuário com base em suas credenciais.
     *
     * @param email O email do usuário.
     * @param senha A senha do usuário.
     * @return O objeto Usuario se as credenciais estiverem corretas, null caso contrário.
     * @throws SQLException Se ocorrer um erro ao verificar as credenciais no banco de dados.
     */
    public int autenticarUsuario(String email, String senha) throws SQLException {
        return loginDao.verificarCredenciais(email, senha);
    }

}
