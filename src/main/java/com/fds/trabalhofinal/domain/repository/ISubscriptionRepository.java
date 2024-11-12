package com.fds.trabalhofinal.domain.repository;

import com.fds.trabalhofinal.domain.models.SubscriptionModel;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ISubscriptionRepository {
    void SubscriptionModel (SubscriptionModel subscription);
    Optional<SubscriptionModel> findByClientIdAndApplicationId(Long clientId, Long applicationId);
    List<SubscriptionModel> findByClientId(Long clientId);
    List<SubscriptionModel> findByApplicationId(Long applicationId);
    void updatePlanEnd(Long subscriptionId, Date newPlanEndDate);
}
