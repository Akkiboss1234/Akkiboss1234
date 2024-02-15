package com.otpexample.otpexample.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import static com.otpexample.otpexample.Service.EmailVerificationService.emailOtpMapping;
@Service
public class EmailService {
    @Autowired
private JavaMailSender javaMailSender;
    @Autowired
private UserService UserService;
@Autowired
    public EmailService(JavaMailSender javaMailSender,UserService userService){

        this.javaMailSender=javaMailSender;
        this.UserService= userService;
    }
    public String generateOtp() {
        return String.format("%06d",new java.util.Random().nextInt(1000000));
    }

    public void sendOtpEmail(String email){

        String otp = generateOtp();
        //save the otp for later verification
        emailOtpMapping.put(email,otp);
        sendEmail(email, "otp for email verification","Your otp is"+otp);

    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your email.gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }
}
