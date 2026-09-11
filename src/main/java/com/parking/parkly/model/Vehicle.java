package com.parking.parkly.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String user_id;

    private String vehicle_number;

    private String vehicle_type;
}
