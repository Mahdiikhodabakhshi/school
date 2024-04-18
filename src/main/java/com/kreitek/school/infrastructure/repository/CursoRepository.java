package com.kreitek.school.infrastructure.repository;

import com.kreitek.school.domain.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
