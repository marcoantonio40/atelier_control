package com.project.atelier.model.generics;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@Data
@SuperBuilder
@MappedSuperclass
public class DefaultInfoEntity {

    private String name;

    private String phone;



}
