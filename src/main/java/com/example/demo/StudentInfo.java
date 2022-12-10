package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class StudentInfo {
    private String fistLastMiddleName;

    public StudentInfo() {
    }

    private Map<String, String> fistLastMiddleNames;

    public String getFistLastMiddleName() {
        return fistLastMiddleName;
    }

    public void setFistLastMiddleName(String fistLastMiddleName) {
        this.fistLastMiddleName = fistLastMiddleName;
    }

    public Map<String, String> getFistLastMiddleNames() {
        return fistLastMiddleNames;
    }

    public void setFistLastMiddleNames(Map<String, String> fistLastMiddleNames) {
        this.fistLastMiddleNames = fistLastMiddleNames;
    }
}