package br.com.fiap.model.vo;

import java.sql.Timestamp;

/**
 * Classe que representa uma ocorrência.
 * Contém informações sobre a solicitação, incluindo descrição, detalhes de contato, localização, data, condição e identificadores relacionados.
 */
public class OcorrenciaAnimal {
    // Atributos
    private int idOcorrencia;
    private String nome;
    private String email;
    private long telefone;
    private int idAnimal;
    private int idCondAnimal;
    private String firstAid;
    private String rua;
    private String cep;
    private String cidade;
    private String estado;
    private String mensagem;
    private Timestamp data;

    private boolean status;

    //Construtor
    public OcorrenciaAnimal() {

    }

    //Getters & Setters
    public int getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(int idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdCondAnimal() {
        return idCondAnimal;
    }

    public void setIdCondAnimal(int idCondAnimal) {
        this.idCondAnimal = idCondAnimal;
    }

    public String getFirstAid() {
        return firstAid;
    }

    public void setFirstAid(String firstAid) {
        this.firstAid = firstAid;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    //ToString para formatar os dados
    @Override
    public String toString() {
        return  "\nNome : " + getNome() +
                "\nTE-mail: " + getEmail() +
                "\nTelefone: " + getTelefone() +
                "\nId Animal: " + getIdAnimal() +
                "\nId Condição Animal: " + getIdCondAnimal() +
                "\nPrimeiros Socorros: " + getFirstAid() +

                "\nEndereço: " + getRua() +
                "\n" + getCidade() + " " + getEstado() + " --- " + getCep() +
                "\nMensagem: " + getMensagem();
    }
}
