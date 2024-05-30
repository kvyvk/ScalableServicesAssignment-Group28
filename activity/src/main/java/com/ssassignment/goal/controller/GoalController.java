package com.ssassignment.goal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssassignment.goal.model.Goal;
import com.ssassignment.goal.repo.GoalRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin(origins = "http://localhost:3000")
public class GoalController {

    @Autowired
    private GoalRepository goalRepository;

    // Get goals by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Goal>> getGoalsByUserId(@PathVariable Long userId) {
        List<Goal> goals = goalRepository.findByUserId(userId);
        return ResponseEntity.ok(goals);
    }

    // Add a new goal
    @PostMapping("/add")
    public ResponseEntity<?> addGoal(@RequestBody Goal goal) {
        // Perform basic validation
        // Save the goal
        Goal savedGoal = goalRepository.save(goal);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGoal);
    }

    // Update an existing goal
    @PutMapping("/update/{goalId}")
    public ResponseEntity<?> updateGoal(@PathVariable Long goalId, @RequestBody Goal updatedGoal) {
        Optional<Goal> optionalGoal = goalRepository.findById(goalId);
        if (!optionalGoal.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Goal not found");
        }
        
        Goal existingGoal = optionalGoal.get();
        existingGoal.setType(updatedGoal.getType());
        existingGoal.setTargetValue(updatedGoal.getTargetValue());
        existingGoal.setCurrentValue(updatedGoal.getCurrentValue());
        
        Goal savedGoal = goalRepository.save(existingGoal);
        return ResponseEntity.ok(savedGoal);
    }

    // Delete a goal
    @DeleteMapping("/delete/{goalId}")
    public ResponseEntity<?> deleteGoal(@PathVariable Long goalId) {
        Optional<Goal> optionalGoal = goalRepository.findById(goalId);
        if (!optionalGoal.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Goal not found");
        }
        
        goalRepository.deleteById(goalId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Goal deleted");
    }

}
