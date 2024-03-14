package com.james.api.user;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phoneNumber;
    private Long addressId;
    private String job;
    private double height;
    private double weight;

    @Builder(builderMethodName = "builder")
    public User(String username, String password,
                String name, String phoneNumber,
                Long addressId, String job,
                double height, double weight) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.addressId = addressId;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{\n" +
                "username='" + username + '\n' +
                ", password='" + password + '\n' +
                ", name='" + name + '\n' +
                ", phoneNumber='" + phoneNumber + '\n' +
                ", addressId='" + addressId + '\n' +
                ", job='" + job + '\n' +
                '}';
    }
}
