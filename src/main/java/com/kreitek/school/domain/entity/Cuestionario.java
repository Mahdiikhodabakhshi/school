package com.kreitek.school.domain.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Cuestionarios")
public class Cuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "school_sequence")
    @SequenceGenerator(name = "school_sequence")
    @Column(name = "id" , nullable = false)
    private Long id;
    @Column(name = "Titulo" , nullable = false, length = 2000)
    private String titulo;
    @Column(name = "nota_minima" , nullable = false )
    private Integer notaMinima;

    @OneToMany(mappedBy = "cuestionario" , cascade = CascadeType.ALL)
    private Set<PreguntaCuestionario> preguntas;

    @OneToMany(mappedBy = "cuestionario")
    Set<Calificacion> calificaciones;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(Integer notaMinima) {
        this.notaMinima = notaMinima;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<PreguntaCuestionario> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<PreguntaCuestionario> preguntas) {
        this.preguntas = preguntas;
    }

    public Set<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Set<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
