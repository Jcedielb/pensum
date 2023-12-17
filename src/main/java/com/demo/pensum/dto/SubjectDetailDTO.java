package com.demo.pensum.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class SubjectDetailDTO extends SubjectDTO{
    private List<ProfessorDTO> profesores = new ArrayList<>();
    private List<StudentDTO> estudiantes = new ArrayList<>();
    private List<SubjectDTO> prerequisitos = new ArrayList<>();
}
