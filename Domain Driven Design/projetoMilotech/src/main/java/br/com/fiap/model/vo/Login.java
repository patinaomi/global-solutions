package br.com.fiap.model.vo;

import java.sql.Timestamp;

/**
 * Classe que representa um login de usuário.
 * Contém informações sobre as credenciais de login, data do login e identificadores do usuário e tipo de login.
 */
public class Login {
    //Atributos
    private int idLogin;
    private String email;
    private String senha;
    private Timestamp dataLogin;
    private boolean sucesso;

    //Construtor
    public Login() {

    }

    //Getters & Setters
    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Timestamp getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(Timestamp dataLogin) {
        this.dataLogin = dataLogin;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    //ToString para formatar os dados
    @Override
    public String toString() {
        return  "\nE-mail: " + getEmail() +
                "\nSenha: " + getSenha();
    }
}
