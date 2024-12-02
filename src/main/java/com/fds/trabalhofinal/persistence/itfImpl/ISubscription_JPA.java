package com.fds.trabalhofinal.persistence.itfImpl;

import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import com.fds.trabalhofinal.domain.models.SubscriptionModel;
import com.fds.trabalhofinal.domain.repository.ISubscriptionRepository;
import com.fds.trabalhofinal.persistence.Subscription;
import com.fds.trabalhofinal.persistence.repositories.ISubscription_Rep;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ISubscription_JPA implements ISubscriptionRepository {
    private final ISubscription_Rep subscriptionRep;
    public ISubscription_JPA(ISubscription_Rep subscriptionRep) {
        this.subscriptionRep = subscriptionRep;
    }

    @Override
    public SubscriptionModel save(SubscriptionModel subscriptionModel) {
        Subscription subscription = Subscription.fromSubscriptionModel(subscriptionModel);
        Subscription savedSubscription = subscriptionRep.save(subscription);
        return Subscription.toSubscriptionModel(savedSubscription);
    }

    @Override
    public List<SubscriptionModel> findAll() {
        return subscriptionRep.findAll().stream()
                .map(Subscription::toSubscriptionModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubscriptionModel> findByStatus(SubscriptionStatus status) {
        return subscriptionRep.findByStatus(status).stream()
                .map(Subscription::toSubscriptionModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubscriptionModel> findByClientId(Long clientId) {
        return subscriptionRep.findByClient_ClientIdentificationCode(clientId)
                .stream()
                .map(Subscription::toSubscriptionModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SubscriptionModel> findById(Long subscriptionId) {
        return subscriptionRep.findById(subscriptionId).map(Subscription::toSubscriptionModel);
    }
}
