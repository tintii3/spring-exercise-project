package com.example.springexerciseproject.exception.actor;

import com.example.springexerciseproject.exception.general.ResourceIllegalStateException;

public class ActorUnassignedException extends ResourceIllegalStateException{
    public ActorUnassignedException(String s) {
        super(s);
    }
}
