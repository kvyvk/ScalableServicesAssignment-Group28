package com.ssassignment.progress.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ssassignment.progress.model.Progress;

import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    List<Progress> findByUserId(Long userId);
}
