package com.demo.pensum.dto;
import lombok.Data;

@Data
public class SubjectDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private int credits;
    private String image;
}

