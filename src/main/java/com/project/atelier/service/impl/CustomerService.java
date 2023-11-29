package com.project.atelier.service.impl;

import com.project.atelier.dto.request.CustomerRequest;
import com.project.atelier.dto.response.CustomerResponse;
import com.project.atelier.model.Customer;
import com.project.atelier.repository.CustomerRepository;
import com.project.atelier.service.AbstractService;
import com.project.atelier.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class CustomerService extends AbstractService<CustomerResponse, Customer> implements GenericService<CustomerRequest, CustomerResponse> {


    @Autowired
    CustomerRepository repository;

    @Override
    public CustomerResponse save(CustomerRequest request) throws NoSuchAlgorithmException {
        return null;
    }

    @Override
    public CustomerResponse findById(String id) {
        return null;
    }

    @Override
    public List<CustomerResponse> findAll() {
        return null;
    }

    @Override
    public CustomerResponse update(CustomerRequest request, String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    protected CustomerResponse buildResponse(Customer domain) {
        return null;
    }
}
