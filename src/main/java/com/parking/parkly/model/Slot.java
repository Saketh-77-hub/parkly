package com.parking.parkly.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String parkingId;

    private String slotNumber;

    private String slotType;

    private String status;
}