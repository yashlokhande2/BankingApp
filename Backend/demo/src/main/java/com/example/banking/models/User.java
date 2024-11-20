package com.example.banking.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;
        private String email;

        @Column(nullable = false)
        private String password;

        private String role; // Example: "USER" or "ADMIN"
}

