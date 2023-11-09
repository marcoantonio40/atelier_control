package com.project.atelier.controller;

import com.project.atelier.dto.request.LoginRequest;
import com.project.atelier.dto.response.LoginResponse;
import com.project.atelier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequestMapping(value = "/login", produces = {"application/json"})
@RestController
public class LoginController {

    @Autowired
    private UserRepository repository;

    @PostMapping(path = "/token")
    ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        LoginResponse loginResponse = new LoginResponse(request.getLogin());

        return ResponseEntity.ok(loginResponse);

    }

}
