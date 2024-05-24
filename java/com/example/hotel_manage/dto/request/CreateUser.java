package com.example.hotel_manage.dto.request;

public class CreateUser {
    private String name;
    private String contact;
    private String gender;
    private Long roleId;

    public CreateUser() {
    }

    public CreateUser(String name,String gender, String contact, Long roleId) {
        this.name = name;
        this.gender=gender;
        this.contact = contact;
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
