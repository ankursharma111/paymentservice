package com.ankur.bms.paymentservice.configs;


import com.razorpay.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
public class RazorPayConfig {

    @Value("${razorpay.key_id}")
    private String razorpayKeyId;

    @Value("${razorpay.key_secret}")
    private String razorpaySecret;


    @Bean
    public RazorpayClient createRazorPayClient() throws RazorpayException {

        return new RazorpayClient(
                razorpayKeyId, razorpaySecret);

    }
}
