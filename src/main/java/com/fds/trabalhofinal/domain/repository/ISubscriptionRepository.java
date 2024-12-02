package com.fds.trabalhofinal.domain.repository;

import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import com.fds.trabalhofinal.domain.models.SubscriptionModel;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ISubscriptionRepository {
    SubscriptionModel save(SubscriptionModel subscription);
    List<SubscriptionModel> findAll();
    List<SubscriptionModel> findByClientId(Long clientId);
    Optional<SubscriptionModel> findById(Long subscriptionId);
    List<SubscriptionModel> findByStatus(SubscriptionStatus status);

}