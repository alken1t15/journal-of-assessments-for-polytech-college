package com.example.demo.dao;

import com.example.demo.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Integer> {  // 1 дженерики с каким entity будет работать 2 какое поле являеться primary key

    public List<People> findAllByUsername(String username);

    public List<People> findAllByTeacher(String teacher);

    public List<People> findAllById(int id);

    public List<People> findAllByLastNameAndFirstNameAndMiddleName(String lastName, String firstName, String middleName);

}