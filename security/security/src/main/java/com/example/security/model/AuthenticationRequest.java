package com.example.security.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
