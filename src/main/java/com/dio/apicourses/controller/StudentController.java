package com.dio.apicourses.controller;

import com.dio.apicourses.domain.dto.StudentDTO;
import com.dio.apicourses.exception.StudentNotFoundedException;
import com.dio.apicourses.service.StudentService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/students")
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO save(@RequestBody StudentDTO dto) {
        return service.save(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentDTO> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDTO save(@PathVariable Long id) throws StudentNotFoundedException {
        return service.getById(id);
    }
    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentDTO replace(@PathVariable Long id, @RequestBody StudentDTO dto) throws StudentNotFoundedException {
        return service.replace(id, dto);
    }

}
