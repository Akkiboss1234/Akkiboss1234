package com.otpexample.otpexample.Service;

import com.otpexample.otpexample.Entity.User;
import com.otpexample.otpexample.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user){
        //save the userdata to database
      return userRepository.save(user);


    }


    public User getUserByEmail(String email) {
      User user=  userRepository.findByEmail(email);
      return user;
    }

    public void verifyEmail(User user) {
        user.setEmailVerified(true);
        userRepository.save(user);
    }
}
