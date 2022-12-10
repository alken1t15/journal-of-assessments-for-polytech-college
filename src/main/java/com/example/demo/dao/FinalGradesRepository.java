package com.example.demo.dao;

import com.example.demo.entity.FinalGrades;
import com.example.demo.entity.SemesterAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinalGradesRepository extends JpaRepository<FinalGrades, Integer> {
    public List<FinalGrades> findAllByStudent(String login);
}