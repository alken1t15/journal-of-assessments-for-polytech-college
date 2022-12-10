package com.example.demo;

import java.util.Map;

public class AttestationAssessments {
    private String nameGroup;

    private String nameItem;

    private String semester;

    private Map<String, String> nameGroups;

    private Map<String, String> nameItems;

    public AttestationAssessments() {

    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Map<String, String> getNameGroups() {
        return nameGroups;
    }

    public void setNameGroups(Map<String, String> nameGroups) {
        this.nameGroups = nameGroups;
    }

    public Map<String, String> getNameItems() {
        return nameItems;
    }

    public void setNameItems(Map<String, String> nameItems) {
        this.nameItems = nameItems;
    }

    @Override
    public String toString() {
        return "AttestationAssessments{" +
                "nameGroup='" + nameGroup + '\'' +
                ", nameItem='" + nameItem + '\'' +
                ", semester='" + semester + '\'' +
                ", nameGroups=" + nameGroups +
                ", nameItems=" + nameItems +
                '}';
    }
}