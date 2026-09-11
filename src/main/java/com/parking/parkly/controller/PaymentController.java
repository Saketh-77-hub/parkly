package com.parking.parkly.controller;

import com.parking.parkly.model.Payment;
import com.parking.parkly.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/{bookingId}")
    public ResponseEntity<Payment> makePayment(
            @PathVariable String bookingId) {

        return ResponseEntity.ok(
                paymentService.makePayment(bookingId)
        );
    }
}