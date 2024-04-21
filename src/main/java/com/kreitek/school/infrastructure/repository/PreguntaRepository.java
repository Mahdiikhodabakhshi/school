package com.kreitek.school.infrastructure.repository;

import com.kreitek.school.domain.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
}
