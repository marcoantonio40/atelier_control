package com.project.atelier.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_USER")
public class User extends DefaultEntity{
    private String login;
    private String password;
}
