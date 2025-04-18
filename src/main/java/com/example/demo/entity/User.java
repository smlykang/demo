package com.example.demo.entity;

import lombok.Data;

@Data
public class User {
    private String name;
    private Address address; // 假设 address 可能为 null

    public User() {
    }

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
