package com.parking.parkly.repository;

import com.parking.parkly.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,String > {
}
