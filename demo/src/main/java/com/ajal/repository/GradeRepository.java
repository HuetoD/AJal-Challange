package com.ajal.repository;

import com.ajal.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

    List<Grade> findByStudentId(int studentId);

}
