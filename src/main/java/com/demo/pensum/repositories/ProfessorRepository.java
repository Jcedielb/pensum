package com.demo.pensum.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.pensum.entities.ProfessorEntity;

public interface ProfessorRepository extends JpaRepository <ProfessorEntity, Long>{

}
