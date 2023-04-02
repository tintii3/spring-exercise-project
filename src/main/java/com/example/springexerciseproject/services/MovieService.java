package com.example.springexerciseproject.services;

import com.example.springexerciseproject.domain.Movie;
import com.example.springexerciseproject.web.v1.dtos.movie.CreateMovieDTO;
import com.example.springexerciseproject.web.v1.dtos.movie.UpdateMovieDTO;

import java.util.Collection;

public interface MovieService {
    Collection<Movie> getAllMovies();

    Movie getMovie(Integer movieId);

    Movie createMovie(CreateMovieDTO createMovieDTO);

    Movie updateMovie(Integer movieId, UpdateMovieDTO updateMovieDTO);

    void deleteMovie(Integer movieId);

    void activateMovie(Integer movieId);

    void deactivateMovie(Integer movieId);
}
