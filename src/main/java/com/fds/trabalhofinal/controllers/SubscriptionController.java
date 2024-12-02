package com.fds.trabalhofinal.controllers;

import com.fds.trabalhofinal.controllers.DTOS.SubscriptionRequest;
import com.fds.trabalhofinal.controllers.DTOS.SubscriptionResponse;
import com.fds.trabalhofinal.domain.enums.SubscriptionStatus;
import com.fds.trabalhofinal.domain.models.ClientModel;
import com.fds.trabalhofinal.domain.models.PaymentModel;
import com.fds.trabalhofinal.domain.models.SubscriptionModel;
import com.fds.trabalhofinal.services.useCases.ClientServices;
import com.fds.trabalhofinal.services.useCases.PaymentServices;
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

    @Autowired
    public SubscriptionController(SubscriptionServices subscriptionServices) {
        this.subscriptionServices = subscriptionServices;
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

    @PostMapping("/subscriptions/{id}/cancel")
    public ResponseEntity<SubscriptionResponse> cancelSubscription(@PathVariable Long id) {
        SubscriptionResponse responseDTO = subscriptionServices.cancelSubscription(id);
        return ResponseEntity.ok(responseDTO);
    }
    @PostMapping("/subscriptions/new")
    public ResponseEntity<SubscriptionResponse> createSubscription(@RequestBody SubscriptionRequest requestDTO) {
        SubscriptionResponse responseDTO = subscriptionServices.createSubscription(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/subscriptions/status/{status}")
    public List<SubscriptionModel> filterByStatus(@PathVariable String status) {
        SubscriptionStatus subscriptionStatus = SubscriptionStatus.valueOf(status.toUpperCase());
        return subscriptionServices.listSubscriptionsByStatus(subscriptionStatus);
    }
}