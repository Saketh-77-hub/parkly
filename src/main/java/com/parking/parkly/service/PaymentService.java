package com.parking.parkly.service;

import com.parking.parkly.model.Booking;
import com.parking.parkly.model.BookingStatus;
import com.parking.parkly.model.Payment;
import com.parking.parkly.model.PaymentStatus;
import com.parking.parkly.repository.BookingRepository;
import com.parking.parkly.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;
    private final SlotLockService slotLockService;

    public Payment makePayment(String bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() ->
                        new RuntimeException("Booking not found"));

        if (booking.getStatus() != BookingStatus.PENDING) {
            throw new RuntimeException(
                    "Booking is not pending");
        }

        Payment payment = new Payment();

        payment.setBookingId(bookingId);
        payment.setAmount(booking.getAmount());
        payment.setPaymentMethod("CARD");
        payment.setStatus(PaymentStatus.SUCCESS);
        payment.setCreatedAt(LocalDateTime.now());

        Payment savedPayment =
                paymentRepository.save(payment);

        booking.setStatus(BookingStatus.CONFIRMED);
        bookingRepository.save(booking);

        slotLockService.releaseSlot(
                booking.getSlot_id()
        );

        return savedPayment;
    }
}