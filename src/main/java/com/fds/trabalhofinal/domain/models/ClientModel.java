package com.fds.trabalhofinal.domain.models;

public class ClientModel {
    private final long clientIdentificationCode;
    private String clientName;
    private String clientEmail;

    public ClientModel(long clientIdentificationCode, String clientName, String clientEmail) {
        this.clientIdentificationCode = clientIdentificationCode;
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public long getClientIdentificationCode() { return clientIdentificationCode; }

    public String getClientName() { return clientName; }

    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientEmail() { return clientEmail; }

    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }
}
