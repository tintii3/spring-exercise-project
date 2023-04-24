package com.example.springexerciseproject.services;

import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.web.v1.dtos.actor.CreateActorDTO;
import com.example.springexerciseproject.web.v1.dtos.actor.UpdateActorDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface ActorService {

    Collection<Actor> getAllActors();

    Actor getActor(Integer actorId);

    Actor createActor(CreateActorDTO createActorDTO);

    Actor updateActor(Integer actorId, UpdateActorDTO updateActorDTO);

    void deleteActor(Integer actorId);

    void activateActor(Integer actorId);

    void deactivateActor(Integer actorId);
}
