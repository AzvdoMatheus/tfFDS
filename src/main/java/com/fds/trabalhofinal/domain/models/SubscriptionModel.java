package com.fds.trabalhofinal.domain.models;

import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;

import java.time.LocalDate;

public class SubscriptionModel {
    private LocalDate planStart;
    private LocalDate planEnd;
    private SubscriptionStatus status;
    private ApplicationModel application;
    private ClientModel client;
    private Long subscriptionIdentificationCode;

    public SubscriptionModel(Long subscriptionIdentificationCode, LocalDate planStart, LocalDate planEnd, SubscriptionStatus status) {
        this.subscriptionIdentificationCode = subscriptionIdentificationCode;
        this.planStart = planStart;
        this.planEnd = planStart.plusDays(7);
        this.status = SubscriptionStatus.ACTIVE;
    }

    public Long getSubscriptionIdentificationCode() {
        return subscriptionIdentificationCode;
    }

    public SubscriptionModel() {
    }

    public LocalDate getPlanStart() { return planStart; }

    public LocalDate getPlanEnd() { return planEnd; }

    public SubscriptionStatus getStatus() { return status; }

    public void setPlanStart(LocalDate planStart) {
        this.planStart = planStart;
    }

    public void setPlanEnd(LocalDate planEnd) {
        this.planEnd = planEnd;
    }

    public void setStatus(SubscriptionStatus status) {
        this.status = status;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public ApplicationModel getApplication() {
        return application;
    }

    public void setApplication(ApplicationModel application) {
        this.application = application;
    }

    public void extendValidity(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Extension days must be positive.");
        }
        if (status == SubscriptionStatus.ACTIVE) {
            this.planEnd = planEnd.plusDays(days);
        } else {
            this.planEnd = LocalDate.now().plusDays(days);
            this.status = SubscriptionStatus.ACTIVE;
        }
    }
    public void cancel() {
        this.status = SubscriptionStatus.INACTIVE;
    }
    public boolean isActive() {
        return status == SubscriptionStatus.ACTIVE && planEnd.isAfter(LocalDate.now());
    }
}
