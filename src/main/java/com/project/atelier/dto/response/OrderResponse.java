package com.project.atelier.dto.response;

public record OrderResponse(String id, String value, String deliverDate, String typePayment, boolean isPaid, String userId, String customerId, String installments, String createdDate){}

