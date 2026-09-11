package com.parking.parkly.service;


import com.parking.parkly.model.Vehicle;
import com.parking.parkly.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(Vehicle vehicle) {

        return vehicleRepository.save(vehicle);
    }

    public Vehicle getVehicleById(String vehicleId) {

        return vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }
}
