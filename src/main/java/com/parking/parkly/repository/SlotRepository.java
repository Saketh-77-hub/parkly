package com.parking.parkly.repository;

import com.parking.parkly.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, String> {

    List<Slot> findByParkingId(String parkingId);
}