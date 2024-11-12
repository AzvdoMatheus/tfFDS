package com.fds.trabalhofinal.domain.models;

import java.util.Date;
import java.util.List;

public class SubscriptionModel {
    private long subscriptionIdentificationCode;
    private Date planStart;
    private Date planEnd;
    private final List<PaymentModel> payments;

    public SubscriptionModel(List<PaymentModel> payments, long subscriptionIdentificationCode, Date planEnd, Date planStart) {
        this.subscriptionIdentificationCode = subscriptionIdentificationCode;
        this.planEnd = planEnd;
        this.planStart = planStart;
        this.payments = payments;
    }
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

    public List<PaymentModel> getPayments() {
        return payments;
    }
}
