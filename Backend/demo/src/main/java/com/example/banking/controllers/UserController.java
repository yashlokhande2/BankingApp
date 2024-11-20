package com.example.banking.controllers;

import com.example.banking.models.User;
import com.example.banking.services.UserService;
import com.example.banking.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired    
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> dbUser = userService.findByEmail(user.getEmail());
        if (dbUser.isPresent() && dbUser.get().getPassword().equals(user.getPassword())) {
            String token = jwtUtils.generateToken(user.getEmail());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }
}