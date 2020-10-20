package com.pic2cheese.controller;

import com.pic2cheese.api.Cheese;
import com.pic2cheese.service.CheeseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CheeseController {

    private final CheeseService cheeseService;

    @GetMapping("/cheese/new")
    public String createForm(Model model) {
        model.addAttribute("cheese", new Cheese());
        return "/cheese/createCheeseForm";
    }

    @PostMapping("/cheese/new")
    public String create(Cheese cheese) {
        Cheese cheese1 = new Cheese();

        cheese1.setName(cheese.getName());
        cheese1.setPrice(cheese.getPrice());
        cheese1.setStockQuantity(cheese.getStockQuantity());
        cheese1.setContent(cheese.getContent());
        cheese1.setCountry(cheese.getCountry());
        cheese1.setTaste(cheese.getTaste());

        cheeseService.saveCheese(cheese);
        return "cheese:/";
    }
}
