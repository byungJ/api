package com.pic2cheese.repository;

import com.pic2cheese.api.Cheese;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CheeseRepository {

    private final EntityManager em;

    public void save(Cheese cheese) {
        if (cheese.getId() == null) {
            em.persist(cheese);
        } else {
            em.merge(cheese);
        }
    }

    public Cheese findOne(Long id) {
        return em.find(Cheese.class, id);
    }

    public List<Cheese> findAll() {
        return em.createQuery("select c from Cheese c", Cheese.class).getResultList();
    }

}

