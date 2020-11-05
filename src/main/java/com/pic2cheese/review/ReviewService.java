package com.pic2cheese.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public void register(Review review) throws Exception {

        Review reviewEntity = new Review();

        reviewEntity.setCheese(review.getCheese());
        reviewEntity.setContent(review.getContent());
        reviewEntity.setInsertFnQ(review.getInsertFnQ());
        reviewEntity.setTitle(review.getTitle());
        reviewEntity.setUser(review.getUser());

        reviewRepository.save(reviewEntity);

    }

    public Review read(Long reviewNo) throws Exception {
        return reviewRepository.getOne(reviewNo);
    }

    public void modify(Review review) throws Exception {
        Review reviewEntity = reviewRepository.getOne(review.getId());

        reviewEntity.setTitle(review.getTitle());
        reviewEntity.setContent(review.getContent());
        reviewEntity.setUpdateFnQ(review.getUpdateFnQ());

        reviewRepository.save(reviewEntity);

    }

    public void remove(Long reviewNo) throws Exception {
        reviewRepository.deleteById(reviewNo);
    }

    public List<Review> list() throws Exception {
        return reviewRepository.findAll();
    }

    public long countAll() throws Exception {
        return reviewRepository.count();
    }



}
