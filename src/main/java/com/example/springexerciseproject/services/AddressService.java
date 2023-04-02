package com.example.springexerciseproject.services;

import com.example.springexerciseproject.domain.Address;
import com.example.springexerciseproject.web.v1.dtos.address.CreateAddressDTO;
import com.example.springexerciseproject.web.v1.dtos.address.UpdateAddressDTO;

public interface AddressService {
    Address getAddressForActor(Integer actorId);

    Address createAddressForActor(Integer actorId, CreateAddressDTO createAddressDTO);

    Address updateAddressForActor(Integer actorId, UpdateAddressDTO updateAddressDTO);

    void deleteAddressForActor(Integer actorId);
}
