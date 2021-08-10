package com.dio.apicourses.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Long id;

    @NonNull
    private String name;
    @NonNull
    private BigDecimal price;
    @NonNull
    private String description;
    private Float rating;
}
