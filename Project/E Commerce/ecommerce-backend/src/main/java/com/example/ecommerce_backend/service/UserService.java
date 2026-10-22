package com.example.ecommerce_backend.service;

import com.example.ecommerce_backend.model.Users;
import com.example.ecommerce_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public Users createUser(Users users){
        if(userRepo.existsByEmail(users.getEmail())){
            throw new RuntimeException("Email already exist");
        }
        return userRepo.save(users);
    }
}
