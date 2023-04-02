package com.example.springexerciseproject.exception.address;

import com.example.springexerciseproject.exception.general.ResourceNotFoundException;

public class AddressNotFoundException extends ResourceNotFoundException {
    public AddressNotFoundException(String s) {
        super(s);
    }
}
