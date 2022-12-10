package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "semesterassessment")
public class SemesterAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "teacher")
    private String teacher;

    @Column(name = "student")
    private String student;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "monthly_estimate")
    private String monthlyEstimate;

    @Column(name = "semester")
    private String semester;

    @Column(name = "credit_work")
    private String creditWork;

    @Column(name = "semester_result")
    private String semesterResult;

    public SemesterAssessment() {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getMonthlyEstimate() {
        return monthlyEstimate;
    }

    public void setMonthlyEstimate(String monthlyEstimate) {
        this.monthlyEstimate = monthlyEstimate;
    }

    public String getCreditWork() {
        return creditWork;
    }

    public void setCreditWork(String creditWork) {
        this.creditWork = creditWork;
    }

    public String getSemesterResult() {
        return semesterResult;
    }

    public void setSemesterResult(String semesterResult) {
        this.semesterResult = semesterResult;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "SemesterAssessment{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", student='" + student + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", monthlyEstimate='" + monthlyEstimate + '\'' +
                ", creditWork='" + creditWork + '\'' +
                ", semesterResult='" + semesterResult + '\'' +
                '}';
    }
}