package com.example.security.repo;

import com.example.security.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserData,Integer> {
    Optional<UserData> findByEmail(String email);
}
