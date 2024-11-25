package com.fds.trabalhofinal.persistence.itfImpl;

import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import com.fds.trabalhofinal.domain.models.SubscriptionModel;
import com.fds.trabalhofinal.domain.repository.ISubscriptionRepository;
import com.fds.trabalhofinal.persistence.Subscription;
import com.fds.trabalhofinal.persistence.repositories.ISubscription_Rep;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Optional<SubscriptionModel> findByClientIdAndApplicationId(Long clientId, Long applicationId) {
        return subscriptionRep.findByClient_ClientIdentificationCodeAndApplication_AppIdentificationCode(clientId, applicationId)
                .map(Subscription::toSubscriptionModel);
    }
    @Override
    public List<Map<String, Object>> getSubscriptionsByClientId(Long clientId) {
        List<Subscription> subscriptions = subscriptionRep.findByClient_ClientIdentificationCode(clientId);

        return subscriptions.stream()
                .map(subscription -> {
                    Map<String, Object> subscriptionData = new HashMap<>();
                    subscriptionData.put("codigoAssinatura", subscription.getSubscriptionIdentificationCode());
                    subscriptionData.put("codigoCliente", subscription.getClient().getClientIdentificationCode());
                    subscriptionData.put("codigoAplicativo", subscription.getApplication().getAppIdentificationCode());
                    subscriptionData.put("dataInicio", subscription.getPlanStart());
                    subscriptionData.put("dataFim", subscription.getPlanEnd());
                    subscriptionData.put("status", subscription.getStatus() == SubscriptionStatus.ACTIVE ? "ACTIVE" : "CANCELED");
                    return subscriptionData;
                })
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
    public List<SubscriptionModel> findByApplicationId(Long appId) {
        return subscriptionRep.findByApplication_AppIdentificationCode(appId)
                .stream()
                .map(Subscription::toSubscriptionModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SubscriptionModel> findById(Long subscriptionId) {
        return subscriptionRep.findById(subscriptionId).map(Subscription::toSubscriptionModel);
    }

}
