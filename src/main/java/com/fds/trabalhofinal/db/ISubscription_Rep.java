package com.fds.trabalhofinal.db;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ISubscription_Rep extends CrudRepository<Subscription, Long> {
    void SubscriptionModel(Subscription subscription);
    Optional<Subscription> findByClientIdAndApplicationId(Long clientId, Long applicationId);
    List<Subscription> findByClientId(Long clientId);
    List<Subscription> findByApplicationId(Long applicationId);
    void updatePlanEnd(Long clientId, Date newPlanEndDate);
}
