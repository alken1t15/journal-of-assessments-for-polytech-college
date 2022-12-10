package com.example.demo.service.calendarpass;

import com.example.demo.dao.CalendarPassRepository;
import com.example.demo.entity.CalendarPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarPassImpl implements CalendarPassService {
    @Autowired
    private CalendarPassRepository calendarPassRepository;


    @Override
    public List<CalendarPass> findAllByStudent(String login) {
        return calendarPassRepository.findAllByStudent(login);
    }

    @Override
    public List<CalendarPass> findAllByTeacherAndGroupNameAndItemName(String teacher, String nameGroup, String itemName) {
        return calendarPassRepository.findAllByTeacherAndGroupNameAndItemName(teacher, nameGroup, itemName);
    }

    @Override
    public List<CalendarPass> findAllByTeacher(String teacher) {
        return calendarPassRepository.findAllByTeacher(teacher);
    }

    @Override
    public List<CalendarPass> findAllByStudentAndMonth(String student, String month) {
        return calendarPassRepository.findAllByStudentAndMonth(student, month);
    }

    @Override
    public List<CalendarPass> findAllByTeacherAndGroupNameAndItemNameAndMonth(String teacher, String nameGroup, String itemName, String month) {
        return calendarPassRepository.findAllByTeacherAndGroupNameAndItemNameAndMonth(teacher, nameGroup, itemName, month);
    }

    @Override
    public List<CalendarPass> findAllById(int id) {
        return calendarPassRepository.findAllById(id);
    }

    @Override
    public void saveReference(CalendarPass calendarPass) {
        calendarPassRepository.save(calendarPass);
    }
}