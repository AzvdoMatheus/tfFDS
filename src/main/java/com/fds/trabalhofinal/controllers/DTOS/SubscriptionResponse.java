package com.fds.trabalhofinal.controllers.DTOS;

import java.time.LocalDate;

public class SubscriptionResponse {
    private Long subscriptionId;
    private LocalDate planStart;
    private LocalDate planEnd;
    private String status;

    public SubscriptionResponse(Long subscriptionId, LocalDate planStart, LocalDate planEnd, String status) {
        this.subscriptionId = subscriptionId;
        this.planStart = planStart;
        this.planEnd = planEnd;
        this.status = status;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public LocalDate getPlanStart() {
        return planStart;
    }

    public LocalDate getPlanEnd() {
        return planEnd;
    }

    public String getStatus() {
        return status;
    }
}
