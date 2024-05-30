package com.ssassignment.socialshare.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ssassignment.socialshare.model.SocialShare;

import java.util.List;

public interface SocialShareRepository extends JpaRepository<SocialShare, Long> {
    List<SocialShare> findByUserId(Long userId);
}
