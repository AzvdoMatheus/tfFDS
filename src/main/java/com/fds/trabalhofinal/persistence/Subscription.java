package com.fds.trabalhofinal.persistence;

import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import com.fds.trabalhofinal.domain.models.SubscriptionModel;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_identification_code", nullable = false)
    private Long subscriptionIdentificationCode;

    @Column(name = "plan_start")
    private LocalDate planStart;

    @Column(name = "plan_end")
    private LocalDate planEnd;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SubscriptionStatus status;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL)
    private List<Payment> payments;

    public Subscription() { }

    public Long getSubscriptionIdentificationCode() {
        return subscriptionIdentificationCode;
    }
    public void setSubscriptionIdentificationCode(Long subscriptionIdentificationCode) {
        this.subscriptionIdentificationCode = subscriptionIdentificationCode;
    }

    public LocalDate getPlanStart() {
        return planStart;
    }

    public void setPlanStart(LocalDate planStart) {
        this.planStart = planStart;
    }

    public LocalDate getPlanEnd() {
        return planEnd;
    }

    public void setPlanEnd(LocalDate planEnd) {
        this.planEnd = planEnd;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public static Subscription fromSubscriptionModel(SubscriptionModel model) {
        Subscription subscription = new Subscription();
        subscription.setPlanStart(model.getPlanStart());
        subscription.setPlanEnd(model.getPlanEnd());
        subscription.setStatus(model.getStatus());
        subscription.setClient(Client.fromClientModel(model.getClient()));
        subscription.setApplication(Application.fromApplicationModel(model.getApplication()));
        return subscription;
    }

    public static SubscriptionModel toSubscriptionModel(Subscription subscription) {
        SubscriptionModel model = new SubscriptionModel();
        model.setPlanStart(subscription.getPlanStart());
        model.setPlanEnd(subscription.getPlanEnd());
        model.setStatus(subscription.getStatus());
        model.setClient(Client.toClientModel(subscription.getClient()));
        model.setApplication(Application.toApplicationModel(subscription.getApplication()));
        return model;
    }
}
