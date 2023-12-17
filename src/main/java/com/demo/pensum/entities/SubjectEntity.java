package com.demo.pensum.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class SubjectEntity extends BaseEntity{
    private String code;
    private String name;
    private String description;
    private int credits;
    private String image;

    // Relación con prerequisitos
    @ManyToMany
    @JoinTable(
        name = "subject_prerequisite",
        joinColumns = @JoinColumn(name = "subject_id"),
        inverseJoinColumns = @JoinColumn(name = "prerequisite_id")
    )
    private List<SubjectEntity> prerequisites;
    
    // Relación con notas
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GradeEntity> notes;

    @ManyToMany
    @JoinTable(name = "professor_subject",
               joinColumns = @JoinColumn(name = "subject_id"),
               inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<ProfessorEntity> professors;

    @ManyToMany
    @JoinTable(name = "student_subject",
               joinColumns = @JoinColumn(name = "subject_id"),
               inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<StudentEntity> students;
}
