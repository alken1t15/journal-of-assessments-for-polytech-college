package com.example.demo.dao;

import com.example.demo.entity.CalendarEstimates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarEstimatesRepository extends JpaRepository<CalendarEstimates, Integer> {
    public List<CalendarEstimates> findAllByStudent(String login);

    public List<CalendarEstimates> findAllByTeacherAndGroupNameAndItemName(String teacher, String nameGroup, String itemName);

    public List<CalendarEstimates> findAllByTeacherAndGroupNameAndItemNameAndMonth(String teacher, String nameGroup, String itemName, String month);


    public List<CalendarEstimates> findAllByTeacher(String teacher);

    public List<CalendarEstimates> findAllByStudentAndMonth(String student, String month);

    public List<CalendarEstimates> findAllById(int id);

    public List<CalendarEstimates> findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(String teacher, String nameGroup, String itemName, String month, String student);
}