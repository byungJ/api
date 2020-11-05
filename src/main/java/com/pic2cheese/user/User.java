package com.pic2cheese.user;

import com.pic2cheese.review.Review;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private String pw;
    private String nickname;

    private String name;
    private int age;

    private String city;
    private String street;
    private String zipcode;

    private LocalDateTime joinDay;

    @OneToMany(mappedBy = "user")
    private List<UserCheese> userCheeses = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_auth_id")
    private List<MemberAuth> authList = new ArrayList<>();

    public void addAuth(MemberAuth auth) {
        authList.add(auth);
    }

    public void clearAuthList() {
        authList.clear();
    }

}
