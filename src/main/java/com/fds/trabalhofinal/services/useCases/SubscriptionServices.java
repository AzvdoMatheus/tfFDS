package com.fds.trabalhofinal.services.useCases;

import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import com.fds.trabalhofinal.domain.models.ApplicationModel;
import com.fds.trabalhofinal.domain.models.ClientModel;
import com.fds.trabalhofinal.domain.models.SubscriptionModel;
import com.fds.trabalhofinal.domain.repository.IAppRepository;
import com.fds.trabalhofinal.domain.repository.IClientRepository;
import com.fds.trabalhofinal.domain.repository.ISubscriptionRepository;
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

    public SubscriptionModel createSubscription(Long clientId, Long applicationId) {
        ClientModel client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        ApplicationModel application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new IllegalArgumentException("Application not found"));

        SubscriptionModel subscriptionModel = new SubscriptionModel();
        subscriptionModel.setPlanStart(LocalDate.now());
        subscriptionModel.setPlanEnd(LocalDate.now().plusDays(37));
        subscriptionModel.setStatus(SubscriptionStatus.ACTIVE);

        return subscriptionRepository.save(subscriptionModel);
    }

    public void cancelSubscription(Long subscriptionId) {
        SubscriptionModel subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found"));

        subscription.setStatus(SubscriptionStatus.CANCELED);

        subscriptionRepository.save(subscription);
    }

    public List<Map<String, Object>> getSubscriptionsByClientId(Long clientId) {
        List<SubscriptionModel> subscriptions = subscriptionRepository.findByClientId(clientId);

        return subscriptions.stream()
                .map(subscription -> {
                    Map<String, Object> subscriptionData = new HashMap<>();
                    subscriptionData.put("codigoAssinatura", subscription.getSubscriptionIdentificationCode());
                    subscriptionData.put("dataInicio", subscription.getPlanStart());
                    subscriptionData.put("dataFim", subscription.getPlanEnd());
                    subscriptionData.put("status", subscription.getStatus() == SubscriptionStatus.ACTIVE ? "ACTIVE" : "CANCELED");
                    return subscriptionData;
                })
                .collect(Collectors.toList());
    }

    public Optional<SubscriptionModel> getSubscriptionById(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId);
    }
}
