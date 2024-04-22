package com.kreitek.school.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "school_sequence")
//    @SequenceGenerator(name = "school_sequence") por el usuario
    @Column(name = "id" , nullable = false)
    private Long id;

    @Column(name = "NOMBRE" , nullable = false)
    private String nombre;

    @Column(name = "NUMERO_TELEFONO" , length = 15)
    private String numeroTelefono;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Usuario usuario;

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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
