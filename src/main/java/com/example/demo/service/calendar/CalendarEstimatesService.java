package com.example.demo.service.calendar;

import com.example.demo.entity.CalendarEstimates;

import java.util.List;

public interface CalendarEstimatesService {
    public List<CalendarEstimates> findAllByStudent(String login);

    public List<CalendarEstimates> findAllByTeacherAndGroupNameAndItemName(String teacher, String nameGroup, String itemName);

    public List<CalendarEstimates> findAllByTeacher(String teacher);

    public List<CalendarEstimates> findAllByStudentAndMonth(String student, String month);

    public List<CalendarEstimates> findAllByTeacherAndGroupNameAndItemNameAndMonth(String teacher, String nameGroup, String itemName, String month);

    public List<CalendarEstimates> findAllById(int id);

    public void saveReference(CalendarEstimates calendarEstimates);

    public List<CalendarEstimates> findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(String teacher, String nameGroup, String itemName, String month, String student);
}