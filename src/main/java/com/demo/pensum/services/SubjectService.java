package com.demo.pensum.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pensum.entities.SubjectEntity;
import com.demo.pensum.exceptions.EntityNotFoundException;
import com.demo.pensum.exceptions.ErrorMessage;
import com.demo.pensum.exceptions.IllegalOperationException;
import com.demo.pensum.repositories.ProfessorRepository;
import com.demo.pensum.repositories.SubjectRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class SubjectService {
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Transactional
    public SubjectEntity createSubject(SubjectEntity subjectEntity) throws IllegalOperationException {
        log.info("Inicia proceso de creación de la materia");
        validateSubject(subjectEntity);
        log.info("Termina proceso de creación de materia");
        return subjectRepository.save(subjectEntity);
    }
    private void validateSubject(SubjectEntity subjectEntity) throws IllegalOperationException {
        if (subjectEntity.getName() == null || subjectEntity.getName().isEmpty()) {
            throw new IllegalOperationException("Nombre de materia no valido");
        }
        if (subjectEntity.getProfessors().isEmpty()) {
            throw new IllegalOperationException("Profesor no valida");
        }
        List<SubjectEntity> lista = subjectRepository.findAll();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getName().equalsIgnoreCase(subjectEntity.getCode())) {
            throw new IllegalOperationException("Codigo de la materia ya existe");
            }
        }

    }
    @Transactional
    public List<SubjectEntity> getSubjects() {
        log.info("Inicia proceso de consultar todas las materias");
        return subjectRepository.findAll();
    }
    @Transactional
    public SubjectEntity getSubject(Long idSubject) throws EntityNotFoundException {
        log.info("Inicia proceso de consultar la materia con id =", idSubject);
        return subjectRepository.findById(idSubject)
                .orElseThrow(() -> new EntityNotFoundException(ErrorMessage.SUBJECT_NOT_FOUND));
    }

    @Transactional
    public void deleteSubject(Long idSubject) throws EntityNotFoundException, IllegalOperationException {
        log.info("Inicia proceso de borrar la seleccion con id =" + idSubject);
        subjectRepository.deleteById(idSubject);
        log.info("Termina proceso de borrar la seleccion con id =", + idSubject);
    }

}
