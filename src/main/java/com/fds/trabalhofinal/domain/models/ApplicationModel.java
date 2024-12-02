package com.fds.trabalhofinal.domain.models;

public class ApplicationModel {
    private String appName;
    private double monthlyCost;

    public ApplicationModel(String appName, double monthlyCost) {
        this.appName = appName;
        this.monthlyCost = monthlyCost;
    }

    public String getAppName() { return appName; }
    public void setAppName(String appName) { this.appName = appName; }
    public double getMonthlyCost() { return monthlyCost; }
    public void setMonthlyCost(double monthlyCost) { this.monthlyCost = monthlyCost; }
}
