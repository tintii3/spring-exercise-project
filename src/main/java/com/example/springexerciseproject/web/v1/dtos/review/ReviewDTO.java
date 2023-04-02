package com.example.springexerciseproject.web.v1.dtos.review;

import com.example.springexerciseproject.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Integer reviewId;
    private Integer numberOfStars;
    private String reviewDescription;
    private Integer movieId;

}
