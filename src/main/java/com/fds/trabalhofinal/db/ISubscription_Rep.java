package com.fds.trabalhofinal.db;

import org.springframework.data.repository.CrudRepository;
import com.fds.trabalhofinal.persistence.Subscription;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ISubscription_Rep extends CrudRepository<Subscription, Long> {
    Optional<Subscription> findByClientIdAndApplicationId(Long clientId, Long applicationId);
    List<Subscription> findByClientId(Long clientId);
    List<Subscription> findByApplicationId(Long applicationId);
    void updatePlanEnd(Long clientId, Date newPlanEndDate);
}
