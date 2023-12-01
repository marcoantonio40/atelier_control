package com.project.atelier.model;

import com.project.atelier.dto.request.AddressRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_ADDRESS")
public class DomainAddress extends DefaultEntity {

    private String street;

    private String number;

    private String neighborhood;

    private String cep;

    private String complement;

    public static DomainAddress toModel(AddressRequest request) {
        return DomainAddress.builder()
                .street(request.getStreet())
                .cep(request.getCep())
                .complement(request.getComplement())
                .number(request.getNumber())
                .neighborhood(request.getNeighborhood())
                .status(true)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
