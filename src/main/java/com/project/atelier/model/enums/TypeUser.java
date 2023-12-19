package com.project.atelier.model.enums;

import lombok.Getter;

@Getter
public enum TypeUser {
    EMPLOYEE("employee"),
    MANAGER("manager"),
    SUPER("super");

    private final String role;

    TypeUser(String role){
        this.role = role;
    }
}
