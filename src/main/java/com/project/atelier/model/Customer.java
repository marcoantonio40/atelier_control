package com.project.atelier.model;

import jakarta.persistence.*;
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
@Table(name = "T_CUSTOMER")
public class Customer extends DefaultEntity {

    private String email;

    @Column(unique = true)
    private String cpfOrCnpj;

    private LocalDateTime birthDay;

    @OneToOne
    @JoinColumn(name = "id")
    private DomainAddress address;


}
