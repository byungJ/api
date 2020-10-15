package com.pic2cheese.api;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Analysis {

    @Id @GeneratedValue()
    @Column(name = "analysis_id")
    private Long id;

}
