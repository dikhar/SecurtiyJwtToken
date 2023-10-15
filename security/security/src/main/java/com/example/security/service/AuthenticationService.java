package com.example.security.service;

import com.example.security.confi.JwtService;
import com.example.security.entity.Role;
import com.example.security.entity.UserData;
import com.example.security.model.AuthenticateResponse;
import com.example.security.model.AuthenticationRequest;
import com.example.security.model.RegisterRequest;
import com.example.security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;
    public AuthenticateResponse register(RegisterRequest request) {
        var userData = UserData.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname() )
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepo.save(userData);
        var JwtToken =jwtService.generateToken(userData);
        return AuthenticateResponse.builder()
                .token(JwtToken)
                .build();
    }

    public AuthenticateResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail()
                        ,request.getPassword()
                )
        );
        var user = userRepo.findByEmail(request.getEmail())
                .orElseThrow();
        var JwtToken =jwtService.generateToken(user);
        return AuthenticateResponse.builder()
                .token(JwtToken)
                .build();
    }
}
