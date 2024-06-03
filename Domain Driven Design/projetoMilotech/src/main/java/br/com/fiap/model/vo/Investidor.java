package br.com.fiap.model.vo;

import java.sql.Timestamp;

/**
 * Classe que representa um investidor.
 * Contém informações pessoais e de contato do investidor, além de dados relacionados à empresa e ao investimento realizado.
 */
public class Investidor {
    private int idInvestidor;
    private String nome;
    private String email;
    private String telefone;
    private String nomeEmpresa;
    private double quantiaContribuida;
    private Timestamp dataInvestimento;
    private String mensagem;
    private String tipoInvestidor;

    //Construtor
    public Investidor() {

    }

    //Getters & Setters
    public int getIdInvestidor() {
        return idInvestidor;
    }

    public void setIdInvestidor(int idInvestidor) {
        this.idInvestidor = idInvestidor;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public double getQuantiaContribuida() {
        return quantiaContribuida;
    }

    public void setQuantiaContribuida(double quantiaContribuida) {
        this.quantiaContribuida = quantiaContribuida;
    }

    public Timestamp getDataInvestimento() {
        return dataInvestimento;
    }

    public void setDataInvestimento(Timestamp dataInvestimento) {
        this.dataInvestimento = dataInvestimento;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getTipoInvestidor() {
        return tipoInvestidor;
    }

    public void setTipoInvestidor(String tipoInvestidor) {
        this.tipoInvestidor = tipoInvestidor;
    }

    //ToString para formatar os dados
    @Override
    public String toString() {
        return  "\nNome : " + getNome() +
                "\nE-mail: " + getEmail() +
                "\nTelefone: " + getTelefone() +
                "\nNome da Empresa: " + getNomeEmpresa() +
                "\nQuantia Contribuída: " + getQuantiaContribuida() +
                "\nData: " + getDataInvestimento() +
                "\nMensagem: " + getMensagem() +
                "\nId Tipo Investidor: " + getTipoInvestidor();
    }
}
