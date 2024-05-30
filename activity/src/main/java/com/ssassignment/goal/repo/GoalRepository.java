package com.ssassignment.goal.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssassignment.goal.model.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUserId(Long userId);
}
