package com.example.springexerciseproject.web.v1.dtos.movie;

import com.example.springexerciseproject.web.v1.dtos.actor.ActorDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Integer movieId;
    private String movieTitle;
    private String movieGenre;
    private Double movieRating;
    private Boolean isActive;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Collection<ActorDTO> actors;
}
