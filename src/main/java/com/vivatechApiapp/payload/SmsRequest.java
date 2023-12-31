package com.vivatechApiapp.payload;


public class SmsRequest {

    private String toPhoneNumber;
    private String messageBody;

    // Constructors, getters, and setters

    public SmsRequest() {
    }

    public SmsRequest(String toPhoneNumber, String messageBody) {
        this.toPhoneNumber = toPhoneNumber;
        this.messageBody = messageBody;
    }

    public String getToPhoneNumber() {
        return toPhoneNumber;
    }

    public void setToPhoneNumber(String toPhoneNumber) {
        this.toPhoneNumber = toPhoneNumber;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}

