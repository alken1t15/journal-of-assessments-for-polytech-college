package com.example.demo.service.calendarpass;

import com.example.demo.entity.CalendarEstimates;
import com.example.demo.entity.CalendarPass;

import java.util.List;

public interface CalendarPassService {
    public List<CalendarPass> findAllByStudent(String login);

    public List<CalendarPass> findAllByTeacherAndGroupNameAndItemName(String teacher, String nameGroup, String itemName);

    public List<CalendarPass> findAllByTeacherAndGroupNameAndItemNameAndMonth(String teacher, String nameGroup, String itemName, String month);

    public List<CalendarPass> findAllByTeacher(String teacher);

    public List<CalendarPass> findAllByStudentAndMonth(String student, String month);

    public List<CalendarPass> findAllById(int id);

    public void saveReference(CalendarPass calendarPass);
}