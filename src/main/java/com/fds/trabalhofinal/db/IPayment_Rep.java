package com.fds.trabalhofinal.db;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IPayment_Rep extends CrudRepository<Payment, Long> {
    void PaymentModel(Payment payment);
    Optional<Payment> findByClientIdAndApplicationId(Long clientId, Long applicationId);
    List<Payment> findByClientId(Long clientId);
    List<Payment> findByApplicationId(Long applicationId);
    void updatePlanEnd(Long clientId, Date newPlanEndDate);
}
