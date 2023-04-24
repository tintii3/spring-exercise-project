package com.example.springexerciseproject.Repositories;

import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AddressRepositories extends JpaRepository<Address, Integer> {
    Optional<Address> findAddressByActor(Actor actor);
}
