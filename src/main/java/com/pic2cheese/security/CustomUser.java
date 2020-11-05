package com.pic2cheese.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;


import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUser extends User{

    private com.pic2cheese.user.User user;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUser(com.pic2cheese.user.User user) {
        super(user.getNickname(), user.getPw(), user.getAuthList().stream()
                .map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));

        this.user = user;
    }

    public com.pic2cheese.user.User getMember() {
        return user;
    }

}
