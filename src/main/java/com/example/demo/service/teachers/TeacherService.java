package com.example.demo.service.teachers;

import com.example.demo.entity.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> findAllBy();

    public List<Teacher> findAllById(int id);

    public List<Teacher> findAllByTeacher(String teacher);
}