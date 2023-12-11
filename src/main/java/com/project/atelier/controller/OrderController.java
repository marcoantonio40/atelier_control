package com.project.atelier.controller;

import com.project.atelier.dto.request.OrderRequest;
import com.project.atelier.dto.response.OrderResponse;
import com.project.atelier.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/order", produces = {"application/json"})
@RestController
public class OrderController extends GenericController<OrderRequest, OrderResponse>{

    @Autowired
    private OrderService service;

    protected OrderController(OrderService service) {
        super(service);
    }

}
