package com.example.springexerciseproject.Repositories;

import com.example.springexerciseproject.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepositories extends JpaRepository<Actor, Integer> {
}
