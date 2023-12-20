package com.project.atelier.service.impl;

import com.project.atelier.dto.request.OrderRequest;
import com.project.atelier.dto.response.OrderResponse;
import com.project.atelier.model.Order;
import com.project.atelier.service.AbstractService;
import com.project.atelier.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends AbstractService<OrderResponse, Order> implements GenericService<OrderRequest, OrderResponse> {


    @Override
    protected OrderResponse buildResponse(Order domain) {
        return null;
    }

    @Override
    public OrderResponse save(OrderRequest request){
        return null;
    }

    @Override
    public OrderResponse findById(String id) {
        return null;
    }

    @Override
    public List<OrderResponse> findAll() {
        return null;
    }

    @Override
    public OrderResponse update(OrderRequest request, String id) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
