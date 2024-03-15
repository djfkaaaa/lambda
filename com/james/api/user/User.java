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
    private String height;
    private String weight;

    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password,
                String name, String phoneNumber,
                Long addressId, String job,
                String height, String weight) {
        this.id = id;
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
                "id = " + id +
                ", username = " + username +
                ", password = " + password +
                ", name = " + name +
                ", phoneNumber = " + phoneNumber +
                ", addressId = " + addressId +
                ", job = " + job +
                '}';
    }
}
