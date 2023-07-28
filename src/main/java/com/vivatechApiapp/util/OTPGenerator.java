package com.vivatechApiapp.util;


import java.util.Random;

public class OTPGenerator {

    // Length of the OTP
    private static final int OTP_LENGTH = 6;

    public static String generateOTP() {
        // Generate a random numeric OTP
        Random random = new Random();
        StringBuilder otpBuilder = new StringBuilder();

        for (int i = 0; i < OTP_LENGTH; i++) {
            int digit = random.nextInt(10); // Generate a random number between 0 and 9 (inclusive)
            otpBuilder.append(digit);
        }

        return otpBuilder.toString();
    }
}

