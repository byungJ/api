package com.pic2cheese.service;

import com.pic2cheese.api.User;
import com.pic2cheese.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class MyInfoService {

    private UserRepository userRepository;

    public Boolean register(Long userNo){

        User user = userRepository.findOne(userNo);
        

        return true;
    }

}
