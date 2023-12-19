package com.project.atelier.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class OrderRequest {

    @NotNull
    private String customerId;

    @NotNull
    private String userId;

    @NotNull
    private Double value;

    @NotNull
    private String typePayment;

    @NotNull
    private boolean isPaid;

    @NotNull
    private int installments;

}
