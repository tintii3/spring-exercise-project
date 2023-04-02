package com.example.springexerciseproject.utils.mappers;

import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.utils.criteria.ActorCriteria;
import com.example.springexerciseproject.web.v1.dtos.actor.ActorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ActorMapper {

    @Autowired
    private AddressMapper addressMapper;

    public Collection<ActorDTO> toActorDTOs(Collection<Actor> actors, ActorCriteria actorCriteria){
        if (Objects.isNull(actorCriteria)){
            return toActorDTOs(actors);
        }
        if (!actorCriteria.includeAddress()){
            return toActorDTOs(actors);
        }
        return toActorDTOsWithAddress(actors);
    }
    public Collection<ActorDTO> toActorDTOs(Collection<Actor> actors){
        return actors.stream().map(this::toActorDTO).collect(Collectors.toList());
    }
    public ActorDTO toActorDTO(Actor actor, ActorCriteria actorCriteria){
        if (Objects.isNull(actorCriteria)){
            return toActorDTO(actor);
        }
        if (!actorCriteria.includeAddress()){
            return toActorDTO(actor);
        }
        return toActorDTOWithAddress(actor);
    }

    public ActorDTO toActorDTO(Actor actor){
        return ActorDTO.builder()
                .actorId(actor.getActorId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .age(actor.getAge())
                .isActive(actor.isActive())
                .build();
    }
    public Collection<ActorDTO> toActorDTOsWithAddress(Collection<Actor> actors) {
        return actors.stream().map(this::toActorDTOWithAddress).collect(Collectors.toList());
    }
    public ActorDTO toActorDTOWithAddress(Actor actor) {
        ActorDTO actorDTO = toActorDTO(actor);
        actorDTO.setAddress(actor.hasAddress() ? addressMapper.toAddressDTO(actor.getAddress()) : null);
        return actorDTO;
    }

}
