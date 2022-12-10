package com.example.demo.service.finalgrade;

import com.example.demo.dao.FinalGradesRepository;
import com.example.demo.entity.FinalGrades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalGradesImpl implements FinalGradesService {
    @Autowired
    private FinalGradesRepository finalGradesRepository;

    @Override
    public List<FinalGrades> findAllByStudent(String login) {
        return finalGradesRepository.findAllByStudent(login);
    }
}