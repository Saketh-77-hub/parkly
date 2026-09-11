package com.parking.parkly.service;

import com.parking.parkly.model.Booking;
import com.parking.parkly.model.BookingStatus;
import com.parking.parkly.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final SlotLockService slotLockService;

    public Booking createBooking(Booking booking) {

        booking.setStartTime(LocalDateTime.now());

        boolean locked = slotLockService.lockSlot(
                booking.getSlot_id(),
                booking.getUser_id()
        );

        if (!locked) {
            throw new RuntimeException("Slot is currently being booked by another user");
        }

        booking.setStatus(BookingStatus.PENDING);

        return bookingRepository.save(booking);
    }

    public Booking getBookingById(String bookingId) {

        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking updateBookingStatus(
            String bookingId,
            String status
    ) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        BookingStatus newStatus = BookingStatus.valueOf(status);

        booking.setStatus(newStatus);

        if (newStatus == BookingStatus.CONFIRMED) {
            slotLockService.releaseSlot(booking.getSlot_id());
        }

        return bookingRepository.save(booking);
    }

    public void cancelBooking(String bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(BookingStatus.CANCELLED);

        slotLockService.releaseSlot(booking.getSlot_id());

        bookingRepository.save(booking);
    }
}