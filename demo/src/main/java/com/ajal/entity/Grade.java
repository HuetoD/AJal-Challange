package com.ajal.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_calificaciones")
public class Grade {

    @Id
    @Column(name = "id_t_calificaciones")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "t_materias")
    private SchoolSubject subject;

    @ManyToOne
    @JoinColumn(name = "t_alumnos")
    private Student student;

    @Column(name = "calificacion")
    private double note;

    @Column(name = "fecha_registro")
    private LocalDate register;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SchoolSubject getSubject() {
        return subject;
    }

    public void setSubject(SchoolSubject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
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
