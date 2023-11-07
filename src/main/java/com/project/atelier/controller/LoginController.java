package com.project.atelier.controller;

import com.project.atelier.dto.request.LoginRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping(value = "/login", produces = {"application/json"})
@RestController
@Tag(name = "open-api")
public class LoginController {

    @Operation(summary = "Realiza login na aplicação", method = "POST")
    @PostMapping(path = "/token")
    @ResponseBody
    ResponseEntity<String> login(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.accepted().build();
    }

}
