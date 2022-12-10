package com.example.demo.service.teachers;

import com.example.demo.dao.PeopleRepository;
import com.example.demo.dao.TeacherRepository;
import com.example.demo.entity.People;
import com.example.demo.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAllBy() {
        return teacherRepository.findAllBy();
    }

    @Override
    public List<Teacher> findAllById(int id) {
        return teacherRepository.findAllById(id);
    }

    @Override
    public List<Teacher> findAllByTeacher(String teacher) {
        return teacherRepository.findAllByTeacher(teacher);
    }
}