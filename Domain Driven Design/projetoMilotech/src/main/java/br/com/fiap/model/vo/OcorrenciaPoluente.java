package br.com.fiap.model.vo;

import java.sql.Timestamp;

/**
 * Classe representando uma ocorrência de poluente.
 * Contém informações sobre a ocorrência, incluindo detalhes do poluente,
 * localização, contato e status.
 */
public class OcorrenciaPoluente {

    // Atributos
    private int idOcorrenciaPoluente;
    private String nome;
    private String email;
    private long telefone;
    private int idTipoResiduo;
    private int qtdResiduo;
    private String areaPerigo;
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

    // Construtor
    public OcorrenciaPoluente() {

    }

    // Getters & Setters

    public int getIdOcorrenciaPoluente() {
        return idOcorrenciaPoluente;
    }

    public void setIdOcorrenciaPoluente(int idOcorrenciaPoluente) {
        this.idOcorrenciaPoluente = idOcorrenciaPoluente;
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

    public int getIdTipoResiduo() {
        return idTipoResiduo;
    }

    public void setIdTipoResiduo(int idTipoResiduo) {
        this.idTipoResiduo = idTipoResiduo;
    }

    public int getQtdResiduo() {
        return qtdResiduo;
    }

    public void setQtdResiduo(int qtdResiduo) {
        this.qtdResiduo = qtdResiduo;
    }

    public String getAreaPerigo() {
        return areaPerigo;
    }

    public void setAreaPerigo(String areaPerigo) {
        this.areaPerigo = areaPerigo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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
                "\nId Tipo Resíduo: " + getIdTipoResiduo() +
                "\nQuantidade: " + getQtdResiduo() +

                "\nEndereço: " + getRua() +
                "\n" + getCidade() + " " + getEstado() + " --- " + getCep() +
                "\nMensagem: " + getMensagem();
    }
}
