package com.project.atelier.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class AddressRequest {

    @NotNull
    @Size(min = 3, max = 30)
    private String street;

    @NotNull
    @Size(min = 1, max = 5)
    private String number;

    @NotNull
    @Size(min = 2, max = 30)
    private String neighborhood;

    @NotNull
    @Size(min = 8, max = 8)
    private String cep;

    @NotNull
    @Size(min = 3, max = 50)
    private String complement;


}
