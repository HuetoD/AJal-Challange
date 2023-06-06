package com.ajal.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class GradeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    @Valid
    @NotNull(message = "Los datos de la materia no pueden ser nulos")
    private SchoolSubjectDTO subject;

    @Valid
    @NotNull(message = "Los datos del estudiante no pueden ser nulos")
    private StudentDTO student;

    private double note;

    private LocalDate register;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SchoolSubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SchoolSubjectDTO subject) {
        this.subject = subject;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public LocalDate getRegister() {
        return register;
    }

    public void setRegister(LocalDate register) {
        this.register = register;
    }
}
