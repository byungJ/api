package com.pic2cheese.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByNickname(String username);

    @Query("select u.id, u.pw, u.name,u.nickname,u.joinDay from User u")
    public List<Object[]> listAllMember();
}
