package com.ajal.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class StudentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    @Size(max = 80, message = "El nombre del estudiante debe tener maximo 80 caracteres")
    private String name;

    @Size(max = 80, message = "El apellido paterno del estudiante debe tener maximo 80 caracteres")
    private String paternalSurname;

    @Size(max = 80, message = "El apellido materno del estudiante debe tener maximo 80 caracteres")
    private String maternalSurname;

    @PositiveOrZero(message = "El numero activo del estudiante debe ser positivo")
    @Max(value = 9, message = "El numero activo del estudiante solo debe tener un digito")
    private int active;

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
}
