package com.example.springexerciseproject.services.impl;

import com.example.springexerciseproject.Repositories.AddressRepositories;
import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.domain.Address;
import com.example.springexerciseproject.exception.address.AddressExistsException;
import com.example.springexerciseproject.exception.address.AddressNotFoundException;
import com.example.springexerciseproject.exception.general.ResourceIllegalStateException;
import com.example.springexerciseproject.services.ActorService;
import com.example.springexerciseproject.services.AddressService;
import com.example.springexerciseproject.web.v1.dtos.address.CreateAddressDTO;
import com.example.springexerciseproject.web.v1.dtos.address.UpdateAddressDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepositories addressRepositories;
    private final ActorService actorService;

    @Autowired
    public AddressServiceImpl(AddressRepositories addressRepositories, ActorService actorService) {
        this.addressRepositories = addressRepositories;
        this.actorService = actorService;
    }

    @Override
    public Address getAddressForActor(Integer actorId) {
        Actor actor = this.actorService.getActor(actorId);
        return (Address) this.addressRepositories.findAddressByActor(actor).orElseThrow(() -> {
            return new AddressNotFoundException("Address could not be found.");
        });
    }

    @Override
    public Address createAddressForActor(Integer actorId, CreateAddressDTO createAddressDTO) {
        Actor actor = this.actorService.getActor(actorId);
        if (actor.hasAddress()){
            throw new AddressExistsException("Address already exists for the specified actor.");
        } else if (!Objects.isNull(createAddressDTO.getStreet()) && !createAddressDTO.getStreet().isEmpty()){
            if (!Objects.isNull(createAddressDTO.getCity()) && !createAddressDTO.getCity().isEmpty()){
                if (!Objects.isNull(createAddressDTO.getCountry()) && !createAddressDTO.getCountry().isEmpty()){
                    Address address = new Address();
                    BeanUtils.copyProperties(createAddressDTO, address);
                    actor.setAddress(address);
                    return (Address) this.addressRepositories.saveAndFlush(address);
                } else {
                    throw new ResourceIllegalStateException("Country must be specified.");
                }
            } else {
                throw new ResourceIllegalStateException("City must be specified.");
            }
        }
        else {
            throw new ResourceIllegalStateException("Street must be specified.");
        }
    }

    @Override
    public Address updateAddressForActor(Integer actorId, UpdateAddressDTO updateAddressDTO) {
        Actor actor = actorService.getActor(actorId);
        Address address = (Address) this.addressRepositories.findAddressByActor(actor).orElseThrow(() ->{
            throw new AddressNotFoundException("Address could not be found for the specified actor.");
        });
        if (!Objects.isNull(updateAddressDTO.getStreet()) && !updateAddressDTO.getStreet().isEmpty()){
            if (!Objects.isNull(updateAddressDTO.getCity()) && !updateAddressDTO.getCity().isEmpty()){
                if (!Objects.isNull(updateAddressDTO.getCountry()) && !updateAddressDTO.getCountry().isEmpty()){
                    BeanUtils.copyProperties(updateAddressDTO, address);
                    return (Address) this.addressRepositories.saveAndFlush(address);
                } else {
                    throw new ResourceIllegalStateException("Country must be specified.");
                }
            } else {
                throw new ResourceIllegalStateException("City must be specified.");
            }
        }
        else {
            throw new ResourceIllegalStateException("Street must be specified.");
        }
    }

    @Override
    public void deleteAddressForActor(Integer actorId) {
        Actor actor = this.actorService.getActor(actorId);
        Address address = (Address) this.addressRepositories.findAddressByActor(actor).orElseThrow(() -> {
            throw new AddressNotFoundException("Actor does't have a address.");
        });
        actor.unsetRelationship(address);
        this.addressRepositories.delete(address);
    }
}
