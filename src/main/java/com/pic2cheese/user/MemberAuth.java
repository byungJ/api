package com.pic2cheese.user;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MemberAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="member_auth_id")
    private Long id;

    private Long userNo;

    private String auth;

//    private Date regDate;
//
//    private Date upDate;

}
