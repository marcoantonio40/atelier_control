package com.project.atelier.dto.response;

public record CustomerResponse(String id, String name, String cpfOrCnpj, String phone, String birthDay, String email, AddressResponse address){}
