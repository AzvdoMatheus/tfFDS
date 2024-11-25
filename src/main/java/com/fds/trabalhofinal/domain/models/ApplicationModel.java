package com.fds.trabalhofinal.domain.models;

public class ApplicationModel {
    private final long appIdentificationCode;
    private String appName;
    private double monthlyCost;

    public ApplicationModel(long appIdentificationCode, String appName, double monthlyCost) {
        this.appIdentificationCode = appIdentificationCode;
        this.appName = appName;
        this.monthlyCost = monthlyCost;
    }

    public long getAppIdentificationCode() { return appIdentificationCode; }

    public String getAppName() { return appName; }

    public void setAppName(String appName) { this.appName = appName; }

    public double getMonthlyCost() { return monthlyCost; }

    public void setMonthlyCost(double monthlyCost) { this.monthlyCost = monthlyCost; }
}
