package com.kreitek.school.domain.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PreguntaCuestionarioKey implements Serializable {

    //private static final long serialVersionUID = -1822620556182692474L;

    @Column(name = "cuestionario_id")
    private Long cuestionarioId;

    @Column(name = "pregunta_id")
    private Long preguntaId;

    public PreguntaCuestionarioKey() {
    }

    public Long getCuestionarioId() {
        return cuestionarioId;
    }

    public void setCuestionarioId(Long cuestionarioId) {
        this.cuestionarioId = cuestionarioId;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaCuestionarioKey that = (PreguntaCuestionarioKey) o;
        return Objects.equals(cuestionarioId, that.cuestionarioId) && Objects.equals(preguntaId, that.preguntaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuestionarioId, preguntaId);
    }
}
