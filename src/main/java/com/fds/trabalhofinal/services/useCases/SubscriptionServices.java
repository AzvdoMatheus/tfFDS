package com.fds.trabalhofinal.services.useCases;

import com.fds.trabalhofinal.controllers.DTOS.SubscriptionRequest;
import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import com.fds.trabalhofinal.domain.models.ApplicationModel;
import com.fds.trabalhofinal.domain.models.ClientModel;
import com.fds.trabalhofinal.domain.models.SubscriptionModel;
import com.fds.trabalhofinal.domain.repository.IAppRepository;
import com.fds.trabalhofinal.domain.repository.IClientRepository;
import com.fds.trabalhofinal.domain.repository.ISubscriptionRepository;
import com.fds.trabalhofinal.controllers.DTOS.SubscriptionResponse;
import com.fds.trabalhofinal.persistence.Application;
import com.fds.trabalhofinal.persistence.Client;
import com.fds.trabalhofinal.persistence.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Map;

@Service
public class SubscriptionServices {

    private final ISubscriptionRepository subscriptionRepository;
    private final IClientRepository clientRepository;
    private final IAppRepository applicationRepository;

    @Autowired
    public SubscriptionServices(ISubscriptionRepository subscriptionRepository, IClientRepository clientRepository, IAppRepository applicationRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.clientRepository = clientRepository;
        this.applicationRepository = applicationRepository;
    }

    public List<SubscriptionModel> listAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public List<SubscriptionModel> listSubscriptionsByStatus(SubscriptionStatus status) {
        return subscriptionRepository.findByStatus(status);
    }

    public SubscriptionResponse cancelSubscription(Long subscriptionId) {
        SubscriptionModel subscriptionModel = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found"));

        Subscription subscription = Subscription.fromSubscriptionModel(subscriptionModel);

        subscription.setStatus(SubscriptionStatus.CANCELED);

        SubscriptionModel updatedSubscriptionModel = subscriptionRepository.save(Subscription.toSubscriptionModel(subscription));

        return new SubscriptionResponse(
                updatedSubscriptionModel.getSubscriptionIdentificationCode(),
                updatedSubscriptionModel.getPlanStart(),
                updatedSubscriptionModel.getPlanEnd(),
                updatedSubscriptionModel.getStatus().toString()
        );
    }

    public SubscriptionResponse createSubscription(SubscriptionRequest requestDTO) {
        ClientModel clientModel = clientRepository.findById(requestDTO.getClientId())
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
        ApplicationModel applicationModel = applicationRepository.findById(requestDTO.getApplicationId())
                .orElseThrow(() -> new IllegalArgumentException("Application not found"));

        Subscription subscription = new Subscription();
        subscription.setPlanStart(LocalDate.now());
        subscription.setPlanEnd(LocalDate.now().plusDays(30));
        subscription.setStatus(SubscriptionStatus.ACTIVE);
        subscription.setClient(Client.fromClientModel(clientModel));
        subscription.setApplication(Application.fromApplicationModel(applicationModel));

        SubscriptionModel subscriptionModel = subscriptionRepository.save(Subscription.toSubscriptionModel(subscription));

        return new SubscriptionResponse(
                subscriptionModel.getSubscriptionIdentificationCode(),
                subscriptionModel.getPlanStart(),
                subscriptionModel.getPlanEnd(),
                subscriptionModel.getStatus().toString()
        );
    }

    public Optional<SubscriptionModel> getSubscriptionById(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId);
    }
}
