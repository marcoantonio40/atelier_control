package com.project.atelier.controller;

import com.project.atelier.dto.request.UserRequest;
import com.project.atelier.dto.response.UserResponse;
import com.project.atelier.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "/user", produces = {"application/json"})
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(path = "/create-user")
    @ResponseBody
    ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest request){
        return ResponseEntity.ok(service.save(request));
    }

    @GetMapping(path = "/find-by-id/{id}")
    @ResponseBody
    ResponseEntity<UserResponse> findById(@Valid @PathVariable(value = "id") String id ){
        return ResponseEntity.ok(service.findById(id));
    }
}
