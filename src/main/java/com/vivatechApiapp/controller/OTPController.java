package com.vivatechApiapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vivatechApiapp.entiry.User;
import com.vivatechApiapp.payload.OTPValidationRequest;
import com.vivatechApiapp.repository.UserRepository;

@RestController
public class OTPController {

    private final UserRepository userRepo;

    @Autowired
    public OTPController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/validate-otp")
    public ResponseEntity<String> validateOTP(@RequestBody OTPValidationRequest otpValidationRequest) {
        String email = otpValidationRequest.getEmail();
        String otp = otpValidationRequest.getOtp();

        User user = userRepo.findByEmail(email);
        if (user != null && user.getOtp().equals(otp)) {
            // The submitted OTP matches the stored OTP for the user
            // Perform any additional actions or validations as needed

            // Clear the stored OTP to prevent it from being used again
            user.setOtp(null);
            userRepo.save(user);

            return ResponseEntity.ok("OTP is valid");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP");
        }
    }
}
