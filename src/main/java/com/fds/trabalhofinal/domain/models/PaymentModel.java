package com.fds.trabalhofinal.domain.models;

import java.time.LocalDate;

public class PaymentModel {
    private final double pricePaid;
    private final LocalDate paymentDate;
    private final String promotionalCode;

    public PaymentModel(double pricePaid, LocalDate paymentDate, String promotionalCode) {
        if (pricePaid <= 0) {
            throw new IllegalArgumentException("Price paid must be greater than zero.");
        }
        this.pricePaid = pricePaid;
        this.paymentDate = paymentDate;
        this.promotionalCode = promotionalCode;
    }

    public double getPricePaid() { return pricePaid; }
    public LocalDate getPaymentDate() { return paymentDate; }
    public String getPromotionalCode() { return promotionalCode; }
}
