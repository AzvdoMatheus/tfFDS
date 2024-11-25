package com.fds.trabalhofinal.controllers;

import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import com.fds.trabalhofinal.domain.models.ClientModel;
import com.fds.trabalhofinal.domain.models.SubscriptionModel;
import com.fds.trabalhofinal.services.useCases.ClientServices;
import com.fds.trabalhofinal.services.useCases.SubscriptionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/servcad")
@CrossOrigin(origins = "*")
public class SubscriptionController {

    private final SubscriptionServices subscriptionServices;
    private final ClientServices clientServices;

    @Autowired
    public SubscriptionController(SubscriptionServices subscriptionServices, ClientServices clientServices) {
        this.subscriptionServices = subscriptionServices;
        this.clientServices = clientServices;
    }

    @GetMapping("/subscriptions")
    public List<SubscriptionModel> getAllSubscriptions() {
        return subscriptionServices.listAllSubscriptions();
    }

    @GetMapping("/subscriptions/{id}")
    public SubscriptionModel getSubscriptionById(@PathVariable Long id) {
        return subscriptionServices.getSubscriptionById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subscription not found."));
    }

    @PostMapping("/subscriptions/new/")
    public ResponseEntity<Map<String, Object>> createSubscription(
            @RequestParam Long clientId,
            @RequestParam Long applicationId) {

        SubscriptionModel createdSubscription = subscriptionServices.createSubscription(clientId, applicationId);

        Map<String, Object> response = new HashMap<>();
        response.put("subscriptionId", createdSubscription.getSubscriptionIdentificationCode());
        response.put("planStart", createdSubscription.getPlanStart());
        response.put("planEnd", createdSubscription.getPlanEnd());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/subscriptions/{id}/cancel")
    public String cancelSubscription(@PathVariable Long id) {
        subscriptionServices.cancelSubscription(id);
        return "Subscription canceled successfully.";
    }

    @GetMapping("/subscriptions/info/{clientId}")
    public ResponseEntity<List<Map<String, Object>>> getSubscriptionsByClient(@PathVariable Long clientId) {
        List<Map<String, Object>> subscriptions = subscriptionServices.getSubscriptionsByClientId(clientId);

        if (subscriptions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(subscriptions);
    }

    @GetMapping("/subscriptions/status/{status}")
    public List<SubscriptionModel> filterByStatus(@PathVariable String status) {
        SubscriptionStatus subscriptionStatus = SubscriptionStatus.valueOf(status.toUpperCase());
        return subscriptionServices.listSubscriptionsByStatus(subscriptionStatus);
    }
}
