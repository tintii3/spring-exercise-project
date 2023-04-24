package com.example.springexerciseproject.Repositories;

import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.domain.Movie;
import com.example.springexerciseproject.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
@Repository
public interface ReviewRepositories extends JpaRepository<Review, Integer> {
    Collection<Review> findAllByMovie(Movie movie);
}
