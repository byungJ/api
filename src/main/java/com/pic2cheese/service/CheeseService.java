package com.pic2cheese.service;

import com.pic2cheese.api.Cheese;
import com.pic2cheese.repository.CheeseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheeseService {

    private final CheeseRepository cheeseRepository;

    public void saveCheese(Cheese cheese) {
        cheeseRepository.save(cheese);

    }

    public List<Cheese> findCheese() {
        return cheeseRepository.findAll();
    }

    public Cheese findOne(Long itemId) {
        return cheeseRepository.findOne(itemId);
    }

}
