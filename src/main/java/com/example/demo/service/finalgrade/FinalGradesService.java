package com.example.demo.service.finalgrade;

import com.example.demo.entity.FinalGrades;

import java.util.List;

public interface FinalGradesService {
    public List<FinalGrades> findAllByStudent(String login);
}