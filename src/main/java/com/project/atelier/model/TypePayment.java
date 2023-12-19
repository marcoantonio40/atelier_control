package com.project.atelier.model;

import lombok.Getter;

@Getter
public enum TypePayment {
    MONEY("money"),
    CARD("cash");

    private final String type;

    TypePayment(String type){
        this.type = type;
    }
}
