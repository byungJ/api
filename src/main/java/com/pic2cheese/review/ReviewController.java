package com.pic2cheese.review;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    @PostMapping("/new")
    public ResponseEntity<Review> register(@Validated @RequestBody Review review) throws Exception {

        reviewService.register(review);

        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Review>> list() throws Exception {
        return new ResponseEntity<>(reviewService.list(), HttpStatus.OK);
    }

    @GetMapping("/{reviewNo}")
    public ResponseEntity<Review> read(@PathVariable("reviewNo") Long reviewNo) throws Exception {
        Review review = reviewService.read(reviewNo);

        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @DeleteMapping("/{reviewNo}")
    public ResponseEntity<Void> remove(@PathVariable("reviewNo") Long reviewNo) throws Exception {
        reviewService.remove(reviewNo);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{reviewNo}")
    public ResponseEntity<Review> modify(@PathVariable("reviewNo") Long reviewNo, @Validated @RequestBody Review review) throws Exception {

        //회원정보 + 테이블 정보
        //review.setUser();
        reviewService.modify(review);

        return new ResponseEntity<>(review, HttpStatus.OK);
    }
}
