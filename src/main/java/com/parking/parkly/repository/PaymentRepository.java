package com.parking.parkly.repository;

import com.parking.parkly.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    Optional<Payment> findByBookingId(String bookingId);

}
