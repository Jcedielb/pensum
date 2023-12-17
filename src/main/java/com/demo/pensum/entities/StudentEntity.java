package com.demo.pensum.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class StudentEntity extends BaseEntity{
    private String code;
    private String name;
    private String department;
    private String image;

    @ManyToMany(mappedBy = "students")
    private List<SubjectEntity> subjects;
}
