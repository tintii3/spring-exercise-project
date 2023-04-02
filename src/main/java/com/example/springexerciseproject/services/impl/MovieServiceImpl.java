package com.example.springexerciseproject.services.impl;

import com.example.springexerciseproject.Repositories.MovieRepositories;
import com.example.springexerciseproject.domain.Movie;
import com.example.springexerciseproject.exception.general.ResourceIllegalStateException;
import com.example.springexerciseproject.exception.movie.MovieNotFoundException;
import com.example.springexerciseproject.services.MovieActorService;
import com.example.springexerciseproject.services.MovieService;
import com.example.springexerciseproject.web.v1.dtos.movie.CreateMovieDTO;
import com.example.springexerciseproject.web.v1.dtos.movie.UpdateMovieDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Objects;

public class MovieServiceImpl implements MovieService {
    private final MovieRepositories movieRepositories;

    @Autowired
    public MovieServiceImpl(MovieRepositories movieRepositories) {
        this.movieRepositories = movieRepositories;
    }

    @Override
    public Collection<Movie> getAllMovies() {
        return this.movieRepositories.findAll();
    }

    @Override
    public Movie getMovie(Integer movieId) {
        return this.movieRepositories.findById(movieId).orElseThrow(() -> {
            throw new MovieNotFoundException("Movie could not be found.");
        });
    }

    @Override
    public Movie createMovie(CreateMovieDTO createMovieDTO) {
        Movie movie = new Movie();
        this.validateMovieTitle(createMovieDTO.getMovieTitle());
        BeanUtils.copyProperties(createMovieDTO, movie);
        movie.activate();
        return (Movie) movieRepositories.saveAndFlush(movie);
    }

    @Override
    public Movie updateMovie(Integer movieId, UpdateMovieDTO updateMovieDTO) {
        Movie movie = this.getMovie(movieId);
        this.validateMovieTitle(movie.getMovieTitle());
        BeanUtils.copyProperties(updateMovieDTO, movie);
        return (Movie) this.movieRepositories.saveAndFlush(movie);

    }

    @Override
    public void deleteMovie(Integer movieId) {
        Movie movie = this.getMovie(movieId);
        this.movieRepositories.delete(movie);
    }

    @Override
    public void activateMovie(Integer movieId) {
        Movie movie = this.getMovie(movieId);
        if(movie.isActive()){
            throw new ResourceIllegalStateException("Movie is already activated");
        } else {
        movie.activate();
        this.movieRepositories.saveAndFlush(movie);
        }
    }

    @Override
    public void deactivateMovie(Integer movieId) {
        Movie movie = this.getMovie(movieId);
        if(!movie.isActive()){
            throw new ResourceIllegalStateException("Movie is already deactivated");
        }
        else {
            movie.deactivate();
            this.movieRepositories.saveAndFlush(movie);
        }
    }
    private void validateMovieTitle(String movieTitle){
        if (Objects.isNull(movieTitle) || movieTitle.isEmpty()){
            throw new ResourceIllegalStateException("Movie title must be specified");
        }
    }
}
