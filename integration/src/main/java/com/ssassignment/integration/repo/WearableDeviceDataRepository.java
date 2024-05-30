package com.ssassignment.integration.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ssassignment.integration.model.WearableDeviceData;

import java.util.List;

public interface WearableDeviceDataRepository extends JpaRepository<WearableDeviceData, Long> {
    List<WearableDeviceData> findByUserId(Long userId);
}

