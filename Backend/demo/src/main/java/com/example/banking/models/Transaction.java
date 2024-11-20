package com.example.banking.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Double amount;
    private String status; // PENDING, SUCCESS, FAILED
    private LocalDateTime timestamp = LocalDateTime.now();
}

