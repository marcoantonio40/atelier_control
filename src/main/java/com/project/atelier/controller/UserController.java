package com.project.atelier.controller;

import com.project.atelier.dto.request.UserRequest;
import com.project.atelier.dto.response.UserResponse;
import com.project.atelier.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/user", produces = {"application/json"})
@RestController
public class UserController extends GenericController<UserRequest, UserResponse>{

    @Autowired
    private UserService service;

    protected UserController(UserService service) {
        super(service);
    }

}
