package com.example.springexerciseproject.services.impl;

import com.example.springexerciseproject.Repositories.ActorRepositories;
import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.domain.Address;
import com.example.springexerciseproject.exception.actor.ActorNotFoundException;
import com.example.springexerciseproject.exception.general.ResourceIllegalStateException;
import com.example.springexerciseproject.services.ActorService;
import com.example.springexerciseproject.web.v1.dtos.actor.CreateActorDTO;
import com.example.springexerciseproject.web.v1.dtos.actor.UpdateActorDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;

@Service
public class ActorServiceImpl implements ActorService {
    private final ActorRepositories actorRepositories;
    @Autowired
    public ActorServiceImpl(ActorRepositories actorRepositories) {
        this.actorRepositories = actorRepositories;
    }

    @Override
    public Collection<Actor> getAllActors() {
        return this.actorRepositories.findAll();
    }

    @Override
    public Actor getActor(Integer actorId) {
        return (Actor)this.actorRepositories.findById(actorId).orElseThrow(() -> {
            return new ActorNotFoundException("Actor could not be found.");
        });
    }

    @Override
    public Actor createActor(CreateActorDTO createActorDTO) {
        Actor newActor = new Actor();
        this.validateFirstNameAndLastName(createActorDTO.getFirstName(), createActorDTO.getLastname());
        BeanUtils.copyProperties(createActorDTO, newActor);
        if (createActorDTO.hasAddress()){
            if (Objects.isNull(createActorDTO.getAddress().getStreet()) || createActorDTO.getAddress().getStreet().isEmpty()){
                throw new ResourceIllegalStateException("Street must be specified.");
            }

            if (Objects.isNull(createActorDTO.getAddress().getCity()) || createActorDTO.getAddress().getCity().isEmpty()) {
                throw new ResourceIllegalStateException("City must be specified.");
            }

            if (Objects.isNull(createActorDTO.getAddress().getCountry()) || createActorDTO.getAddress().getCountry().isEmpty()) {
                throw new ResourceIllegalStateException("Country must be specified.");
            }
            Address address = new Address();
            BeanUtils.copyProperties(createActorDTO.getAddress(), address);
            newActor.setAddress(address);
        }

        newActor.activate();
        return (Actor)this.actorRepositories.saveAndFlush(newActor);
    }

    @Override
    public Actor updateActor(Integer actorId, UpdateActorDTO updateActorDTO) {
        Actor actor = this.getActor(actorId);
        this.validateFirstNameAndLastName(actor.getFirstName(), actor.getLastName());
        BeanUtils.copyProperties(updateActorDTO, actor);
        return (Actor)this.actorRepositories.saveAndFlush(actor);
    }

    @Override
    public void deleteActor(Integer actorId) {
        Actor actor = this.getActor(actorId);
        this.actorRepositories.delete(actor);
    }

    @Override
    public void activateActor(Integer actorId) {
        Actor actor = this.getActor(actorId);
        if (actor.isActive()){
            throw new ResourceIllegalStateException("Actor is already activated");
        } else {
            actor.activate();
            this.actorRepositories.saveAndFlush(actor);
        }
    }

    @Override
    public void deactivateActor(Integer actorId) {
        Actor actor = this.getActor(actorId);
        if (!actor.isActive()){
            throw new ResourceIllegalStateException("Actor is already deactivated.");
        } else {
            actor.deactivate();
            this.actorRepositories.saveAndFlush(actor);
        }
    }
    private void validateFirstNameAndLastName(String firstName, String lastName){
        if (!Objects.isNull(firstName) && !firstName.isEmpty()) {
            if (Objects.isNull(lastName) || lastName.isEmpty()) {
                throw new ResourceIllegalStateException("Last name must be specified.");
            }
        } else {
            throw new ResourceIllegalStateException("First name must be specified.");
        }
    }
}
