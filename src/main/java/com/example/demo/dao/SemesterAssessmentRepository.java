package com.example.demo.dao;

import com.example.demo.entity.CalendarEstimates;
import com.example.demo.entity.CalendarPass;
import com.example.demo.entity.SemesterAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SemesterAssessmentRepository extends JpaRepository<SemesterAssessment, Integer> {
    public List<SemesterAssessment> findAllByStudent(String login);

    public List<SemesterAssessment> findAllByTeacher(String teacher);

    public List<SemesterAssessment> findAllByTeacherAndGroupNameAndItemName(String teacher, String nameGroup, String itemName);

    public List<SemesterAssessment> findAllById(int id);

    public List<SemesterAssessment> findAllByTeacherAndGroupNameAndItemNameAndSemester(String teacher, String nameGroup, String itemName, String semester);

    public List<SemesterAssessment> findAllByStudentAndSemester(String login, String semester);
}