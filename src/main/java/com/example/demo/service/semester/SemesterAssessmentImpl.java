package com.example.demo.service.semester;

import com.example.demo.dao.SemesterAssessmentRepository;
import com.example.demo.entity.SemesterAssessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterAssessmentImpl implements SemesterAssessmentService {
    @Autowired
    private SemesterAssessmentRepository semesterAssessmentRepository;

    @Override
    public List<SemesterAssessment> findAllByStudent(String login) {
        return semesterAssessmentRepository.findAllByStudent(login);
    }

    @Override
    public List<SemesterAssessment> findAllByTeacher(String login) {
        return semesterAssessmentRepository.findAllByTeacher(login);
    }

    @Override
    public List<SemesterAssessment> findAllByTeacherAndGroupNameAndItemName(String teacher, String nameGroup, String itemName) {
        return semesterAssessmentRepository.findAllByTeacherAndGroupNameAndItemName(teacher, nameGroup, itemName);
    }

    @Override
    public List<SemesterAssessment> findAllById(int id) {
        return semesterAssessmentRepository.findAllById(id);
    }

    @Override
    public void saveSemesterAssessment(SemesterAssessment semesterAssessment) {
        semesterAssessmentRepository.save(semesterAssessment);
    }

    @Override
    public List<SemesterAssessment> findAllByTeacherAndGroupNameAndItemNameAndSemester(String teacher, String nameGroup, String itemName, String semester) {
        return semesterAssessmentRepository.findAllByTeacherAndGroupNameAndItemNameAndSemester(teacher, nameGroup, itemName, semester);
    }

    @Override
    public List<SemesterAssessment> findAllByStudentAndSemester(String login, String semester) {
        return semesterAssessmentRepository.findAllByStudentAndSemester(login, semester);
    }
}