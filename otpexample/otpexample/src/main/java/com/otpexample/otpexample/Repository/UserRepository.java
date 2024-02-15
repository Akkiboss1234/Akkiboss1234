package com.otpexample.otpexample.Repository;

import com.otpexample.otpexample.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
