package com.pic2cheese.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DetailErrorInfoApi {
    private String target;
    private String message;
}
