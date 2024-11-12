package com.fds.trabalhofinal.db;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subscriptionIdentificationCode;
    private Date planStart;
    private Date planEnd;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Application application;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Payment> payments = new ArrayList<>();

    public long getSubscriptionIdentificationCode() {
        return subscriptionIdentificationCode;
    }

    public void setSubscriptionIdentificationCode(long subscriptionIdentificationCode) {
        this.subscriptionIdentificationCode = subscriptionIdentificationCode;
    }

    public Date getPlanStart() { return planStart; }

    public void setPlanStart(Date planStart) { this.planStart = planStart; }

    public Date getPlanEnd() { return planEnd; }

    public void setPlanEnd(Date planEnd) { this.planEnd = planEnd; }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

    public Application getApplication() { return application; }

    public void setApplication(Application application) { this.application = application; }

    public List<Payment> getPayments() {
        return payments;
    }
}