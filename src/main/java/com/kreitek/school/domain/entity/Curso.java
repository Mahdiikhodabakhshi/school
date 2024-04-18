package com.kreitek.school.domain.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "school_sequence")
    @SequenceGenerator(name = "school_sequence")
    private Long id;
    @Column(name = "NOMBRE" , nullable = false , length = 200)
    private String nombre;
    @Column(name = "RESUMEN" , nullable = false, length = 2000)
    private String resumen;

    @OneToMany(mappedBy = "curso" , cascade = CascadeType.ALL)
    Set<Leccion> lecciones;



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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Leccion> getLecciones() {
        return lecciones;
    }

    public void setLecciones(Set<Leccion> lecciones) {
        this.lecciones = lecciones;
        this.lecciones.forEach(leccion -> leccion.setCurso(this));
    }
}
