package com.dio.apicourses.controller;

import com.dio.apicourses.domain.dto.CourseDTO;
import com.dio.apicourses.exception.CourseNotFoundedException;
import com.dio.apicourses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/course")
public class CourseController {

    private CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@RequestBody CourseDTO dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> getById(@PathVariable Long id) throws CourseNotFoundedException {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CourseDTO> replace(@PathVariable Long id, @RequestBody CourseDTO dto) throws CourseNotFoundedException {
        return new ResponseEntity<>(service.replace(id, dto), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id) throws CourseNotFoundedException {
        service.delete(id);
    }

}
