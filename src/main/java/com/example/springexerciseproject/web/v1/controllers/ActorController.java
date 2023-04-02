package com.example.springexerciseproject.web.v1.controllers;

import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.services.ActorService;
import com.example.springexerciseproject.utils.criteria.ActorCriteria;
import com.example.springexerciseproject.utils.mappers.ActorMapper;
import com.example.springexerciseproject.web.v1.dtos.actor.ActorDTO;
import com.example.springexerciseproject.web.v1.dtos.actor.CreateActorDTO;
import com.example.springexerciseproject.web.v1.dtos.actor.UpdateActorDTO;
import com.example.springexerciseproject.web.v1.wrappers.ResponseWrapper;
import jakarta.servlet.ServletResponseWrapper;
import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = {"/api/v1"})
public class ActorController {
    private final ActorService actorService;
    private final ActorMapper actorMapper;
    @Autowired
    public ActorController(ActorService actorService, ActorMapper actorMapper) {
        this.actorService = actorService;
        this.actorMapper = actorMapper;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/actors"}, produces = {"aplication/json"})
    public ResponseEntity<ResponseWrapper<Collection<ActorDTO>>> getAllActors(ActorCriteria actorCriteria){
        Collection<Actor> actors = this.actorService.getAllActors();
        Collection<ActorDTO> actorDTOS = this.actorMapper.toActorDTOs(actors);
        return ResponseEntity.ok(new ResponseWrapper<>(actorDTOS, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/actors/{actorId}"}, produces = {"application/json"})
    public ResponseEntity<ResponseWrapper<ActorDTO>> getActor(@PathVariable("actorId") Integer actorId, ActorCriteria actorCriteria){
        Actor actor = this.actorService.getActor(actorId);
        ActorDTO actorDTO = this.actorMapper.toActorDTO(actor, actorCriteria);
        return ResponseEntity.ok(new ResponseWrapper<>(actorDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = {"/actors"}, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ResponseWrapper<ActorDTO>> createActor(@RequestBody CreateActorDTO createActorDTO) {
        Actor createdActor = this.actorService.createActor(createActorDTO);
        ActorDTO createdActorDTO = this.actorMapper.toActorDTO(createdActor);
        return ResponseEntity.ok(new ResponseWrapper(createdActorDTO, HttpStatus.OK.value()));

    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = {"/actors/{actorId}"}, produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<ResponseWrapper<ActorDTO>> updateActor(@PathVariable("actorId") Integer actorId, @RequestBody UpdateActorDTO updateActorDTO){
        Actor updatedActor = this.actorService.updateActor(actorId, updateActorDTO);
        ActorDTO updatedActorDTO = this.actorMapper.toActorDTO(updatedActor);
        return ResponseEntity.ok(new ResponseWrapper(updatedActorDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/actors/{actorId}"})
    public ResponseEntity<Void> deleteActor(@PathVariable("actorId") Integer actorId){
        this.actorService.deleteActor(actorId);
        return ResponseEntity.noContent().build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = {"/actors/{actorId}/activate"})
    public ResponseEntity<Void> activateActor(@PathVariable("actorId") Integer actorId){
        this.actorService.activateActor(actorId);
        return ResponseEntity.noContent().build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = {"/actors/{actorId}/deactivate"})
    public ResponseEntity<Void> deactivateActor(@PathVariable("actorId") Integer actorId){
        this.actorService.deactivateActor(actorId);
        return ResponseEntity.noContent().build();
    }
}