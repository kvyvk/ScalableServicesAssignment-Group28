package com.ssassignment.workoutplan.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ssassignment.workoutplan.model.WorkoutPlan;

import java.util.List;

public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, Long> {
    List<WorkoutPlan> findByUserId(Long userId);
    List<WorkoutPlan> findByUserIdIsNull(); // For pre-designed workout plans
}

