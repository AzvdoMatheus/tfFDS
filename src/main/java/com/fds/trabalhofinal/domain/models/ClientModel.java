package com.fds.trabalhofinal.domain.models;

public class ClientModel {
    private String clientName;
    private String clientEmail;
    private long clientIdentificationCode;

    public ClientModel(long clientIdentificationCode) {
        this.clientIdentificationCode = clientIdentificationCode;
    }

    public long getClientIdentificationCode() { return clientIdentificationCode; }

    public void setClientIdentificationCode(long clientIdentificationCode) {
        this.clientIdentificationCode = clientIdentificationCode;
    }

    public String getClientName() { return clientName; }

    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientEmail() { return clientEmail; }

    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }
}
