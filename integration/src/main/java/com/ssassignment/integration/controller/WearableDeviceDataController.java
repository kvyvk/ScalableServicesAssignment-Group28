package com.ssassignment.integration.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssassignment.integration.model.WearableDeviceData;
import com.ssassignment.integration.repo.WearableDeviceDataRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wearable-data")
@CrossOrigin(origins = "http://localhost:3000")
public class WearableDeviceDataController {

    @Autowired
    private WearableDeviceDataRepository wearableDeviceDataRepository;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WearableDeviceData>> getDataByUserId(@PathVariable Long userId) {
        List<WearableDeviceData> data = wearableDeviceDataRepository.findByUserId(userId);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addWearableData(@RequestBody WearableDeviceData data) {
        WearableDeviceData savedData = wearableDeviceDataRepository.save(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedData);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateWearableData(@PathVariable Long id, @RequestBody WearableDeviceData updatedData) {
        Optional<WearableDeviceData> optionalData = wearableDeviceDataRepository.findById(id);
        if (!optionalData.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found");
        }

        WearableDeviceData existingData = optionalData.get();
        existingData.setDeviceType(updatedData.getDeviceType());
        existingData.setDeviceId(updatedData.getDeviceId());
        existingData.setDataType(updatedData.getDataType());
        existingData.setDataValue(updatedData.getDataValue());
        existingData.setTimestamp(updatedData.getTimestamp());

        WearableDeviceData savedData = wearableDeviceDataRepository.save(existingData);
        return ResponseEntity.ok(savedData);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWearableData(@PathVariable Long id) {
        Optional<WearableDeviceData> optionalData = wearableDeviceDataRepository.findById(id);
        if (!optionalData.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found");
        }

        wearableDeviceDataRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Data deleted");
    }
}
