package com.parking.parkly.service;

import com.parking.parkly.model.Slot;
import com.parking.parkly.repository.ParkingRepository;
import com.parking.parkly.repository.SlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SlotService {

    private final SlotRepository slotRepository;
    private final ParkingRepository parkingRepository;


    public Slot createSlot(Slot slot) {

        parkingRepository.findById(slot.getParkingId())
                .orElseThrow(() -> new RuntimeException("Parking not found"));

        return slotRepository.save(slot);
    }

    public Slot getSlotById(String slotId) {

        return slotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));
    }

    public List<Slot> getSlotsByParkingId(String parkingId) {

        parkingRepository.findById(parkingId)
                .orElseThrow(() -> new RuntimeException("Parking not found"));

        return slotRepository.findByParkingId(parkingId);
    }

    public Slot updateSlotStatus(String slotId, String status) {

        Slot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        slot.setStatus(status);

        return slotRepository.save(slot);
    }

    public void deleteSlot(String slotId) {

        Slot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        slotRepository.delete(slot);
    }





}