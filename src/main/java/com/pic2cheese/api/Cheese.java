package com.pic2cheese.api;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "cheese")
public class Cheese {

    @Id @GeneratedValue
    @Column(name = "cheese_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    private String taste;

    @Lob
    private String content;
    private String country;

}
