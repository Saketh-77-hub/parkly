package com.parking.parkly.service;

import com.parking.parkly.model.Parking;
import com.parking.parkly.repository.ParkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public Parking createParking(Parking parking) {

        return parkingRepository.save(parking);
    }

    public Parking getParkingById(String parkingId) {

        return parkingRepository.findById(parkingId)
                .orElseThrow(() -> new RuntimeException("Parking not found"));
    }

    public List<Parking> getAllParkings() {

        return parkingRepository.findAll();
    }

    public void deleteParking(String parkingId) {

        Parking parking = parkingRepository.findById(parkingId)
                .orElseThrow(() -> new RuntimeException("Parking not found"));

        parkingRepository.delete(parking);
    }
}