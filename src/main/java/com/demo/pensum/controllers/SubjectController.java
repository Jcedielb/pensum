package com.demo.pensum.controllers;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pensum.dto.SubjectDTO;
import com.demo.pensum.dto.SubjectDetailDTO;
import com.demo.pensum.entities.SubjectEntity;
import com.demo.pensum.exceptions.EntityNotFoundException;
import com.demo.pensum.exceptions.IllegalOperationException;
import com.demo.pensum.services.SubjectService;


@RestController
@RequestMapping("/subjects")
public class SubjectController {

        @Autowired
        private SubjectService subjectService;
        
        @Autowired
        private ModelMapper modelMapper;

        @GetMapping
        @ResponseStatus(code = HttpStatus.OK)
        public List<SubjectDetailDTO> findAll() {
            List<SubjectEntity> subjects = subjectService.getSubjects();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return modelMapper.map(subjects, new TypeToken<List<SubjectDetailDTO>>() {}.getType());
        }

        @GetMapping(value = "/{id}")
        @ResponseStatus(code = HttpStatus.OK)
        public SubjectDetailDTO findOne(@PathVariable("id") Long id) throws EntityNotFoundException {
            SubjectEntity subjectEntity = subjectService.getSubject(id);
            return modelMapper.map(subjectEntity, SubjectDetailDTO.class);
        }

        @PostMapping
        @ResponseStatus(code = HttpStatus.CREATED)
        public SubjectDTO create(@RequestBody SubjectDTO subjectDTO) throws IllegalOperationException {
            SubjectEntity subjectEntity = subjectService.createSubject(modelMapper.map(subjectDTO, SubjectEntity.class));
            return modelMapper.map(subjectEntity, SubjectDTO.class);
        }

        @DeleteMapping(value = "/{id}")
        @ResponseStatus(code = HttpStatus.NO_CONTENT)
        public void delete(@PathVariable("id") Long id) throws EntityNotFoundException, IllegalOperationException {
        subjectService.deleteSubject(id);
    }
}
