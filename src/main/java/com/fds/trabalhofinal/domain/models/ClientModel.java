package com.fds.trabalhofinal.domain.models;

public class ClientModel {
    private String clientName;
    private String clientEmail;

    public ClientModel(String clientName, String clientEmail) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
    }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public String getClientEmail() { return clientEmail; }
    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }
}
