package com.project.atelier.controller;

import com.project.atelier.dto.request.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping(value = "/login", produces = {"application/json"})
@RestController
public class LoginController {

    @PostMapping(path = "/token")
    ResponseEntity<String> login(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.accepted().build();
    }

}
