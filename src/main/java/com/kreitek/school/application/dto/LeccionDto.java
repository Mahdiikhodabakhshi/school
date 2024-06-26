package com.kreitek.school.application.dto;



import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class LeccionDto  implements Serializable {
    private Long id;

    private String titulo;

    private String contenido;

    private Integer orden;

    private Long cursoId;

    private String cursoNombre;

    private Long profesorId;
    private String profesorNombre;

    List<AdjuntoDto> adjuntos ;

    public LeccionDto() { //for mapper is empty
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public String getProfesorNombre() {
        return profesorNombre;
    }

    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
    }

    public List<AdjuntoDto> getAdjuntos() {
        return adjuntos;
    }

    public void setAdjuntos(List<AdjuntoDto> adjuntos) {
        this.adjuntos = adjuntos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, contenido, orden);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null ||getClass() != obj.getClass() ) return false;
        LeccionDto other = (LeccionDto) obj;
        return id.equals(other.id) &&
                titulo.equals(other.titulo) &&
                contenido.equals(other.contenido) &&
                orden.equals(other.orden);
    }

    @Override
    public String  toString() {
        return "LeccionDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", orden=" + orden +
                '}';
    }
}
