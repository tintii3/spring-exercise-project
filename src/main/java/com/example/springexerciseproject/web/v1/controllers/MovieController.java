package com.example.springexerciseproject.web.v1.controllers;


import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.domain.Movie;
import com.example.springexerciseproject.services.MovieActorService;
import com.example.springexerciseproject.services.MovieService;
import com.example.springexerciseproject.utils.criteria.MovieCriteria;
import com.example.springexerciseproject.utils.mappers.MovieMapper;
import com.example.springexerciseproject.web.v1.dtos.actor.ActorDTO;
import com.example.springexerciseproject.web.v1.dtos.movie.CreateMovieDTO;
import com.example.springexerciseproject.web.v1.dtos.movie.MovieDTO;
import com.example.springexerciseproject.web.v1.dtos.movie.UpdateMovieDTO;
import com.example.springexerciseproject.web.v1.wrappers.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = {"/api/v1"})
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;
    private final MovieActorService movieActorService;

    @Autowired
    public MovieController(MovieService movieService, MovieMapper movieMapper, MovieActorService movieActorService) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
        this.movieActorService = movieActorService;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/movies"}, produces = {"application/json"})
    public ResponseEntity<ResponseWrapper<Collection<MovieDTO>>> getAllMovies(){
        Collection<Movie> movies = this.movieService.getAllMovies();
        Collection<MovieDTO> movieDTOS = this.movieMapper.toMovieDTOs(movies);
        return ResponseEntity.ok(new ResponseWrapper(movieDTOS, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/movies/{movieId}"})
    public ResponseEntity<ResponseWrapper<MovieDTO>> getMovie(@PathVariable("movieId") Integer movieId, MovieCriteria movieCriteria){
        Movie movie = this.movieService.getMovie(movieId);
        MovieDTO movieDTO = this.movieMapper.toMovieDTO(movie, movieCriteria);
        return ResponseEntity.ok(new ResponseWrapper(movieDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = {"/movies"}, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ResponseWrapper<MovieDTO>> createMovie(@RequestBody CreateMovieDTO createMovieDTO){
        Movie createdMovie = this.movieService.createMovie(createMovieDTO);
        MovieDTO createdMovieDTO = this.movieMapper.toMovieDTO(createdMovie);
        return ResponseEntity.ok(new ResponseWrapper(createdMovieDTO, HttpStatus.CREATED.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = {"/movies/{movieId}"}, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ResponseWrapper<MovieDTO>> updateMovie(@PathVariable("movieId") Integer movieId, @RequestBody UpdateMovieDTO updateMovieDTO){
        Movie movie = this.movieService.updateMovie(movieId, updateMovieDTO);
        MovieDTO movieDTO = this.movieMapper.toMovieDTO(movie);
        return  ResponseEntity.ok(new ResponseWrapper(movieDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/movies/{movieId}"})
    public ResponseEntity<Void> deleteMovie(@PathVariable("movieId") Integer movieId){
        this.movieService.deleteMovie(movieId);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = {"/movies/{movieId}/activate"})
    public ResponseEntity<Void> activateMovie(@PathVariable("movieId") Integer movieId){
        this.movieService.activateMovie(movieId);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = {"/movies/{movieId}/deactivate"})
    public ResponseEntity<Void> deactivateMovie(@PathVariable("movieId") Integer movieId){
        this.movieService.deactivateMovie(movieId);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = {"/movies/{movieId}/actors/{actorId}"}, produces = {"application/json"})
    public ResponseEntity<ResponseWrapper<MovieDTO>> addActorToMovie(@PathVariable("movieId") Integer movieId, @PathVariable("actorId") Integer actorId){
        Movie movie = this.movieActorService.addActorToMovie(movieId, actorId);
        MovieDTO movieDTO = this.movieMapper.toMovieDTO(movie);
        return ResponseEntity.ok(new ResponseWrapper(movieDTO, HttpStatus.OK.value()));
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = {"/movies/{movieId}/actors/{actorId}"})
    public ResponseEntity<ResponseWrapper<MovieDTO>> removeActorFromMovie(@PathVariable("movieId") Integer movieId, @PathVariable("actorId") Integer actorId){
        Movie movie = this.movieActorService.removeActorFromMovie(movieId, actorId);
        MovieDTO movieDTO = this.movieMapper.toMovieDTO(movie);
        return ResponseEntity.ok(new ResponseWrapper(movieDTO, HttpStatus.OK.value()));
    }



}
