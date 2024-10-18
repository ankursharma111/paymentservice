package com.ankur.bms.paymentservice.services;

import com.razorpay.*;

public interface PaymentService {


    public String createPaymentLink(String orderId) throws RazorpayException;

    public String getPaymentStatus(String paymentId);










}
