package com.fds.trabalhofinal.persistence;

import com.fds.trabalhofinal.domain.models.PaymentModel;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentIdentificationCode;

    private double pricePaid;

    private LocalDate paymentDate;

    @Nullable
    private String promotionalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;

    protected Payment() { }

    public long getPaymentIdentificationCode() {
        return paymentIdentificationCode;
    }

    public void setPaymentIdentificationCode(long paymentIdentificationCode) {
        this.paymentIdentificationCode = paymentIdentificationCode;
    }

    public double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Nullable
    public String getPromotionalCode() {
        return promotionalCode;
    }

    public void setPromotionalCode(@Nullable String promotionalCode) {
        this.promotionalCode = promotionalCode;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public static Payment fromPaymentModel(PaymentModel pModel) {
        Payment payment = new Payment();
        payment.setPricePaid(pModel.getPricePaid());
        payment.setPaymentDate(pModel.getPaymentDate());
        payment.setPromotionalCode(pModel.getPromotionalCode());
        return payment;
    }

    public static PaymentModel toPaymentModel(Payment payment) {
        return new PaymentModel(
                payment.getPricePaid(),
                payment.getPaymentDate(),
                payment.getPromotionalCode()
        );
    }
}
