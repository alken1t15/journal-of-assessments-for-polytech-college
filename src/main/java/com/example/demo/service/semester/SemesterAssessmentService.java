package com.example.demo.service.semester;

import com.example.demo.entity.CalendarEstimates;
import com.example.demo.entity.CalendarPass;
import com.example.demo.entity.SemesterAssessment;

import java.util.List;

public interface SemesterAssessmentService {
    public List<SemesterAssessment> findAllByStudent(String login);

    public List<SemesterAssessment> findAllByTeacher(String teacher);

    public List<SemesterAssessment> findAllByTeacherAndGroupNameAndItemName(String teacher, String nameGroup, String itemName);

    public List<SemesterAssessment> findAllById(int id);

    public void saveSemesterAssessment(SemesterAssessment semesterAssessment);

    public List<SemesterAssessment> findAllByTeacherAndGroupNameAndItemNameAndSemester(String teacher, String nameGroup, String itemName, String semester);

    public List<SemesterAssessment> findAllByStudentAndSemester(String login, String semester);
}