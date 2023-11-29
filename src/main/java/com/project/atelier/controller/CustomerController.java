package com.project.atelier.controller;

import com.project.atelier.dto.request.CustomerRequest;
import com.project.atelier.dto.response.CustomerResponse;
import com.project.atelier.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RequestMapping(value = "/customer", produces = {"application/json"})
@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping(path = "/create-customer")
    ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest request) throws NoSuchAlgorithmException {
        return ResponseEntity.ok(service.save(request));
    }

    @GetMapping(path = "/find-by-id/{id}")
    ResponseEntity<CustomerResponse> findById(@Valid @PathVariable(value = "id") String id ){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(path = "/find-all")
    ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping(path = "/update-customer/{id}")
    ResponseEntity<CustomerResponse> update(@PathVariable(value = "id") String id,
                                        @Valid @RequestBody CustomerRequest request)  {
        return ResponseEntity.ok(service.update(request, id));
    }

    @DeleteMapping(path = "/delete-customer/{id}")
    ResponseEntity delete(@PathVariable(value = "id") String id)  {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
