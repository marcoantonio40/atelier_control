package com.project.atelier.service.impl;

import com.project.atelier.dto.request.OrderRequest;
import com.project.atelier.dto.response.OrderResponse;
import com.project.atelier.model.Order;
import com.project.atelier.repository.OrderRepository;
import com.project.atelier.service.AbstractService;
import com.project.atelier.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService extends AbstractService<OrderResponse, Order> implements GenericService<OrderRequest, OrderResponse> {


    @Autowired
    private OrderRepository repository;

    @Override
    public OrderResponse save(OrderRequest request){
        return this.buildResponse(repository.save(Order.toModel(request)));
    }

    @Override
    public OrderResponse findById(String id) {
        return repository.findById(id).map(this::buildResponse).orElse(null);
    }

    @Override
    public List<OrderResponse> findAll() {
        return repository.findAll()
                .stream().map(this::buildResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse update(OrderRequest request, String id) {
        Order order = Order.toModel(request);
        order.setId(id);
        return this.buildResponse(repository.save(order));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    protected OrderResponse buildResponse(Order domain) {
        return new OrderResponse(
                domain.getId(),
                domain.getValue().toString(),
                domain.getDeliverDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                domain.getTypePayment().toString(),
                domain.isPaid(),
                domain.getUserId().getId(),
                domain.getCustomerId().getId(),
                Integer.toString(domain.getInstallments()),
                domain.getCreatedDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
