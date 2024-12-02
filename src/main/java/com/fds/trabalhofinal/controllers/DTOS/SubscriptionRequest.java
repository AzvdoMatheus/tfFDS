package com.fds.trabalhofinal.controllers.DTOS;

public class SubscriptionRequest {
    private Long clientId;
    private Long applicationId;

    public SubscriptionRequest(Long clientId, Long applicationId) {
        this.clientId = clientId;
        this.applicationId = applicationId;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getApplicationId() {
        return applicationId;
    }
}
