package com.pic2cheese.controller;

import com.pic2cheese.api.Gender;
import com.pic2cheese.api.User;
import com.pic2cheese.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/new")
    public String createForm(Model model) {
        model.addAttribute("User", new User());
        return "usres/createUserForm";
    }


    @PostMapping("/users/new")
    public String create(@Valid User user, BindingResult result) {

        if(result.hasErrors()){
            return "users/createUserForm";
        }

        user.setGender(Gender.MAN);
        User user1 = new User(
               user.getGender(), user.getName(), user.getAge()
                ,user.getCity(),user.getStreet(),user.getZipcode()
                ,user.getJoinDay()
        );
        return "redirect:/";
    }

    @GetMapping("/users")
    public String list(Model model) {
        model.addAttribute("user",userService.findUsers());
        return "users/userList";
    }

//    public String update() {
//
//    }
//
//    public String update(){
//
//    }
//
//    public String delete() {
//
//    }

}
