package com.example.springexerciseproject.web.v1.controllers;

import com.example.springexerciseproject.domain.Movie;
import com.example.springexerciseproject.domain.Review;
import com.example.springexerciseproject.services.ReviewService;
import com.example.springexerciseproject.utils.mappers.ReviewMapper;
import com.example.springexerciseproject.web.v1.dtos.review.ReviewDTO;
import com.example.springexerciseproject.web.v1.dtos.review.UpdateReviewDTO;
import com.example.springexerciseproject.web.v1.wrappers.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = {"/api/v1"})
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewController(ReviewService reviewService, ReviewMapper reviewMapper) {
        this.reviewService = reviewService;
        this.reviewMapper = reviewMapper;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/reviews"}, produces = {"application/json"})
    public ResponseEntity<ResponseWrapper<Collection<ReviewDTO>>> getAllReviews(){
        Collection<Review> reviews = this.reviewService.getAllReviews();
        Collection<ReviewDTO> reviewDTOS = this.reviewMapper.toReviewDTOs(reviews);
        return ResponseEntity.ok(new ResponseWrapper(reviewDTOS, HttpStatus.OK.value()));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/reviews/{reviewId}"}, produces = {"application/json"})
    public ResponseEntity<ResponseWrapper<ReviewDTO>> getReview(@PathVariable("reviewId") Integer reviewId){
        Review review = this.reviewService.getReview(reviewId);
        ReviewDTO reviewDTO = this.reviewMapper.toReviewDTO(review);
        return ResponseEntity.ok(new ResponseWrapper(reviewDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = {"/reviews/{reviewId}"})
    public ResponseEntity<ResponseWrapper<ReviewDTO>> updateReview(@PathVariable("ReviewId") Integer reviewId, @RequestBody UpdateReviewDTO updateReviewDTO){
        Review updatedReview = this.reviewService.updateReview(reviewId, updateReviewDTO);
        ReviewDTO updatedReviewDTO = this.reviewMapper.toReviewDTO(updatedReview);
        return ResponseEntity.ok(new ResponseWrapper(updatedReviewDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = {"reviews/{reviewId}"})
    public ResponseEntity<Void> deleteReview(@PathVariable("reviewId") Integer reviewId){
        this.reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"movies/{movieId}/reviews"})
    public ResponseEntity<ResponseWrapper<Collection<ReviewDTO>>> getMovieReviews(@PathVariable("movieId") Integer movieId){
        Collection<Review> reviews = this.reviewService.getMovieReviews(movieId);
        Collection<ReviewDTO> reviewDTOS = this.reviewMapper.toReviewDTOs(reviews);
        return ResponseEntity.ok(new ResponseWrapper(reviewDTOS, HttpStatus.OK.value()));

    }

}
