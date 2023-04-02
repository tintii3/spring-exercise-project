package com.example.springexerciseproject.exception.address;

import com.example.springexerciseproject.exception.general.ResourceExistsException;

public class AddressExistsException extends ResourceExistsException {
    public AddressExistsException(String s) {
        super(s);
    }
}
