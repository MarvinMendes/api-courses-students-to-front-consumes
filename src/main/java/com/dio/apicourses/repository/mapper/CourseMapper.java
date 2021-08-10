package com.dio.apicourses.repository.mapper;

import com.dio.apicourses.domain.Course;
import com.dio.apicourses.domain.dto.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CourseMapper {
    public static final CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    public abstract Course toEntity(CourseDTO dto);

    public abstract CourseDTO toDto(Course course);

}
