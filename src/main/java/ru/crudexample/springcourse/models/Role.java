package ru.crudexample.springcourse.models;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "role")
    private String role;

    public Role(UUID id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role() {
        this.role = "ROLE_USER";
    }

    public Role(String role) {
        this.role = role;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}
