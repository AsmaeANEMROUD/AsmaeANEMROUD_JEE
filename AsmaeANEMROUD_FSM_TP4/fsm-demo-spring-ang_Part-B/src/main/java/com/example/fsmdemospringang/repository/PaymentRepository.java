package com.example.fsmdemospringang.repository;

import com.example.fsmdemospringang.entities.Payment;
import com.example.fsmdemospringang.entities.PaymentStatus;
import com.example.fsmdemospringang.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
}
