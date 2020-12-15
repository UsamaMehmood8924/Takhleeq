package com.example.takhleeqproject;

public class AdminUser {
    String id;
    String role;

    public AdminUser(String id, String role) {
        this.id = id;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AdminUser() {
    }
}
