package com.example.security.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class RegisterRequest {
    private String firstname;
    private String lastname;

    private String email;

    private String password;
}
