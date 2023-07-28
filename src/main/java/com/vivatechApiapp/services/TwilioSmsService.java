package com.vivatechApiapp.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.vivatechApiapp.config.TwilioConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioSmsService {

    private final TwilioConfig twilioConfig;

    @Autowired
    public TwilioSmsService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
    }

    public void sendSms(String toPhoneNumber, String messageBody) {
        Message message = Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(twilioConfig.getPhoneNumber()),
                messageBody
        ).create();

        // You can handle the result of the message creation here if needed
        System.out.println("SMS sent with SID: " + message.getSid());
    }
}

