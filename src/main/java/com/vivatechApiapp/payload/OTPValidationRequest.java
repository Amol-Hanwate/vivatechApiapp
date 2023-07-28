package com.vivatechApiapp.payload;

import lombok.Data;

@Data
public class OTPValidationRequest {
	
    private String email;
    private String otp;

}

