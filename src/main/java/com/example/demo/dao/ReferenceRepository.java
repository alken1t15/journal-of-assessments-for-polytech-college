package com.example.demo.dao;

import com.example.demo.entity.Reference;
import com.example.demo.entity.SemesterAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReferenceRepository extends JpaRepository<Reference, Integer> {
    public List<Reference> findAllByStudent(String login);
}