package com.ssassignment.workoutplan.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssassignment.workoutplan.model.WorkoutPlan;
import com.ssassignment.workoutplan.repo.WorkoutPlanRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workoutplans")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    // Get all pre-designed workout plans
    @GetMapping("/pre-designed")
    public ResponseEntity<List<WorkoutPlan>> getPreDesignedWorkoutPlans() {
        List<WorkoutPlan> workoutPlans = workoutPlanRepository.findByUserIdIsNull();
        return ResponseEntity.ok(workoutPlans);
    }

    // Get workout plans by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WorkoutPlan>> getWorkoutPlansByUserId(@PathVariable Long userId) {
        List<WorkoutPlan> workoutPlans = workoutPlanRepository.findByUserId(userId);
        return ResponseEntity.ok(workoutPlans);
    }

    // Add a new workout plan
    @PostMapping("/add")
    public ResponseEntity<?> addWorkoutPlan(@RequestBody WorkoutPlan workoutPlan) {
        WorkoutPlan savedWorkoutPlan = workoutPlanRepository.save(workoutPlan);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWorkoutPlan);
    }

    // Update an existing workout plan
    @PutMapping("/update/{workoutPlanId}")
    public ResponseEntity<?> updateWorkoutPlan(@PathVariable Long workoutPlanId, @RequestBody WorkoutPlan updatedWorkoutPlan) {
        Optional<WorkoutPlan> optionalWorkoutPlan = workoutPlanRepository.findById(workoutPlanId);
        if (!optionalWorkoutPlan.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workout Plan not found");
        }

        WorkoutPlan existingWorkoutPlan = optionalWorkoutPlan.get();
        existingWorkoutPlan.setName(updatedWorkoutPlan.getName());
        existingWorkoutPlan.setDescription(updatedWorkoutPlan.getDescription());
        existingWorkoutPlan.setExercises(updatedWorkoutPlan.getExercises());

        WorkoutPlan savedWorkoutPlan = workoutPlanRepository.save(existingWorkoutPlan);
        return ResponseEntity.ok(savedWorkoutPlan);
    }

    // Delete a workout plan
    @DeleteMapping("/delete/{workoutPlanId}")
    public ResponseEntity<?> deleteWorkoutPlan(@PathVariable Long workoutPlanId) {
        Optional<WorkoutPlan> optionalWorkoutPlan = workoutPlanRepository.findById(workoutPlanId);
        if (!optionalWorkoutPlan.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workout Plan not found");
        }

        workoutPlanRepository.deleteById(workoutPlanId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Workout Plan deleted");
    }
}
