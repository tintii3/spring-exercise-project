package com.example.springexerciseproject.exception.review;

import com.example.springexerciseproject.exception.general.ResourceExistsException;

public class ReviewExistsException extends ResourceExistsException {
    public ReviewExistsException(String s) {
        super(s);
    }
}
