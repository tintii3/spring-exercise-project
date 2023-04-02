package com.example.springexerciseproject.Repositories;

import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.domain.Movie;
import com.example.springexerciseproject.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ReviewRepositories extends JpaRepository<Review, Integer> {
    Collection<Review> findAllByMovie(Movie movie);
}
