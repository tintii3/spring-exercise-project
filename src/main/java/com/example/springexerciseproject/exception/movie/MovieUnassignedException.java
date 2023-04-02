package com.example.springexerciseproject.exception.movie;

import com.example.springexerciseproject.exception.general.ResourceIllegalStateException;

public class MovieUnassignedException extends ResourceIllegalStateException{
    public MovieUnassignedException(String s) {
        super(s);
    }
}
