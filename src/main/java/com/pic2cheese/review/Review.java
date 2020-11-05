package com.pic2cheese.review;

import com.pic2cheese.cheese.Cheese;
import com.pic2cheese.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "rewier_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cheese_id")
    private Cheese cheese;

    private String insertFnQ;
    private String updateFnQ;

    private String title;

    @Lob
    private String content;

}
