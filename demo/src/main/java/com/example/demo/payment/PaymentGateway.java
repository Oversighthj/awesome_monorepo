package com.example.demo.payment;

import com.example.demo.model.PaymentRequestDTO;
import com.example.demo.model.PaymentResponseDTO;

/**
 * Abstraction over external payment providers (Stripe, PayPal …).
 */
public interface PaymentGateway {

    /**
     * Creates a checkout session with the provider and returns session info.
     */
    PaymentResponseDTO createCheckout(PaymentRequestDTO request);

    /**
     * Verifies that the payment session was successfully completed/paid.
     *
     * @param providerSessionId the session / payment_intent ID returned earlier
     * @return true if payment confirmed, false otherwise
     */
    boolean verify(String providerSessionId);
}
