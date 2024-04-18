package com.kreitek.school.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class AlumnoSimpleDto implements Serializable {
    private Long id;
    private String nombre;


    public AlumnoSimpleDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id , nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null ||getClass() != obj.getClass() ) return false;
        AlumnoSimpleDto other = (AlumnoSimpleDto) obj;
        return id == other.id && Objects.equals(nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "AlumnoSimpleDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
