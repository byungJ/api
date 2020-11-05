package com.pic2cheese.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long join(User user) {

//        User userEntity = new User();
//
//        userEntity.setGender(user.getGender());
//        userEntity.setName(user.getName());
//        userEntity.setNickname(user.getNickname());
//        userEntity.setAge(user.getAge());
//        userEntity.setPw(user.getPw());
//        userEntity.setCity(user.getCity());
//        userEntity.setStreet(user.getStreet());
//        userEntity.setZipcode(user.getZipcode());
//        userEntity.setJoinDay(LocalDateTime.now());

        vaildateDuplicateUser(user);
        userRepository.save(user);

        return user.getId();
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public User findOne(Long userId){
        return userRepository.getOne(userId);
    }

    public void modify(User user) throws Exception {
        User userEntity = userRepository.getOne(user.getId());

        userEntity.setZipcode(user.getZipcode());
        userEntity.setStreet(user.getStreet());
        userEntity.setCity(user.getCity());
        userEntity.setPw(user.getPw());

        userRepository.save(userEntity);
    }

    public void remove(Long userNo) throws Exception {
        userRepository.deleteById(userNo);
    }



    private void vaildateDuplicateUser(User user) {
        Optional<User> findUsers = userRepository.findById(user.getId());
        if (!findUsers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원");
        }
    }
}
