package com.project.atelier.model;

import com.project.atelier.dto.request.UserRequest;
import com.project.atelier.model.enums.TypeUser;
import com.project.atelier.model.generics.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "T_USER")
public class User extends DefaultEntity implements UserDetails {

    @Column(unique = true)
    private String login;

    private String password;

    @Column(unique = true)
    private String cpf;

    private TypeUser type;

    public static User toModel(UserRequest request, String password) {
        return User.builder()
                .login(request.getLogin())
                .password(password)
                .status(true)
                .type(TypeUser.valueOf(request.getType()))
                .phone(request.getPhone())
                .cpf(request.getCpf())
                .name(request.getName())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }

    public static User toModelToUpdate(UserRequest request, String id, String password) {
        return User.builder()
                .login(request.getLogin())
                .status(true)
                .type(TypeUser.valueOf(request.getType()))
                .phone(request.getPhone())
                .cpf(request.getCpf())
                .name(request.getName())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .id(id)
                .password(password)
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.getType() == TypeUser.SUPER){
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_STAFF"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        }else if (this.getType() == TypeUser.MANAGER) {
            return List.of(
                    new SimpleGrantedAuthority("ROLE_STAFF"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
          return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
