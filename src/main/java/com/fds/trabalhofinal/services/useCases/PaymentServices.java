package com.fds.trabalhofinal.services.useCases;

import com.fds.trabalhofinal.domain.models.PaymentModel;
import com.fds.trabalhofinal.domain.models.SubscriptionModel;
import com.fds.trabalhofinal.domain.repository.IPaymentRepository;
import com.fds.trabalhofinal.domain.repository.ISubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentServices {

    private final IPaymentRepository paymentRepository;
    private final ISubscriptionRepository subscriptionRepository;

    @Autowired
    public PaymentServices(IPaymentRepository paymentRepository, ISubscriptionRepository subscriptionRepository) {
        this.paymentRepository = paymentRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public PaymentModel registerPayment(Long subscriptionId, double pricePaid, double monthlyCost, String promotionalCode) {
        SubscriptionModel subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found."));

        int extraDays = validatePromotionAndGetExtraDays(monthlyCost, pricePaid, promotionalCode);

        LocalDate newEndDate = extendSubscriptionValidity(subscription, extraDays);

        PaymentModel payment = new PaymentModel(subscriptionId, pricePaid, newEndDate, promotionalCode);
        paymentRepository.save(payment);

        return payment;
    }


    public List<PaymentModel> listPaymentsBySubscription(Long subscriptionId) {
        subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found."));

        return paymentRepository.findBySubscriptionId(subscriptionId);
    }

    private int validatePromotionAndGetExtraDays(double monthlyCost, double pricePaid, String promotionalCode) {
        if ("PROMO_45".equalsIgnoreCase(promotionalCode) && pricePaid == monthlyCost) {
            return 45;
        }

        if ("ANNUAL_40_OFF".equalsIgnoreCase(promotionalCode) && pricePaid == (monthlyCost * 12 * 0.6)) {
            return 365;
        }

        if (pricePaid == monthlyCost) {
            return 30;
        }

        throw new IllegalArgumentException("Invalid payment amount or promotion.");
    }

    private LocalDate extendSubscriptionValidity(SubscriptionModel subscription, int extraDays) {
        LocalDate currentDate = LocalDate.now();
        LocalDate currentEndDate = subscription.getPlanEnd();

        if (currentEndDate.isAfter(currentDate)) {
            subscription.setPlanEnd(currentEndDate.plusDays(extraDays));
        } else {
            subscription.setPlanEnd(currentDate.plusDays(extraDays));
        }

        subscriptionRepository.save(subscription);
        return subscription.getPlanEnd();
    }

}
