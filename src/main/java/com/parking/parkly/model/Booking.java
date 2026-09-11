package com.parking.parkly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String user_id;

    private String slot_id;

    private String vehicle_id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private BigDecimal amount;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private BookingStatus  status;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


}
