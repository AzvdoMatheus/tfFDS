package com.fds.trabalhofinal.persistence;

import com.fds.trabalhofinal.domain.models.ApplicationModel;

import jakarta.persistence.*;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appIdentificationCode;

    private String appName;
    private double monthlyCost;

    public long getAppIdentificationCode() {
        return appIdentificationCode;
    }

    public void setAppIdentificationCode(Long appIdentificationCode) {
        this.appIdentificationCode = appIdentificationCode;
    }

    protected Application() { }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public static Application fromApplicationModel(ApplicationModel aModel) {
        Application app = new Application();
        app.setAppName(aModel.getAppName());
        app.setMonthlyCost(aModel.getMonthlyCost());
        return app;
    }

    public static ApplicationModel toApplicationModel(Application app) {
        return new ApplicationModel(
                app.getAppName(),
                app.getMonthlyCost()
        );
    }
}
