package com.ssassignment.progress.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssassignment.progress.model.Progress;
import com.ssassignment.progress.repo.ProgressRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "http://localhost:3000")
public class ProgressController {

    @Autowired
    private ProgressRepository progressRepository;

    // Get progress by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Progress>> getProgressByUserId(@PathVariable Long userId) {
        List<Progress> progressList = progressRepository.findByUserId(userId);
        return ResponseEntity.ok(progressList);
    }

    // Add a new progress entry
    @PostMapping("/add")
    public ResponseEntity<?> addProgress(@RequestBody Progress progress) {
        Progress savedProgress = progressRepository.save(progress);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProgress);
    }

    // Update an existing progress entry
    @PutMapping("/update/{progressId}")
    public ResponseEntity<?> updateProgress(@PathVariable Long progressId, @RequestBody Progress updatedProgress) {
        Optional<Progress> optionalProgress = progressRepository.findById(progressId);
        if (!optionalProgress.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Progress not found");
        }
        
        Progress existingProgress = optionalProgress.get();
        existingProgress.setValue(updatedProgress.getValue());
        existingProgress.setTimestamp(updatedProgress.getTimestamp());
        
        Progress savedProgress = progressRepository.save(existingProgress);
        return ResponseEntity.ok(savedProgress);
    }

    // Delete a progress entry
    @DeleteMapping("/delete/{progressId}")
    public ResponseEntity<?> deleteProgress(@PathVariable Long progressId) {
        Optional<Progress> optionalProgress = progressRepository.findById(progressId);
        if (!optionalProgress.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Progress not found");
        }
        
        progressRepository.deleteById(progressId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Progress deleted");
    }
}
