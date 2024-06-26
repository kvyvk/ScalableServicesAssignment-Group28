package com.ssassignment.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssassignment.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

