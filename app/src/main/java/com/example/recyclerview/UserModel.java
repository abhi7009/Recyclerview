package com.example.recyclerview;

public class UserModel {

    String email,name;
    String phone;

    public UserModel() {
    }

    public UserModel(String email, String name, String phone) {
        this.email = email;
        this.name = name;
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "UserModel{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
