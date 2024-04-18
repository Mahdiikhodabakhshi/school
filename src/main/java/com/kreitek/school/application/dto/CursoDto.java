package com.kreitek.school.application.dto;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CursoDto  implements Serializable {
    private Long id;
    private String nombre;
    private String resumen;

    List<LeccionDto> lecciones;


    public CursoDto() {
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

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public List<LeccionDto> getLecciones() {
        return lecciones;
    }

    public void setLecciones(List<LeccionDto> lecciones) {
        this.lecciones = lecciones;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, resumen);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CursoDto other = (CursoDto) obj;

        return Objects.equals(id, other.id) &&
                Objects.equals(nombre, other.nombre) &&
                Objects.equals(resumen, other.resumen);
    }

    @Override
    public String toString() {
        return "CursoDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", resumen='" + resumen + '\'' +
                '}';
    }
}
