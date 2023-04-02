package com.example.springexerciseproject.exception.actor;

import com.example.springexerciseproject.exception.general.ResourceIllegalStateException;
import com.example.springexerciseproject.exception.general.ResourceNotFoundException;

public class ActorNotFoundException extends ResourceNotFoundException {
    public ActorNotFoundException(String s) {
        super(s);
    }
}
