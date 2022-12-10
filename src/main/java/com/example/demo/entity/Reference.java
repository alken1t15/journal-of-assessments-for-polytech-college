package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "reference")
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "teacher")
    private String teacher;

    @Column(name = "student")
    private String student;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "middle_name")
    private String middle_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "group_name")
    private String group_name;

    @Column(name = "name_file")
    private String name_file;

    public Reference() {
    }

    public Reference(String teacher, String student, String first_name, String middle_name, String last_name, String group_name, String name_file) {
        this.teacher = teacher;
        this.student = student;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.group_name = group_name;
        this.name_file = name_file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getName_file() {
        return name_file;
    }

    public void setName_file(String name_file) {
        this.name_file = name_file;
    }
}