package com.ajal.dto.response;

import com.ajal.dto.GradeDTO;

import java.io.Serializable;
import java.util.List;

public class SchoolGradeInfoResponse implements Serializable {

    private List<GradeDTO> grades;

    private double average;

    public List<GradeDTO> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeDTO> grades) {
        this.grades = grades;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
}
