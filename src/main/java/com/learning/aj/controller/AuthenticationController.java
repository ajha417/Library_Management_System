package com.learning.aj.controller;

import com.learning.aj.dto.RegisterRequest;
import com.learning.aj.model.Users;
import com.learning.aj.repository.UserRepository;
import com.learning.aj.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        ResponseEntity<?> responseEntity = null;
        try {
            //check if user already exists
            if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
                responseEntity = ResponseEntity.badRequest().body("User already exists");
            }
            Users user = new Users();
            user.setEmail(registerRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            user.setRole(registerRequest.getRole());
            user.setBorrowingHistories(new ArrayList<>());
            userRepository.save(user);

            //send welcome email
            emailService.sendEmail(user.getEmail(), user.getName());
            responseEntity = ResponseEntity.ok("User registered successfully");
            log.info("User registered successfully");
        } catch (Exception e) {
            log.error("Error while registering user", e);
            responseEntity = ResponseEntity.badRequest().body("Error while registering user:" + e.getMessage());
        }
        return responseEntity;
    }
}
