package com.project.atelier.controller;

import com.project.atelier.dto.request.UserRequest;
import com.project.atelier.dto.response.UserResponse;
import com.project.atelier.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RequestMapping(value = "/user", produces = {"application/json"})
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping(path = "/create-user")
    ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest request) throws NoSuchAlgorithmException {
        return ResponseEntity.ok(service.save(request));
    }

    @GetMapping(path = "/find-by-id/{id}")
    ResponseEntity<UserResponse> findById(@Valid @PathVariable(value = "id") String id ){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(path = "/find-all")
    ResponseEntity<List<UserResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping(path = "/update-user/{id}")
    ResponseEntity<UserResponse> update(@PathVariable(value = "id") String id,
                                        @Valid @RequestBody UserRequest request)  {
        return ResponseEntity.ok(service.update(request, id));
    }

}
