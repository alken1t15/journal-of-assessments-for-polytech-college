package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "teacher")
    private String teacher;
    @Column(name = "group_name")
    private String group_name;
    @Column(name = "username")
    private String username;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth")
    private String birth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "iin")
    private String iin;
    @Column(name = "certificates")
    private String certificates;
    @Column(name = "hobby")
    private String hobby;
    @Column(name = "social_status")
    private String social_status;
    @Column(name = "work_place")
    private String work_place;

    @Column(name = "name_img")
    private String name_img;

    public People() {
    }

    public People(String teacher, String group_name, String username, String firstName, String middleName, String lastName, String birth, String gender, int age, String nationality, String phone, String address, String iin, String certificates, String hobby, String social_status, String work_place, String name_img) {
        this.teacher = teacher;
        this.group_name = group_name;
        this.username = username;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birth = birth;
        this.gender = gender;
        this.age = age;
        this.nationality = nationality;
        this.phone = phone;
        this.address = address;
        this.iin = iin;
        this.certificates = certificates;
        this.hobby = hobby;
        this.social_status = social_status;
        this.work_place = work_place;
        this.name_img = name_img;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getCertificates() {
        return certificates;
    }

    public void setCertificates(String certificates) {
        this.certificates = certificates;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSocial_status() {
        return social_status;
    }

    public void setSocial_status(String social_status) {
        this.social_status = social_status;
    }

    public String getWork_place() {
        return work_place;
    }

    public void setWork_place(String work_place) {
        this.work_place = work_place;
    }

    public String getName_img() {
        return name_img;
    }

    public void setName_img(String name_img) {
        this.name_img = name_img;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", group_name='" + group_name + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth='" + birth + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", iin='" + iin + '\'' +
                ", certificates='" + certificates + '\'' +
                ", hobby='" + hobby + '\'' +
                ", social_status='" + social_status + '\'' +
                ", work_place='" + work_place + '\'' +
                ", name_img='" + name_img + '\'' +
                '}';
    }
}