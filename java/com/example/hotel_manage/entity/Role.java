package com.example.hotel_manage.entity;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Set;
@SpringBootApplication
@EntityScan("com.example.hotel_manage.entity")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String role_name;
@OneToMany(mappedBy = "role")
private Set<User> user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }


    public User getUser() {
        return (User) user;
    }

    public void setUser(User user) {
        this.user = (Set<User>) user;
    }

    public Role() {
    }


}
