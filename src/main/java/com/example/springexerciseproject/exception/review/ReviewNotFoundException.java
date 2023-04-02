package com.example.springexerciseproject.exception.review;

import com.example.springexerciseproject.exception.general.ResourceNotFoundException;

public class ReviewNotFoundException extends ResourceNotFoundException {
    public ReviewNotFoundException(String s) {
        super(s);
    }
}
