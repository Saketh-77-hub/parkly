package com.parking.parkly.controller;

import com.parking.parkly.model.Slot;
import com.parking.parkly.service.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
@RequiredArgsConstructor
public class SlotController {

    private final SlotService slotService;

    @PostMapping
    public ResponseEntity<Slot> createSlot(
            @RequestBody Slot slot
    ) {
        return ResponseEntity.ok(
                slotService.createSlot(slot)
        );
    }

    @GetMapping("/{slotId}")
    public ResponseEntity<Slot> getSlotById(
            @PathVariable String slotId
    ) {
        return ResponseEntity.ok(
                slotService.getSlotById(slotId)
        );
    }

    @GetMapping("/parking/{parkingId}")
    public ResponseEntity<List<Slot>> getSlotsByParkingId(
            @PathVariable String parkingId
    ) {
        return ResponseEntity.ok(
                slotService.getSlotsByParkingId(parkingId)
        );
    }

    @PutMapping("/{slotId}/status")
    public ResponseEntity<Slot> updateSlotStatus(
            @PathVariable String slotId,
            @RequestParam String status
    ) {
        return ResponseEntity.ok(
                slotService.updateSlotStatus(slotId, status)
        );
    }

    @DeleteMapping("/{slotId}")
    public ResponseEntity<Void> deleteSlot(
            @PathVariable String slotId
    ) {
        slotService.deleteSlot(slotId);

        return ResponseEntity.noContent().build();
    }
}