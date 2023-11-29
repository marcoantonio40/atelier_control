package com.project.atelier.dto.request;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
public class CustomerRequest {

    @Email
    private String email;

    @NotNull
    @Size(min = 8, max = 100)
    private String name;

    @NotNull
    @Size(min = 11, max = 14)
    private String cpfOrCnpj;

    @NotNull
    private String phone;

    @NotBlank
    private LocalDateTime birthDay;

    @NotBlank
    private AddressRequest address;
}
