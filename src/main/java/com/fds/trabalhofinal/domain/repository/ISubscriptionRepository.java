package com.fds.trabalhofinal.domain.repository;

import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import com.fds.trabalhofinal.domain.models.SubscriptionModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ISubscriptionRepository {
    SubscriptionModel save(SubscriptionModel subscription);
    List<SubscriptionModel> findAll();
    Optional<SubscriptionModel> findByClientIdAndApplicationId(Long clientId, Long applicationId);
    List<SubscriptionModel> findByClientId(Long clientId);
    List<SubscriptionModel> findByApplicationId(Long appId);
    Optional<SubscriptionModel> findById(Long subscriptionId);
    List<SubscriptionModel> findByStatus(SubscriptionStatus status);
    public List<Map<String, Object>> getSubscriptionsByClientId(Long clientId);
}
