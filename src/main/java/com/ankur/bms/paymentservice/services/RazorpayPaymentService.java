package com.ankur.bms.paymentservice.services;

import com.razorpay.*;
import org.json.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;


@Service
@Primary
public class RazorpayPaymentService implements PaymentService {

    RazorpayClient razorpayClient;

    public RazorpayPaymentService(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;

    }

    public String createPaymentLink(String orderId) throws RazorpayException {

        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
        //paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", System.currentTimeMillis() + 16*60*1000);
        paymentLinkRequest.put("reference_id","TS1989");
        paymentLinkRequest.put("description","Payment for order no "+ orderId);
        JSONObject customer = new JSONObject();
        customer.put("ankur sharma","primeCustomer");
        customer.put("contact","9791666910");
        customer.put("email","cogentrohtas@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("Order_items","1 Iphone 15 pro max");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://example-callback-url.com/"); //
        //after payment razorpay will redirect to this url
        paymentLinkRequest.put("callback_method","get");
        
        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

        return payment.get("short_url");

    }

    public String getPaymentStatus(String paymentId) {
        return "Payment status for payment id: " + paymentId;
    }
}
