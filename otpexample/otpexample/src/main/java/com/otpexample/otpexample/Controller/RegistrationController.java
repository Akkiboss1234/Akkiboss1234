package com.otpexample.otpexample.Controller;



import com.otpexample.otpexample.Entity.User;
import com.otpexample.otpexample.Service.EmailService;
import com.otpexample.otpexample.Service.EmailVerificationService;
import com.otpexample.otpexample.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private UserService userService;
 @Autowired
    private EmailService emailService;
 @Autowired
 private EmailVerificationService emailVerificationService;
 @PostMapping("/register")
    public Map<String ,String> registerUser(@RequestBody User user){
//register the user without emailVerification

        User registerUser = userService.registerUser(user);



   emailService.sendOtpEmail(user.getEmail());



   Map<String ,String> response=new HashMap();
response.put("status","success");
response.put("message","User registered sucessfully.Check your email verification");

     return response;

}
@PostMapping("/verify-otp")
  public Map<String,String>  verifyOtp(@RequestParam String email,@RequestParam String otp) {
     return emailVerificationService.verifyotp(email,otp);
}
}