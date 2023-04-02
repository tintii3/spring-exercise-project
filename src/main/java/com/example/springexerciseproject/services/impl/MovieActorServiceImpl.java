package com.example.springexerciseproject.services.impl;

import com.example.springexerciseproject.Repositories.ActorRepositories;
import com.example.springexerciseproject.Repositories.MovieRepositories;
import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.domain.Movie;
import com.example.springexerciseproject.exception.actor.ActorNotFoundException;
import com.example.springexerciseproject.exception.general.ResourceIllegalStateException;
import com.example.springexerciseproject.exception.movie.MovieNotFoundException;
import com.example.springexerciseproject.services.MovieActorService;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieActorServiceImpl implements MovieActorService {
    private final MovieRepositories movieRepositories;
    private final ActorRepositories actorRepositories;

    @Autowired
    public MovieActorServiceImpl(MovieRepositories movieRepositories, ActorRepositories actorRepositories) {
        this.movieRepositories = movieRepositories;
        this.actorRepositories = actorRepositories;
    }

    @Override
    public Movie addActorToMovie(Integer movieId, Integer actorId) {
        Movie movie = (Movie) this.movieRepositories.findById(movieId).orElseThrow(() -> {
            throw new MovieNotFoundException("Movie could not be found.");
        });
        Actor actor = (Actor) this.actorRepositories.findById(actorId).orElseThrow(() -> {
            throw new ActorNotFoundException("Actor could not be found.");
        });
        if (movie.hasActor(actorId)){
            throw new ResourceIllegalStateException("Actor is already assigned to this movie.");
        } else {
            movie.addActor(actor);
            return (Movie) this.movieRepositories.saveAndFlush(movie);
        }
    }

    @Override
    public Movie removeActorFromMovie(Integer movieId, Integer actorId) {
        Movie movie = (Movie) this.movieRepositories.findById(movieId).orElseThrow(() -> {
            throw new MovieNotFoundException("Movie could not be found.");
        });
        Actor actor = (Actor) this.actorRepositories.findById(actorId).orElseThrow(() -> {
            throw new ActorNotFoundException("Actor could not be found.");
        });
        if (!movie.hasActor(actorId)){
            throw new ResourceIllegalStateException("Actor is not assigned to this movie.");
        } else {
            movie.removeActor(actor);
            return (Movie) this.movieRepositories.saveAndFlush(movie);
        }
    }
}
