package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "teacher")
    private String teacher;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "audience")
    private String audience;

    public Teacher() {
    }

    public Teacher(String firstName, String middleName, String lastName, String itemName, String audience) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.itemName = itemName;
        this.audience = audience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", audience='" + audience + '\'' +
                '}';
    }
}