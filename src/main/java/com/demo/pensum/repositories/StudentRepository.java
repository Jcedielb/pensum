package com.demo.pensum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.pensum.entities.StudentEntity;

public interface StudentRepository extends JpaRepository <StudentEntity, Long>{

}
