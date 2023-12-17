package com.demo.pensum.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.pensum.entities.GradeEntity;

public interface GradeRepository extends JpaRepository <GradeEntity, Long> {

}
