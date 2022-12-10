package com.example.demo.dao;

import com.example.demo.entity.CalendarEstimates;
import com.example.demo.entity.CalendarPass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarPassRepository extends JpaRepository<CalendarPass, Integer> {
    public List<CalendarPass> findAllByStudent(String login);

    public List<CalendarPass> findAllByTeacherAndGroupNameAndItemName(String teacher, String nameGroup, String itemName);

    public List<CalendarPass> findAllByTeacherAndGroupNameAndItemNameAndMonth(String teacher, String nameGroup, String itemName, String month);

    public List<CalendarPass> findAllByTeacher(String teacher);

    public List<CalendarPass> findAllByStudentAndMonth(String student, String month);

    public List<CalendarPass> findAllById(int id);
}