package br.com.fiap.model.vo;

import java.sql.Timestamp;

/**
 * Classe que representa uma ocorrência.
 * Contém informações sobre a solicitação, incluindo descrição, detalhes de contato, localização, data, condição e identificadores relacionados.
 */
public class OcorrenciaAnimal {

    // Atributos
    private int idOcorrenciaAnimal;
    private String nome;
    private String email;
    private long telefone;
    private int idAnimal;
    private int idCondAnimal;
    private String primeirosSocorros;
    private String cep;
    private String estado;
    private String cidade;
    private String rua;
    private String complemento;
    private String mensagem;
    private String foto;
    private String latitude;
    private String longitude;
    private Timestamp data;
    private boolean status;

    //Construtor
    public OcorrenciaAnimal() {

    }

    //Getters & Setters
    public int getIdOcorrenciaAnimal() {
        return idOcorrenciaAnimal;
    }

    public void setIdOcorrenciaAnimal(int idOcorrenciaAnimal) {
        this.idOcorrenciaAnimal = idOcorrenciaAnimal;
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

    public String getPrimeirosSocorros() {
        return primeirosSocorros;
    }

    public void setPrimeirosSocorros(String primeirosSocorros) {
        this.primeirosSocorros = primeirosSocorros;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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
                "\nE-mail: " + getEmail() +
                "\nTelefone: " + getTelefone() +
                "\nId Animal: " + getIdAnimal() +
                "\nId Condição Animal: " + getIdCondAnimal() +
                "\nPrimeiros Socorros: " + getPrimeirosSocorros() +

                "\nEndereço: " + getRua() +
                "\n" + getCidade() + " " + getEstado() + " --- " + getCep() +
                "\nMensagem: " + getMensagem();
    }
}
