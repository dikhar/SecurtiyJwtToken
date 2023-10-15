package com.example.security.controller;

import com.example.security.model.AuthenticateResponse;
import com.example.security.model.AuthenticationRequest;
import com.example.security.model.RegisterRequest;
import com.example.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticateResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateResponse> authenticateUser(@RequestBody AuthenticationRequest request)
    {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
