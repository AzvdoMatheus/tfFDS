package com.fds.trabalhofinal.db;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
}