package com.fds.trabalhofinal.db;

import com.fds.trabalhofinal.domain.models.ClientModel;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Client {
    private String clientName;
    private String clientEmail;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientIdentificationCode;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Subscription> subscriptions = new ArrayList<>();

    public long getClientIdentificationCode() { return clientIdentificationCode; }

    public void setClientIdentificationCode(long clientIdentificationCode) {
        this.clientIdentificationCode = clientIdentificationCode;
    }

    public String getClientName() { return clientName; }

    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientEmail() { return clientEmail; }

    public void setClientEmail(String clientEmail) { this.clientEmail = clientEmail; }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
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
                client.getSubscriptions().stream()
                        .map(Subscription::toSubscriptionModel)
                        .collect(Collectors.toList()),
                client.getClientIdentificationCode(),
                client.getClientEmail(),
                client.getClientName()
        );
    }
}