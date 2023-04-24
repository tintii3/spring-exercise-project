package com.example.springexerciseproject.Repositories;

import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepositories extends JpaRepository<Movie, Integer> {
}
