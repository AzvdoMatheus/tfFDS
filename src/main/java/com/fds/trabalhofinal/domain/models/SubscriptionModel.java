package com.fds.trabalhofinal.domain.models;

import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import java.util.Date;
import java.util.List;

public class SubscriptionModel {
    private long subscriptionIdentificationCode;
    private Date planStart;
    private Date planEnd;
    private SubscriptionStatus status;
    private final List<PaymentModel> payments;

    public SubscriptionModel(List<PaymentModel> payments, long subscriptionIdentificationCode, Date planEnd, Date planStart) {
        this.subscriptionIdentificationCode = subscriptionIdentificationCode;
        this.planEnd = planEnd;
        this.planStart = planStart;
        this.status = SubscriptionStatus.INACTIVE;
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

    public SubscriptionStatus getStatus() { return status; }

    public void setStatus(SubscriptionStatus status) { this.status = status; }

    public List<PaymentModel> getPayments() {
        return payments;
    }
}