package com.example.springexerciseproject.exception.movie;

import com.example.springexerciseproject.exception.general.ResourceNotFoundException;

public class MovieNotFoundException extends ResourceNotFoundException {
    public MovieNotFoundException(String s) {
        super(s);
    }
}
