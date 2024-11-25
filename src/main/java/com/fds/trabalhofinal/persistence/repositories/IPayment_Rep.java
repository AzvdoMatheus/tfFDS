package com.fds.trabalhofinal.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fds.trabalhofinal.persistence.Payment;

import java.util.List;

@Repository
public interface IPayment_Rep extends CrudRepository<Payment, Long> {
    List<Payment> findBySubscription_SubscriptionIdentificationCode(Long subscriptionIdentificationCode);

}
