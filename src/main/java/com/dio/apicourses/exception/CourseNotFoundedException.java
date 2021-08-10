package com.dio.apicourses.exception;

public class CourseNotFoundedException extends Exception {
    public CourseNotFoundedException(Long id) {
        super(String.format("Course with id: %s was not founded in database", id));
    }
}
