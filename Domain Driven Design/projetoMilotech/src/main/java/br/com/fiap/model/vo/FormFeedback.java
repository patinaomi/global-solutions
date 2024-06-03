package br.com.fiap.model.vo;

import java.sql.Timestamp;

/**
 * Classe que representa um formulário de feedback.
 * Contém informações do feedback fornecido pelo usuário, incluindo detalhes de contato e descrição do feedback.
 */
public class FormFeedback {
    // Atributos
    private int idFeedback;
    private String nome;
    private String telefone;
    private String email;
    private String descricao;
    private Timestamp data;
    private int idUsuario;

    // Getters & Setters
    public int getIdFeedback() {
        return idFeedback;
    }

    public void setIdFeedback(int idFeedback) {
        this.idFeedback = idFeedback;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    //ToString para formatar os dados
    @Override
    public String toString() {
        return  "\nNome: " + getNome() +
                "\nTelefone: " + getTelefone() +
                "\nE-mail: " + getEmail() +
                "\nDescrição: " + getDescricao() +
                "\nData: " + getData() +
                "\nId Usuário: " + getIdUsuario();
    }
}
