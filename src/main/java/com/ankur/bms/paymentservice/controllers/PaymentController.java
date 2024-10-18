package com.ankur.bms.paymentservice.controllers;


import com.ankur.bms.paymentservice.dtos.*;
import com.ankur.bms.paymentservice.services.*;
import com.razorpay.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    RazorpayPaymentService razorpayPaymentService;

    public PaymentController(RazorpayPaymentService razorpayPaymentService) {
        this.razorpayPaymentService = razorpayPaymentService;
    }

    @PostMapping("/")
    public String createPaymentLink(@RequestBody CreatePaymentLinkRequestDtos requestDto) throws RazorpayException {

        String link = razorpayPaymentService.createPaymentLink(requestDto.getOrderId());

        return link;

    }

    @PostMapping("/webhook")
    public void handleWebhookEvent(@RequestBody Webhook webhook) {
        System.out.println(webhook.toString());;
    }
}
