package com.fds.trabalhofinal.domain.models;

public class ApplicationModel {
    private long appIdentificationCode;
    private String appName;
    private double monthlyCost;

    public ApplicationModel(long appIdentificationCode) {
        this.appIdentificationCode = appIdentificationCode;
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
}
