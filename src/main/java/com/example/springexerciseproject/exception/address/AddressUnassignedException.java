package com.example.springexerciseproject.exception.address;

import com.example.springexerciseproject.exception.general.ResourceIllegalStateException;

public class AddressUnassignedException extends ResourceIllegalStateException{
    public AddressUnassignedException(String s) {
        super(s);
    }
}
