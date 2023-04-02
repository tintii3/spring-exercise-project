package com.example.springexerciseproject.utils.mappers;

import com.example.springexerciseproject.domain.Movie;
import com.example.springexerciseproject.utils.criteria.MovieCriteria;
import com.example.springexerciseproject.web.v1.dtos.movie.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class MovieMapper {

    private final ActorMapper actorMapper;
    @Autowired
    public MovieMapper(ActorMapper actorMapper){
        this.actorMapper = actorMapper;
    }

    public Collection<MovieDTO> toMovieDTOs(Collection<Movie> movies){
    return movies.stream().map(this::toMovieDTO)
            .collect(Collectors.toList());
    }
    public MovieDTO toMovieDTO(Movie movie, MovieCriteria movieCriteria){
        if (movieCriteria.includeActors()){
            return toMovieDTOWithActors(movie);
        }
        return toMovieDTO(movie);
    }
    public MovieDTO toMovieDTO(Movie movie){
        return MovieDTO.builder()
                .movieId(movie.getMovieId())
                .movieGenre(movie.getMovieGenre())
                .movieRating(movie.getMovieRating())
                .movieTitle(movie.getMovieTitle())
                .isActive(movie.isActive())
                .build();
    }
    public MovieDTO toMovieDTOWithActors(Movie movie){
        MovieDTO movieDTO = toMovieDTO(movie);
        movieDTO.setActors(actorMapper.toActorDTOs(movie.getAssignedActors()));
        return movieDTO;
    }
}
