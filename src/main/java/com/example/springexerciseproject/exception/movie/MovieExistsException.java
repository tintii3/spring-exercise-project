package com.example.springexerciseproject.exception.movie;

import com.example.springexerciseproject.exception.general.ResourceExistsException;

public class MovieExistsException extends ResourceExistsException {
    public MovieExistsException(String s) {
        super(s);
    }
}
