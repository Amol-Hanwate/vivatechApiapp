package com.vivatechApiapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivatechApiapp.payload.SmsRequest;
import com.vivatechApiapp.services.TwilioSmsService;
import com.vivatechApiapp.util.OTPGenerator;

@RestController
public class SmsController {

    private final TwilioSmsService twilioSmsService;

    @Autowired
    public SmsController(TwilioSmsService twilioSmsService) {
        this.twilioSmsService = twilioSmsService;
    }

    //http://localhost:8080/send-sms
    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequest smsRequest) {
        try {
            twilioSmsService.sendSms(smsRequest.getToPhoneNumber(), smsRequest.getMessageBody());
            return ResponseEntity.ok("SMS sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send SMS: " + e.getMessage());
        }
    }
    
    //http://localhost:8080/send-otp
    
    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestBody SmsRequest smsRequest) {
        try {
            // Generate an OTP
            String otp = OTPGenerator.generateOTP(); // You need to implement the OTP generation logic

            // Create the message body with the OTP
            String messageBody = "Your OTP is: " + otp;

            // Save the OTP with the user's phone number for verification later (you'll need a data store for this)

            // Send the OTP via SMS
            twilioSmsService.sendSms(smsRequest.getToPhoneNumber(), messageBody);

            return ResponseEntity.ok("OTP sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send OTP: " + e.getMessage());
        }
    }
}

