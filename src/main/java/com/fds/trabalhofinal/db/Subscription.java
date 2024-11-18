package com.fds.trabalhofinal.db;

import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import com.fds.trabalhofinal.domain.models.SubscriptionModel;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long subscriptionIdentificationCode;
    private Date planStart;
    private Date planEnd;
    private SubscriptionStatus status;

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

    public SubscriptionStatus getStatus() { return status; }

    public void setStatus(SubscriptionStatus status) { this.status = status; }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

    public Application getApplication() { return application; }

    public void setApplication(Application application) { this.application = application; }

    public List<Payment> getPayments() {
        return payments;
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
                subscription.getPayments().stream()
                        .map(Payment::toPaymentModel)
                        .collect(Collectors.toList()),
                subscription.getSubscriptionIdentificationCode(),
                subscription.getPlanEnd(),
                subscription.getPlanStart()
        );
    }
}