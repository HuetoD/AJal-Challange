package com.ajal.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_materias")
public class SchoolSubject {

    @Id
    @Column(name = "id_t_materias")
    private int id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "activo")
    private int active;

    @OneToMany(mappedBy = "subject")
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
