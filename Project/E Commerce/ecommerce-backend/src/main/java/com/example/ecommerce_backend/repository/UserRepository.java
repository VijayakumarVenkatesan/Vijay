package com.example.ecommerce_backend.repository;

import com.example.ecommerce_backend.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    boolean existsByEmail(String email);
    Optional<Users> findByName(String name);

    Optional<Users> findByEmail(String username);
}