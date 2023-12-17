package com.demo.pensum.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.pensum.entities.SubjectEntity;

public interface SubjectRepository extends JpaRepository <SubjectEntity, Long>{

}
