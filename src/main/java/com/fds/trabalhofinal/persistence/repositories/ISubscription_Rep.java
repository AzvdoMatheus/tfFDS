package com.fds.trabalhofinal.persistence.repositories;

import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fds.trabalhofinal.persistence.Subscription;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISubscription_Rep extends JpaRepository<Subscription, Long> {
    List<Subscription> findByClient_ClientIdentificationCode(Long clientId);
    List<Subscription> findByApplication_AppIdentificationCode(Long applicationId);
    Optional<Subscription> findByClient_ClientIdentificationCodeAndApplication_AppIdentificationCode(
            Long clientIdentificationCode, Long appIdentificationCode);
    List<Subscription> findByStatus(SubscriptionStatus status);
}

