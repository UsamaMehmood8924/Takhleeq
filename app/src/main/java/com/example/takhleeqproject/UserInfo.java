package com.example.takhleeqproject;

public class UserInfo {
    String email;
    String phone;
    String name;
    String id;

    public UserInfo(String email, String phone, String name, String id) {
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.id = id;
    }

    public UserInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
