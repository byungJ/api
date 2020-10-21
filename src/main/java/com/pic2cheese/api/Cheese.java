package com.pic2cheese.api;


import com.pic2cheese.exception.NotEnoughStockException;
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
    private String country;
    private String matching;

    private String texture;
    private String types;

    private String subcategory;
    private int price;

    @Lob
    private String content;

    private int stockQuantity;
    private String taste;


    /**
     * stock증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stock감소
     */
    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity =restStock;
    }
}
