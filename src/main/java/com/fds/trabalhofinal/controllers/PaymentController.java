package com.fds.trabalhofinal.controllers;

import com.fds.trabalhofinal.services.useCases.PaymentServices;
import com.fds.trabalhofinal.domain.models.PaymentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentServices paymentServices;

    @Autowired
    public PaymentController(PaymentServices paymentServices) {
        this.paymentServices = paymentServices;
    }

    @PostMapping
    public ResponseEntity<PaymentModel> registerPayment(
            @RequestParam double pricePaid,
            @RequestParam double monthlyCost,
            @RequestParam(required = false) String promotionalCode) {

        PaymentModel payment = paymentServices.registerPayment(pricePaid, monthlyCost, promotionalCode);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/subscription/{subscriptionId}")
    public ResponseEntity<List<PaymentModel>> listPaymentsBySubscription(@PathVariable Long subscriptionId) {
        List<PaymentModel> payments = paymentServices.listPaymentsBySubscription(subscriptionId);
        return ResponseEntity.ok(payments);
    }
}
