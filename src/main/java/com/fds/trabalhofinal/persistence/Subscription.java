package com.fds.trabalhofinal.persistence;

import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import com.fds.trabalhofinal.domain.models.SubscriptionModel;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Subscription {

    @Id
    @Column(name = "subscription_identification_code", nullable = false)
    private Long subscriptionIdentificationCode;

    @Column(name = "plan_start", nullable = false)
    private LocalDate planStart;

    @Column(name = "plan_end", nullable = false)
    private LocalDate planEnd;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SubscriptionStatus status;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;
    @OneToMany(mappedBy = "subscription", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments;


    public long getSubscriptionIdentificationCode() {
        return subscriptionIdentificationCode;
    }

    public void setSubscriptionIdentificationCode(long subscriptionIdentificationCode) {
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

    public static Subscription fromSubscriptionModel(SubscriptionModel sModel) {
        Subscription subscription = new Subscription();
        subscription.setSubscriptionIdentificationCode(sModel.getSubscriptionIdentificationCode());
        subscription.setPlanStart(sModel.getPlanStart());
        subscription.setPlanEnd(sModel.getPlanEnd());
        subscription.setStatus(sModel.getStatus());
        return subscription;
    }

    public static SubscriptionModel toSubscriptionModel(Subscription subscription) {
        return new SubscriptionModel(
                subscription.getSubscriptionIdentificationCode(),
                subscription.getPlanStart(),
                subscription.getPlanEnd(),
                subscription.getStatus()
        );
    }
}
