package com.example.springexerciseproject.exception.review;

import com.example.springexerciseproject.exception.general.ResourceIllegalStateException;

public class ReviewUnassignedException extends ResourceIllegalStateException{
    public ReviewUnassignedException(String s) {
        super(s);
    }
}
