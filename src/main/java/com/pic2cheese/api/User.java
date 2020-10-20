package com.pic2cheese.api;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String name;
    private int age;

    private String city;
    private String street;
    private String zipcode;

    private LocalDateTime joinDay;

    public User() {
    }

   public User(Gender gender, String name, int age, String city, String street, String zipcode, LocalDateTime joinDay) {
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.joinDay = joinDay;
    }
}
