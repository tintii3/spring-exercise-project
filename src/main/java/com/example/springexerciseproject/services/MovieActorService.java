package com.example.springexerciseproject.services;

import com.example.springexerciseproject.domain.Movie;

public interface MovieActorService {
    Movie addActorToMovie(Integer movieId, Integer actorId);

    Movie removeActorFromMovie(Integer movieId, Integer actorId);
}
