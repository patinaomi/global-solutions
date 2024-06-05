package br.com.fiap.model.vo;

import java.sql.Timestamp;

/**
 * Classe que representa uma newsletter.
 * Contém informações sobre o envio da newsletter, incluindo email do destinatário, data de envio e status.
 */
public class Newsletter {
    // Atributos
    private int idNewsletter;
    private String email;
    private Timestamp dataEnvio;
    private int status;

    // Construtor
    public Newsletter() {

    }

    //Getters & Setters
    public int getIdNewsletter() {
        return idNewsletter;
    }

    public void setIdNewsletter(int idNewsletter) {
        this.idNewsletter = idNewsletter;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Timestamp dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //ToString para formatar os dados
    @Override
    public String toString() {
        return   "\nE-mail: " + getEmail();
    }
}
