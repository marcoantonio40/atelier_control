package com.project.atelier.controller;

import com.project.atelier.dto.request.CustomerRequest;
import com.project.atelier.dto.response.CustomerResponse;
import com.project.atelier.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/customer", produces = {"application/json"})
@RestController
public class CustomerController extends GenericController<CustomerResponse, CustomerRequest>{

    @Autowired
    private CustomerService service;

    protected CustomerController(CustomerService service) {
        super(service);
    }
}
