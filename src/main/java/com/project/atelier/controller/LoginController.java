package com.project.atelier.controller;

import com.project.atelier.configuration.TokenService;
import com.project.atelier.dto.request.LoginRequest;
import com.project.atelier.dto.response.LoginResponse;
import com.project.atelier.model.User;
import com.project.atelier.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;


@RequestMapping(value = "/login", produces = {"application/json"})
@RestController
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService service;

    @Autowired
    private TokenService tokenService;

    @PostMapping(path = "/token")
    @ResponseBody
    ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) throws NoSuchAlgorithmException {
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok().body(new LoginResponse(token));

    }

}
