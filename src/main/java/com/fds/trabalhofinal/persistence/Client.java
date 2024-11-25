package com.fds.trabalhofinal.persistence;

import com.fds.trabalhofinal.domain.models.ClientModel;
import jakarta.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientIdentificationCode;

    private String clientName;

    private String clientEmail;

    public long getClientIdentificationCode() {
        return clientIdentificationCode;
    }

    public void setClientIdentificationCode(long clientIdentificationCode) {
        this.clientIdentificationCode = clientIdentificationCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public static Client fromClientModel(ClientModel cModel) {
        Client client = new Client();
        client.setClientIdentificationCode(cModel.getClientIdentificationCode());
        client.setClientName(cModel.getClientName());
        client.setClientEmail(cModel.getClientEmail());
        return client;
    }

    public static ClientModel toClientModel(Client client) {
        return new ClientModel(
                client.getClientIdentificationCode(),
                client.getClientName(),
                client.getClientEmail()
        );
    }
}