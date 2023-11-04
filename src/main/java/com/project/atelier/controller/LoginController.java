package com.project.atelier.controller;

import com.project.atelier.dto.request.LoginRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/test")
public interface LoginController {

    @GetMapping
    String login(@Valid LoginRequest request);

}
