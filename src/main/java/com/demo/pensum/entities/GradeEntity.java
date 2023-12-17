package com.demo.pensum.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class GradeEntity extends BaseEntity{
    private String name; // Nombre de la nota
    private Double note; // Representa la nota en términos numéricos
    private Double percentage; // Porcentaje de la nota respecto al total de la materia

    // Relación con la materia
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private SubjectEntity subject;

}
