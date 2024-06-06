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
    private long telefone;
    private String email;
    private String mensagem;
    private int nota;
    private Timestamp data;

    // Construtor
    public FormFeedback() {

    }

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

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    /**
     * Retorna uma representação em String do formulário de feedback.
     *
     * @return Uma String contendo todas as informações do formulário de feedback.
     */
    @Override
    public String toString() {
        return  "\nNome: " + getNome() +
                "\nTelefone: " + getTelefone() +
                "\nE-mail: " + getEmail() +
                "\nMensagem: " + getMensagem() +
                "\nAvaliação: " + getNota();
    }
}
