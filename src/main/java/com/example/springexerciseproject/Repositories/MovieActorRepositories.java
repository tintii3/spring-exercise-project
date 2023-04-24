package com.example.springexerciseproject.Repositories;

import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.domain.MovieActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieActorRepositories extends JpaRepository<MovieActor, Integer> {
}
