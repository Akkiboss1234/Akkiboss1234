package com.otpexample.otpexample.Service;

import com.otpexample.otpexample.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
@Service
public class EmailVerificationService {
  @Autowired
  private UserService userService;
  //here we store otp temperarory  in hashmap
  static final Map<String, String> emailOtpMapping = new HashMap<>();

  public Map<String, String> verifyotp(String email, String otp) {

    String storedOtp = emailOtpMapping.get(email);//get the value which one is store  it get email form hashmap and stores otp

    Map<String, String> response = new HashMap<>();
    if (storedOtp != null && storedOtp.equals(otp)) {

      User user = userService.getUserByEmail(email);//before stored otp check user is register or not

      if (storedOtp != null) {


        emailOtpMapping.remove(email);

        userService.verifyEmail(user);
        response.put("status", "Sucess");
        response.put("message", "Email verified successfully");


      } else {
        response.put("status", "error");
        response.put("message", "user not found");
      }
    } else {

      response.put("Status", "error");
      response.put("message", "Invalid otp");
    }
    return response;

  }

    }

