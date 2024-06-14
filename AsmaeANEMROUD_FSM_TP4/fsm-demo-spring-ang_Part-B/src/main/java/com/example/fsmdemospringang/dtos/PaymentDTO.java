package com.example.fsmdemospringang.dtos;

import com.example.fsmdemospringang.entities.PaymentStatus;
import com.example.fsmdemospringang.entities.PaymentType;
import com.example.fsmdemospringang.entities.Student;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class PaymentDTO {
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;
}
