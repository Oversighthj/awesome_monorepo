package com.example.demo.controller;

import com.example.demo.api.PaymentsApi;
import com.example.demo.model.PaymentRequestDTO;
import com.example.demo.model.PaymentResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;              // ← استعمل java.net.URI
import java.time.OffsetDateTime;

@RestController
public class PaymentController implements PaymentsApi {

    @Override
    public ResponseEntity<PaymentResponseDTO> initiatePayment(PaymentRequestDTO body) {
        PaymentResponseDTO resp = new PaymentResponseDTO()
            .checkoutUrl(URI.create("https://checkout.mock"))   // ← URI بدلاً من String
            .providerSessionId("sess_123")
            .expiresAt(OffsetDateTime.now().plusMinutes(30));

        return ResponseEntity.ok(resp);
    }
}
