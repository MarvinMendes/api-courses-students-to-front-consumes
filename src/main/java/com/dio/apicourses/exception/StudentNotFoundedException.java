package com.dio.apicourses.exception;

public class StudentNotFoundedException extends Exception {
    public StudentNotFoundedException(Long id) {
        super(String.format("Student was not founded in database %s", id));
    }
}
