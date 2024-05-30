package com.ssassignment.socialshare.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssassignment.socialshare.model.SocialShare;
import com.ssassignment.socialshare.repo.SocialShareRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/social-share")
@CrossOrigin(origins = "http://localhost:3000")
public class SocialShareController {

    @Autowired
    private SocialShareRepository socialShareRepository;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SocialShare>> getSocialSharesByUserId(@PathVariable Long userId) {
        List<SocialShare> socialShares = socialShareRepository.findByUserId(userId);
        return ResponseEntity.ok(socialShares);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addSocialShare(@RequestBody SocialShare socialShare) {
        SocialShare savedSocialShare = socialShareRepository.save(socialShare);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSocialShare);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSocialShare(@PathVariable Long id, @RequestBody SocialShare updatedSocialShare) {
        Optional<SocialShare> optionalSocialShare = socialShareRepository.findById(id);
        if (!optionalSocialShare.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Social Share not found");
        }

        SocialShare existingSocialShare = optionalSocialShare.get();
        existingSocialShare.setAchievement(updatedSocialShare.getAchievement());
        existingSocialShare.setPlatform(updatedSocialShare.getPlatform());

        SocialShare savedSocialShare = socialShareRepository.save(existingSocialShare);
        return ResponseEntity.ok(savedSocialShare);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSocialShare(@PathVariable Long id) {
        Optional<SocialShare> optionalSocialShare = socialShareRepository.findById(id);
        if (!optionalSocialShare.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Social Share not found");
        }

        socialShareRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Social Share deleted");
    }
}
