package com.fds.trabalhofinal.db;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appIdentificationCode;
    private String appName;
    private double monthlyCost;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Subscription> subscriptions = new ArrayList<>();

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

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
}