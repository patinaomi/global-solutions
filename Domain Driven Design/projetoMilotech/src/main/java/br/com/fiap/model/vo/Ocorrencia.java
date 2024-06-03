package br.com.fiap.model.vo;

import java.sql.Timestamp;

/**
 * Classe que representa uma ocorrência.
 * Contém informações sobre a solicitação, incluindo descrição, detalhes de contato, localização, data, condição e identificadores relacionados.
 */
public class Ocorrencia {
    // Atributos
    private int idSolicitacao;
    private String descricao;
    private String telefone;
    private String imagem; //vai ser uma url da imagem
    private String longitude;
    private String latitude;
    private Timestamp dataSolicitacao;
    private String condicao;
    private int idUsuario;
    private int idAnimal;
    private int idTipoResiduo;

    //Construtor
    public Ocorrencia() {

    }

    //Getters & Setters
    public int getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(int idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Timestamp getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Timestamp dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdTipoResiduo() {
        return idTipoResiduo;
    }

    public void setIdTipoResiduo(int idTipoResiduo) {
        this.idTipoResiduo = idTipoResiduo;
    }

    //ToString para formatar os dados
    @Override
    public String toString() {
        return  "\nDescrição : " + getDescricao() +
                "\nTelefone: " + getTelefone() +
                "\nURL da Imagem: " + getImagem() +
                "\nLongitude: " + getLongitude() +
                "\nLatitude: " + getLatitude() +
                "\nData: " + getDataSolicitacao() +
                "\nCondição: " + getCondicao() +
                "\nId Usuário: " + getIdUsuario() +
                "\nId Animal: " + getIdAnimal() +
                "\nId Tipo Resíduo: " + getIdTipoResiduo();
    }
}
