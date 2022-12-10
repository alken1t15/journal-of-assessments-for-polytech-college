package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class Schedule {
    private String month;

    private String nameGroup;

    private String nameItem;

    private String status;

    private Map<String, String> nameGroups;

    private Map<String, String> nameItems;

    public Schedule() {
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}