package com.example.demo.dao;

import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    public List<Teacher> findAllBy();

    public List<Teacher> findAllById(int id);

    public List<Teacher> findAllByTeacher(String teacher);
}