package com.project.atelier.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class OrderRequest {

    @NotNull
    private String customerId;

}