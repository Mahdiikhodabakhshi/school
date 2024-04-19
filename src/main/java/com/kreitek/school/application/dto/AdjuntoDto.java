package com.kreitek.school.application.dto;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class AdjuntoDto implements Serializable {

    private Long id;

    private String nombre;

    private String mimeType;


    private byte[] contenido;

    public AdjuntoDto() {
        //for mapper
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdjuntoDto that = (AdjuntoDto) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(mimeType, that.mimeType) && Objects.deepEquals(contenido, that.contenido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, mimeType, Arrays.hashCode(contenido));
    }
}
