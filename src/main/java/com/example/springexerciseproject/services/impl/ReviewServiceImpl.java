package com.example.springexerciseproject.services.impl;

import com.example.springexerciseproject.Repositories.ReviewRepositories;
import com.example.springexerciseproject.domain.Movie;
import com.example.springexerciseproject.domain.Review;
import com.example.springexerciseproject.exception.general.ResourceIllegalStateException;
import com.example.springexerciseproject.exception.review.ReviewNotFoundException;
import com.example.springexerciseproject.services.MovieService;
import com.example.springexerciseproject.services.ReviewService;
import com.example.springexerciseproject.web.v1.dtos.review.CreateReviewDTO;
import com.example.springexerciseproject.web.v1.dtos.review.UpdateReviewDTO;
import org.springframework.beans.BeanUtils;

import java.util.Collection;

public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepositories reviewRepositories;
    private final MovieService movieService;

    public ReviewServiceImpl(ReviewRepositories reviewRepositories, MovieService movieService) {
        this.reviewRepositories = reviewRepositories;
        this.movieService = movieService;
    }

    @Override
    public Collection<Review> getAllReviews() {
        return reviewRepositories.findAll();
    }

    @Override
    public Review getReview(Integer reviewId) {
        return (Review) reviewRepositories.findById(reviewId).orElseThrow(() -> {
            return new ReviewNotFoundException("Review could not be found");
        });
    }

    @Override
    public Review createReview(CreateReviewDTO createReviewDTO) {
        if (!createReviewDTO.hasMovieId()){
            throw new ResourceIllegalStateException("Movie id must be specified");
        } else {
            Movie movie = this.movieService.getMovie(createReviewDTO.getMovieId());
            Review review = new Review();
            if (!createReviewDTO.hasNumberOfStars()){
                throw new ResourceIllegalStateException("Number of stars must be specified");
            } else if (createReviewDTO.getNumberOfStars() >=1 && createReviewDTO.getNumberOfStars() <= 5){
                BeanUtils.copyProperties(createReviewDTO, review);
                review.activate();
                review.setMovie(movie);
                return (Review) this.reviewRepositories.saveAndFlush(review);
            } else {
                throw new ResourceIllegalStateException("Number of stars must be in range 1-5.");
            }
        }
    }

    @Override
    public Review updateReview(Integer reviewId, UpdateReviewDTO updateReviewDTO) {
        Review review = new Review();
        if (!updateReviewDTO.hasNumberOfStars()){
            throw new ResourceIllegalStateException("Nuber of stars must be specified.");
        } else if (updateReviewDTO.getNumberOfStars() >= 1 && updateReviewDTO.getNumberOfStars() <= 5){
            BeanUtils.copyProperties(updateReviewDTO, review);
            return (Review) this.reviewRepositories.saveAndFlush(review);
        } else {
            throw new ResourceIllegalStateException("Number of stars should be in range 1-5");
        }
    }

    @Override
    public void deleteReview(Integer reviewId) {
        Review review = this.getReview(reviewId);
        this.reviewRepositories.delete(review);
    }

    @Override
    public Collection<Review> getMovieReviews(Integer movieId) {
        Movie movie = movieService.getMovie(movieId);
        return this.reviewRepositories.findAllByMovie(movie);
    }
}
