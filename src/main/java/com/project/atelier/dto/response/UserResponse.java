package com.project.atelier.dto.response;

import com.project.atelier.model.User;
import lombok.Builder;

import java.io.Serializable;

@Builder
public class UserResponse implements Serializable {
    public String id;
    public boolean status;
    public String type;
    public String login;

    public static UserResponse toResponse(User model) {
        return UserResponse.builder()
                .id(model.getId())
                .status(model.isStatus())
                .type(model.getType())
                .login(model.getLogin())
                .build();
    }
}
