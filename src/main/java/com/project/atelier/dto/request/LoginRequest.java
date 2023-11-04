package com.project.atelier.dto.request;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;

@Data
public class LoginRequest {
    @NonNull
    @Size(min = 8, max = 10)
    private String login;

    @NonNull
    @Size(min = 8, max = 10)
    private String password;
}
