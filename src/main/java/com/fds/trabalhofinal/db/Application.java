package com.fds.trabalhofinal.db;

import com.fds.trabalhofinal.domain.models.ApplicationModel;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static Application fromApplicationModel(ApplicationModel aModel) {
        Application app = new Application();
        app.setAppIdentificationCode(aModel.getAppIdentificationCode());
        app.setAppName(aModel.getAppName());
        app.setMonthlyCost(aModel.getMonthlyCost());
        return app;
    }

    public static ApplicationModel toApplicationModel(Application app) {
        return new ApplicationModel(
                app.getSubscriptions().stream()
                        .map(Subscription::toSubscriptionModel)
                        .collect(Collectors.toList()),
                app.getAppIdentificationCode(),
                app.getAppName(),
                app.getMonthlyCost()
        );
    }
}