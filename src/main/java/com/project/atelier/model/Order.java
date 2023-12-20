package com.project.atelier.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.atelier.dto.request.OrderRequest;
import com.project.atelier.model.enums.TypePayment;
import com.project.atelier.model.generics.DefaultEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_ORDER")
public class Order extends DefaultEntity {

    private Double value;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deliverDate;

    private TypePayment typePayment;

    private boolean isPaid;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customerId;

    private int installments;


    public static Order toModel(OrderRequest request) {
        return Order.builder()
                .value(request.getValue())
                .deliverDate(LocalDateTime.parse(request.getDeliverDate()))
                .typePayment(TypePayment.valueOf(request.getTypePayment()))
                .isPaid(request.isPaid())
                .userId(User
                        .builder()
                        .id(request.getUserId())
                        .build())
                .customerId(Customer
                        .builder()
                        .id(request.getCustomerId())
                        .build())
                .installments(request.getInstallments())
                .build();
    }
}
