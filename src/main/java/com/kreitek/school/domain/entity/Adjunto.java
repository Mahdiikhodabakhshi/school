package com.kreitek.school.domain.entity;

import jakarta.persistence.*;


import java.util.Objects;

@Entity
@Table(name = "adjuntos")
public class Adjunto {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "school_sequence")
    @SequenceGenerator(name = "school_sequence")
    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name = "nombre" , nullable = false )
    private String nombre;

    @Column(name = "mime_type", nullable = false , length = 200)
    private String mimeType;

    @Lob()
    @Column(name = "contenido")
    private byte[] contenido;


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
        if (o == null || getClass() != o.getClass() || id == null) return false;
        Adjunto adjunto = (Adjunto) o;
        return Objects.equals(id, adjunto.id);
    }


}
