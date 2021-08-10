package com.dio.apicourses.service;

import com.dio.apicourses.domain.Course;
import com.dio.apicourses.domain.dto.CourseDTO;
import com.dio.apicourses.exception.CourseNotFoundedException;
import com.dio.apicourses.repository.CourseRepository;
import com.dio.apicourses.repository.mapper.CourseMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class CourseService {

    private CourseRepository repository;
    private final CourseMapper mapper = CourseMapper.INSTANCE;

    @Autowired
    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CourseDTO save(CourseDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Transactional(readOnly = true)
    public List<CourseDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CourseDTO getById(Long id) throws CourseNotFoundedException {
        return mapper.toDto( repository.findById(id).orElseThrow(() -> new CourseNotFoundedException(id)));
    }

    @Transactional
    public CourseDTO replace(Long id, CourseDTO dto) throws CourseNotFoundedException {
        Course course = repository.findById(id).orElseThrow(() -> new CourseNotFoundedException(id));
        course.setDescription(dto.getDescription());
        course.setName(dto.getName());
        course.setPrice(dto.getPrice());
        course.setRating(dto.getRating());
        repository.save(course);
        return mapper.toDto(course);
    }

    @Transactional
    public void delete(Long id) throws CourseNotFoundedException {
        repository.delete(mapper.toEntity(getById(id)));
    }
}
