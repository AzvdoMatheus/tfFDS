package com.fds.trabalhofinal.persistence.itfImpl;

import com.fds.trabalhofinal.domain.models.PaymentModel;
import com.fds.trabalhofinal.domain.repository.IPaymentRepository;
import com.fds.trabalhofinal.persistence.Payment;
import com.fds.trabalhofinal.persistence.repositories.IPayment_Rep;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class IPayment_JPA implements IPaymentRepository {

    private final IPayment_Rep paymentRep;

    public IPayment_JPA(IPayment_Rep paymentRep) { this.paymentRep = paymentRep; }

    @Override
    public PaymentModel save(PaymentModel payment) {
        Payment savedPayment = paymentRep.save(Payment.fromPaymentModel(payment));
        return Payment.toPaymentModel(savedPayment);
    }

    @Override
    public List<PaymentModel> findBySubscriptionId(Long subscriptionId) {
        return paymentRep.findBySubscription_SubscriptionIdentificationCode(subscriptionId).stream()
                .map(Payment::toPaymentModel)
                .collect(Collectors.toList());
    }


}
