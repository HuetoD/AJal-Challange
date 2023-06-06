package com.ajal.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_alumnos")
public class Student {

    @Id
    @Column(name = "id_t_usuarios")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "ap_paterno")
    private String paternalSurname;

    @Column(name = "ap_materno")
    private String maternalSurname;

    @Column(name = "activo")
    private int active;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Grade> grades;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaternalSurname() {
        return paternalSurname;
    }

    public void setPaternalSurname(String paternalSurname) {
        this.paternalSurname = paternalSurname;
    }

    public String getMaternalSurname() {
        return maternalSurname;
    }

    public void setMaternalSurname(String maternalSurname) {
        this.maternalSurname = maternalSurname;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
