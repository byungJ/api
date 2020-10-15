package com.pic2cheese.api;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "user")
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;

    private String city;
    private String street;
    private String zipcode;

    private LocalDateTime joinDay;


}
