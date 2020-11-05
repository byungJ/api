package com.pic2cheese.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;


    @Test
    public void 회원가입() throws Exception {
        //given이 주어졌을 when 이렇게(이걸 실행) 하면 then (이게 나와야돼) 이렇게 된다.
        User member = new User();
        member.setName("kim");

        //when
        Long savedId = userService.join(member);

        //then
        assertEquals(member, userRepository.getOne(savedId));
    }
}