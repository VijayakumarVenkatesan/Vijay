package com.example.ecommerce_backend.security;

import com.example.ecommerce_backend.model.Users;
import com.example.ecommerce_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users =userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found"));

        return new User(users.getEmail(),users.getPassword(), List.of(()->"ROLE_USER"));
    }
}
