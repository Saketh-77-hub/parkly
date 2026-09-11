package com.parking.parkly.controller;

import com.parking.parkly.model.Booking;
import com.parking.parkly.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(
            @RequestBody Booking booking
    ) {
        return ResponseEntity.ok(
                bookingService.createBooking(booking)
        );
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(
            @PathVariable String bookingId
    ) {
        return ResponseEntity.ok(
                bookingService.getBookingById(bookingId)
        );
    }

    @PutMapping("/{bookingId}/status")
    public ResponseEntity<Booking> updateBookingStatus(
            @PathVariable String bookingId,
            @RequestParam String status
    ) {
        return ResponseEntity.ok(
                bookingService.updateBookingStatus(
                        bookingId,
                        status
                )
        );
    }

    @PutMapping("/{bookingId}/cancel")
    public ResponseEntity<Void> cancelBooking(
            @PathVariable String bookingId
    ) {
        bookingService.cancelBooking(bookingId);

        return ResponseEntity.noContent().build();
    }
}