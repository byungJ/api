package com.pic2cheese.service;

import com.pic2cheese.api.User;
import com.pic2cheese.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long join(User user) {

        vaildateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void vaildateDuplicateUser(User user) {
        List<User> findUsers = userRepository.finByName(user.getName());
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원");
        }
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public User findOnd(Long userId){
        return userRepository.findOne(userId);
    }
}
