package com.example.springexerciseproject.utils.mappers;

import com.example.springexerciseproject.domain.Review;
import com.example.springexerciseproject.web.v1.dtos.review.ReviewDTO;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ReviewMapper {
    public Collection<ReviewDTO> toReviewDTOs(Collection<Review> reviews){
        return reviews.stream().map(this::toReviewDTO).collect(Collectors.toList());
    }
    public ReviewDTO toReviewDTO(Review review){
        return ReviewDTO.builder()
                .reviewId(review.getReviewId())
                .numberOfStars(review.getNumberOfStars())
                .reviewDescription(review.getReviewDescription())
                .movieId(review.getMovie().getMovieId())
                .build();
    }
}
