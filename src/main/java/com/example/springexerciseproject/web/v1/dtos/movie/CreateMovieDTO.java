package com.example.springexerciseproject.web.v1.dtos.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieDTO {

    private String movieTitle;
    private String movieGenre;
    private Double movieRating;

}
