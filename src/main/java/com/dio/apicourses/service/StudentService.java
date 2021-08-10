package com.dio.apicourses.service;

import com.dio.apicourses.domain.dto.StudentDTO;
import com.dio.apicourses.exception.StudentNotFoundedException;
import com.dio.apicourses.repository.StudentRepository;
import com.dio.apicourses.repository.mapper.StudentMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class StudentService {

    private StudentRepository repository;
    private final StudentMapper mapper = StudentMapper.INSTANCE;


    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public StudentDTO save(StudentDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Transactional(readOnly = true)
    public List<StudentDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StudentDTO getById(Long id) throws StudentNotFoundedException {
        return findById(id);
    }

    private StudentDTO findById(Long id) throws StudentNotFoundedException {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new StudentNotFoundedException(id)));
    }

    @Transactional
    public StudentDTO replace(Long id, StudentDTO dto) throws StudentNotFoundedException {
        StudentDTO studentForUpdate = findById(id);
        studentForUpdate.setId(id);
        studentForUpdate.setName(dto.getName());
        studentForUpdate.setAge(dto.getAge());
        studentForUpdate.setCpf(dto.getCpf());
        studentForUpdate.setEmail(dto.getEmail());
        studentForUpdate.setPhone(dto.getPhone());
        return save(studentForUpdate);
    }
}
