package com.project.atelier.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@SuperBuilder
@MappedSuperclass
public class DefaultEntity {
    @Id
    public String id;
    private String status;
    private String type;
}
