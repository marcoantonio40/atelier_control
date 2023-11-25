package com.project.atelier.dto.request;

import com.project.atelier.model.TypeUser;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class UserRequest {

    @NotNull
    @Email
    private String login;

    @NotNull
    private String status;

    @NotBlank
    private String type;

    @NotNull
    @Size(min = 8, max = 100)
    private String name;

    @NotNull
    private String cpf;

    @NotNull
    private String phone;
}
