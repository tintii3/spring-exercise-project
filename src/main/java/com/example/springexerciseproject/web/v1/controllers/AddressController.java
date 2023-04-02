package com.example.springexerciseproject.web.v1.controllers;

import com.example.springexerciseproject.domain.Actor;
import com.example.springexerciseproject.domain.Address;
import com.example.springexerciseproject.services.AddressService;
import com.example.springexerciseproject.utils.mappers.AddressMapper;
import com.example.springexerciseproject.web.v1.dtos.address.AddressDTO;
import com.example.springexerciseproject.web.v1.dtos.address.CreateAddressDTO;
import com.example.springexerciseproject.web.v1.dtos.address.UpdateAddressDTO;
import com.example.springexerciseproject.web.v1.wrappers.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = {"/api/v1"})
public class AddressController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressController(AddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = {"/actors/{actorId}/address"})
    public ResponseEntity<ResponseWrapper<AddressDTO>> getAddresForActor(@PathVariable("actorId") Integer actorId){
        Address address = this.addressService.getAddressForActor(actorId);
        AddressDTO addressDTO = this.addressMapper.toAddressDTO(address);
        return ResponseEntity.ok(new ResponseWrapper(addressDTO, HttpStatus.OK.value()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = {"/actors/{actorId}/address"})
    public ResponseEntity<ResponseWrapper<AddressDTO>> createAddressForActor(@PathVariable("actorId") Integer actorId, @RequestBody CreateAddressDTO createAddressDTO){
        Address createdAddress = this.addressService.createAddressForActor(actorId, createAddressDTO);
        AddressDTO createdAddressDTO = this.addressMapper.toAddressDTO(createdAddress);
        return ResponseEntity.ok(new ResponseWrapper(createdAddressDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = {"/actors/{actorId}/address"})
    public ResponseEntity<ResponseWrapper<AddressDTO>> updateAddressForActor(@PathVariable("actorId") Integer actorId, @RequestBody UpdateAddressDTO updateAddressDTO){
        Address updatedAddress = this.addressService.updateAddressForActor(actorId,updateAddressDTO);
        AddressDTO updatedAddressDTO = this.addressMapper.toAddressDTO(updatedAddress);
        return ResponseEntity.ok(new ResponseWrapper(updatedAddressDTO, HttpStatus.OK.value()));
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = {"/actors/{actorId}/address"})
    public ResponseEntity<Void> deleteAddressForActor(@PathVariable("actorId") Integer actorId){
        this.addressService.deleteAddressForActor(actorId);
        return ResponseEntity.noContent().build();
    }
}
