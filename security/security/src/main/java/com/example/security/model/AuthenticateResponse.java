package com.example.security.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AuthenticateResponse {
    private String token;
}
