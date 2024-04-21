package com.kreitek.school.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class PreguntaQuestionarioDto implements Serializable {

    private Long cuestionarioId;
    private String cuestionarioTitulo;
    private Long preguntaId;
    private String preguntaPregunta;
    private Long orden;

    public PreguntaQuestionarioDto() {
    }

    public Long getCuestionarioId() {
        return cuestionarioId;
    }

    public void setCuestionarioId(Long cuestionarioId) {
        this.cuestionarioId = cuestionarioId;
    }

    public String getCuestionarioTitulo() {
        return cuestionarioTitulo;
    }

    public void setCuestionarioTitulo(String cuestionarioTitulo) {
        this.cuestionarioTitulo = cuestionarioTitulo;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getPreguntaPregunta() {
        return preguntaPregunta;
    }

    public void setPreguntaPregunta(String preguntaPregunta) {
        this.preguntaPregunta = preguntaPregunta;
    }

    public Long getOrden() {
        return orden;
    }

    public void setOrden(Long orden) {
        this.orden = orden;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaQuestionarioDto that = (PreguntaQuestionarioDto) o;
        return Objects.equals(cuestionarioId, that.cuestionarioId) && Objects.equals(cuestionarioTitulo, that.cuestionarioTitulo) && Objects.equals(preguntaId, that.preguntaId) && Objects.equals(preguntaPregunta, that.preguntaPregunta) && Objects.equals(orden, that.orden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuestionarioId, cuestionarioTitulo, preguntaId, preguntaPregunta, orden);
    }

    @Override
    public String toString() {
        return "PreguntaQuestionarioDto{" +
                "cuestionarioId=" + cuestionarioId +
                ", cuestionarioTitulo='" + cuestionarioTitulo + '\'' +
                ", preguntaId=" + preguntaId +
                ", preguntaPregunta='" + preguntaPregunta + '\'' +
                ", orden=" + orden +
                '}';
    }
}
