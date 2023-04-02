package com.example.springexerciseproject.exception.actor;

import com.example.springexerciseproject.exception.general.ResourceExistsException;
import com.example.springexerciseproject.exception.general.ResourceIllegalStateException;

public class ActorExistsException extends ResourceExistsException {
    public ActorExistsException(String s) {
        super(s);
    }
}
