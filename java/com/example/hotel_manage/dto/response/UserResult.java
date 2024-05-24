package com.example.hotel_manage.dto.response;

public class UserResult {
    private Long id;
    private String user_name;
    private String gender;
    private String contact;
    private RoleResult role;

    public UserResult(Long id, String user_name, String gender, String contact, RoleResult role) {
        this.id = id;
        this.user_name = user_name;
        this.gender = gender;
        this.contact = contact;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public RoleResult getRole() {
        return role;
    }

    public void setRole(RoleResult role) {
        this.role = role;
    }
}
