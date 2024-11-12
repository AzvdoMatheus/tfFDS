package com.fds.trabalhofinal.db;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Payment {
    private double pricePaid;
    private Date paymentDate;

    @Nullable
    private String promotionalCode;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentIdentificationCode;

    public long getPaymentIdentificationCode() { return paymentIdentificationCode; }

    public void setPaymentIdentificationCode(long paymentIdentificationCode) {
        this.paymentIdentificationCode = paymentIdentificationCode;
    }

    public double getPricePaid() { return pricePaid; }

    public void setPricePaid(double pricePaid) { this.pricePaid = pricePaid; }

    public Date getPaymentDate() { return paymentDate; }

    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    @Nullable
    public String getPromotionalCode() { return promotionalCode; }

    @Nullable
    public void setPromotionalCode(String promotionalCode) { this.promotionalCode = promotionalCode; }
}