package com.example.demo.service.calendar;

import com.example.demo.dao.CalendarEstimatesRepository;
import com.example.demo.entity.CalendarEstimates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEstimatesImpl implements CalendarEstimatesService {
    @Autowired
    private CalendarEstimatesRepository calendarEstimatesRepository;


    @Override
    public List<CalendarEstimates> findAllByStudent(String login) {
        return calendarEstimatesRepository.findAllByStudent(login);
    }

    @Override
    public List<CalendarEstimates> findAllByTeacherAndGroupNameAndItemName(String teacher, String nameGroup, String itemName) {
        return calendarEstimatesRepository.findAllByTeacherAndGroupNameAndItemName(teacher, nameGroup, itemName);
    }

    @Override
    public List<CalendarEstimates> findAllByTeacher(String teacher) {
        return calendarEstimatesRepository.findAllByTeacher(teacher);
    }

    @Override
    public List<CalendarEstimates> findAllByStudentAndMonth(String student, String month) {
        return calendarEstimatesRepository.findAllByStudentAndMonth(student, month);
    }

    @Override
    public List<CalendarEstimates> findAllByTeacherAndGroupNameAndItemNameAndMonth(String teacher, String nameGroup, String itemName, String month) {
        return calendarEstimatesRepository.findAllByTeacherAndGroupNameAndItemNameAndMonth(teacher, nameGroup, itemName, month);
    }

    @Override
    public List<CalendarEstimates> findAllById(int id) {
        return calendarEstimatesRepository.findAllById(id);
    }

    @Override
    public void saveReference(CalendarEstimates calendarEstimates) {
        calendarEstimatesRepository.save(calendarEstimates);
    }

    @Override
    public List<CalendarEstimates> findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(String teacher, String nameGroup, String itemName, String month, String student) {
        return calendarEstimatesRepository.findAllByTeacherAndGroupNameAndItemNameAndMonthAndStudent(teacher, nameGroup, itemName, month, student);
    }
}