package com.parking.parkly.controller;

import com.parking.parkly.model.Parking;
import com.parking.parkly.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parkings")
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    @PostMapping
    public ResponseEntity<Parking> createParking(
            @RequestBody Parking parking
    ) {
        return ResponseEntity.ok(
                parkingService.createParking(parking)
        );
    }

    @GetMapping("/{parkingId}")
    public ResponseEntity<Parking> getParkingById(
            @PathVariable String parkingId
    ) {
        return ResponseEntity.ok(
                parkingService.getParkingById(parkingId)
        );
    }

    @GetMapping
    public ResponseEntity<List<Parking>> getAllParkings() {

        return ResponseEntity.ok(
                parkingService.getAllParkings()
        );
    }

    @DeleteMapping("/{parkingId}")
    public ResponseEntity<Void> deleteParking(
            @PathVariable String parkingId
    ) {
        parkingService.deleteParking(parkingId);

        return ResponseEntity.noContent().build();
    }
}