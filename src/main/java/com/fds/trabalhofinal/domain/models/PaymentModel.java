package com.fds.trabalhofinal.domain.models;

import jakarta.annotation.Nullable;

import java.util.Date;

public class PaymentModel {
    private double pricePaid;
    private Date paymentDate;
    private String promotionalCode;
    private long paymentIdentificationCode;

    public PaymentModel(long paymentIdentificationCode, double pricePaid, Date paymentDate, String promotionalCode) {
        this.paymentIdentificationCode = paymentIdentificationCode;
        this.pricePaid = pricePaid;
        this.paymentDate = paymentDate;
        this.promotionalCode = promotionalCode;
    }

    public long getPaymentIdentificationCode() { return paymentIdentificationCode; }

    public void setPaymentIdentificationCode(long paymentIdentificationCode) {
        this.paymentIdentificationCode = paymentIdentificationCode;
    }

    public double getPricePaid() { return pricePaid; }

    public void setPricePaid(double pricePaid) { this.pricePaid = pricePaid; }

    public Date getPaymentDate() { return paymentDate; }

    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    public String getPromotionalCode() { return promotionalCode; }

    public void setPromotionalCode(String promotionalCode) { this.promotionalCode = promotionalCode; }
}
