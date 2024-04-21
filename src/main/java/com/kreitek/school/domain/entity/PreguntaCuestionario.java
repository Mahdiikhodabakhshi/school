package com.kreitek.school.domain.entity;

import com.kreitek.school.domain.entity.key.PreguntaCuestionarioKey;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cuestionarios_preguntas")
public class PreguntaCuestionario {

    @EmbeddedId
    private PreguntaCuestionarioKey id;

    @ManyToOne
    @MapsId("cuestionarioId")
    @JoinColumn(name = "cuestionario_id")
    private Cuestionario cuestionario;


    @ManyToOne
    @MapsId("preguntaId")
    @JoinColumn(name = "pregunta_id")
    private Pregunta pregunta;

    @Column(name = "orden")
    private Integer orden;

    public PreguntaCuestionarioKey getId() {
        return id;
    }

    public void setId(PreguntaCuestionarioKey id) {
        this.id = id;
    }

    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || id ==null) return false;
        PreguntaCuestionario that = (PreguntaCuestionario) o;
        return Objects.equals(id, that.id) && Objects.equals(cuestionario, that.cuestionario) && Objects.equals(pregunta, that.pregunta) && Objects.equals(orden, that.orden);
    }


}
