package com.project.atelier.model;

import com.project.atelier.dto.request.CustomerRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_CUSTOMER")
public class Customer extends DefaultEntity {

    private String email;

    @Column(unique = true)
    private String cpfOrCnpj;

    private LocalDateTime birthDay;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private DomainAddress address;


    public static Customer toModel(CustomerRequest request) {
        return Customer
                .builder()
                .email(request.getEmail())
                .cpfOrCnpj(request.getCpfOrCnpj())
                .name(request.getName())
                .phone(request.getPhone())
                .status(true)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .address(DomainAddress.toModel(request.getAddress()))
                .build();
    }
}
