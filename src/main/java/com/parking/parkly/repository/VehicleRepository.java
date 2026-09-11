package com.parking.parkly.repository;

import com.parking.parkly.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,String > {
}
