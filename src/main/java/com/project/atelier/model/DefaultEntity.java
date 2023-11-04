package com.project.atelier.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter
@MappedSuperclass
public class DefaultEntity {
    @Id
    private String id;
    private String status;
    private String type;
}
