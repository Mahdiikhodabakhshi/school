package com.kreitek.school.application.dto;



import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CuestionarioDto implements Serializable {
    private Long id;
    private String titulo;
    private Integer notaMinima;
    private List<PreguntaQuestionarioDto> preguntas;

    public CuestionarioDto() { //for mapper
    }

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

    public List<PreguntaQuestionarioDto> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<PreguntaQuestionarioDto> preguntas) {
        this.preguntas = preguntas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuestionarioDto that = (CuestionarioDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(notaMinima, that.notaMinima) &&
                Objects.equals(preguntas, that.preguntas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, notaMinima, preguntas);
    }

    @Override
    public String toString() {
        return "CuestionarioDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", notaMinima=" + notaMinima +
                ", preguntas=" + preguntas +
                '}';
    }
}
