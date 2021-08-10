package com.dio.apicourses.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class StudentDTO {
    private Long id;

    private String name;

    private Integer age;

    private String cpf;

    private String email;

    private String phone;
}
