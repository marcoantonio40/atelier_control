package com.project.atelier.model;

import com.project.atelier.dto.request.LoginRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_USER")
public class User extends DefaultEntity{
    private String login;
    private String password;

    public static User of(LoginRequest request) {
        return User.builder()
                .login(request.getLogin())
                .password(request.getPassword())
                .status("ok")
                .id("ok")
                .type("ok")
                .build();
    }
    //TODO ARRUMAR
}
