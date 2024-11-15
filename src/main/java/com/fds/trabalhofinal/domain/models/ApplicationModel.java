package com.fds.trabalhofinal.domain.models;

import java.util.List;

public class ApplicationModel {
    private long appIdentificationCode;
    private String appName;
    private double monthlyCost;
    private final List<SubscriptionModel> subscriptions;

    public ApplicationModel(List<SubscriptionModel> subscriptions, long appIdentificationCode, String appName, double monthlyCost) {
        this.appName = appName;
        this.monthlyCost = monthlyCost;
        this.appIdentificationCode = appIdentificationCode;
        this.subscriptions = subscriptions;
    }

    public long getAppIdentificationCode() {
        return appIdentificationCode;
    }
    public void setAppIdentificationCode(long appIdentificationCode) {
        this.appIdentificationCode = appIdentificationCode;
    }

    public String getAppName() { return appName; }

    public void setAppName(String appName) { this.appName = appName; }

    public double getMonthlyCost() { return monthlyCost; }

    public void setMonthlyCost(double monthlyCost) { this.monthlyCost = monthlyCost; }

    public List<SubscriptionModel> getSubscriptions() {
        return subscriptions;
    }
}
