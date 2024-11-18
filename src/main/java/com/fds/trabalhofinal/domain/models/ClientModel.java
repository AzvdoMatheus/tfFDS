package com.fds.trabalhofinal.domain.models;

import java.util.List;

public class ClientModel {
    private String clientName;
    private String clientEmail;
    private long clientIdentificationCode;
    private final List<SubscriptionModel> subscription;

    public ClientModel(List<SubscriptionModel> subscription , long clientIdentificationCode, String clientEmail, String clientName) {
        this.clientEmail = clientEmail;
        this.clientName = clientName;
        this.clientIdentificationCode = clientIdentificationCode;
        this.subscription = subscription;
    }

    public long getClientIdentificationCode() { return clientIdentificationCode; }

    public void setClientIdentificationCode(long clientIdentificationCode) {
        this.clientIdentificationCode = clientIdentificationCode;
    }

    public String getClientName() { return clientName; }

   public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientEmail() { return clientEmail; }

    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }

    public List<SubscriptionModel> getClientCurrSubscriptions() {
        return subscription;
    }
}
