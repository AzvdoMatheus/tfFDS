package com.fds.trabalhofinal.domain.repository;

import com.fds.trabalhofinal.domain.models.PaymentModel;

import java.util.List;

public interface IPaymentRepository {
    PaymentModel save(PaymentModel payment);
    List<PaymentModel> findBySubscriptionId(Long subscriptionId);
}