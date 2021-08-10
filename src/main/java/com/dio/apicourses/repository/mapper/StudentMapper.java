package com.dio.apicourses.repository.mapper;

import com.dio.apicourses.domain.Student;
import com.dio.apicourses.domain.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class StudentMapper {

    public static final StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    public abstract StudentDTO toDto(Student student);

    public abstract Student toEntity(StudentDTO dto);

}
