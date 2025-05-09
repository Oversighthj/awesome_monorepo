package com.example.demo.controller;

import com.example.demo.api.PaymentsApi;
import com.example.demo.model.PaymentRequestDTO;
import com.example.demo.model.PaymentResponseDTO;
import com.example.demo.payment.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")          // يتوافق مع base-path في openapi.yaml
@RequiredArgsConstructor
public class PaymentController implements PaymentsApi {

    private final PaymentGateway paymentGateway;   // يُحقن StripeStubService

    /** POST /payments/checkout */
    @Override
    public ResponseEntity<PaymentResponseDTO> initiatePayment(PaymentRequestDTO body) {
        PaymentResponseDTO resp = paymentGateway.createCheckout(body);
        return ResponseEntity.ok(resp);
    }
}
