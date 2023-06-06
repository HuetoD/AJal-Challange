package com.ajal.dto;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class SchoolSubjectDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    @Size(max = 80, message = "El nombre de la materia debe tener maximo 80 caracteres")
    private String name;

    @PositiveOrZero(message = "El numero activo de la materia debe ser positivo")
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
