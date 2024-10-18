package com.ankur.bms.paymentservice.services;


import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;


public class StripePaymentService implements PaymentService {

    public String createPaymentLink(String orderId) {
        return "Payment link created for order id: " + orderId;
    }

    public String getPaymentStatus(String paymentId) {
        return "Payment status for payment id: " + paymentId;
    }
}
