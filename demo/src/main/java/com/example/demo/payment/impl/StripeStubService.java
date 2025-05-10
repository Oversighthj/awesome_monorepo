package com.example.demo.payment.impl;

import com.example.demo.model.PaymentRequestDTO;
import com.example.demo.model.PaymentResponseDTO;
import com.example.demo.payment.PaymentGateway;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class StripeStubService implements PaymentGateway {

  @Override
  public PaymentResponseDTO createCheckout(PaymentRequestDTO req) {
    String sessionId = "sess_" + UUID.randomUUID();

    return new PaymentResponseDTO()
        .checkoutUrl(URI.create("https://stripe.stub/checkout/" + sessionId))
        .providerSessionId(sessionId)
        .expiresAt(OffsetDateTime.now().plusMinutes(30));
  }

  @Override
  public boolean verify(String providerSessionId) {
    return providerSessionId != null && providerSessionId.startsWith("sess_");
  }
}
