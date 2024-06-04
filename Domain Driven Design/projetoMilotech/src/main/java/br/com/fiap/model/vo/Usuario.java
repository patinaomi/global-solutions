package br.com.fiap.model.vo;

/**
 * Classe que representa um usuário.
 * Contém informações pessoais e de contato do usuário, incluindo nome, sobrenome, email, senha, telefone e tipo de usuário.
 */
public class Usuario {
    //Atributos
    private int idUsuario;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private long telefone;

    //Construtor
    public Usuario() {

    }

    //Getters & Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }


    //ToString para formatar os dados
    @Override
    public String toString() {
        return  "\nNome: " + getNome() +
                "\nSobrenome: " + getSobrenome() +
                "\nE-mail: " + getEmail() +
                "\nSenha: " + getSenha() +
                "\nTelefone: " + getTelefone();
    }
}
