package com.example.hotel_manage.dto.request;

public class CreateRole {
    private String role_name;

    public CreateRole() {
    }

    public CreateRole(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
