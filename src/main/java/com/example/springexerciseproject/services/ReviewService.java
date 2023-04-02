package com.example.springexerciseproject.services;

import com.example.springexerciseproject.domain.Review;
import com.example.springexerciseproject.web.v1.dtos.review.CreateReviewDTO;
import com.example.springexerciseproject.web.v1.dtos.review.UpdateReviewDTO;

import java.util.Collection;

public interface ReviewService {
    Collection<Review> getAllReviews();

    Review getReview(Integer reviewId);

    Review createReview(CreateReviewDTO createReviewDTO);

    Review updateReview(Integer reviewId, UpdateReviewDTO updateReviewDTO);

    void deleteReview(Integer reviewId);

    Collection<Review> getMovieReviews(Integer movieId);
}
