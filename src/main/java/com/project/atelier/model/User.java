package com.project.atelier.model;

import com.project.atelier.dto.request.UserRequest;
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
@AllArgsConstructor
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

    public static User toModel(UserRequest request, String password) {
        return User.builder()
                .login(request.getLogin())
                .password(password)
                .status(true)
                .type(request.getType())
                .phone(request.getPhone())
                .cpf(request.getCpf())
                .name(request.getName())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
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
