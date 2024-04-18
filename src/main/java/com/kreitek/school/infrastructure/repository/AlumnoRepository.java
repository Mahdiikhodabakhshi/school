package com.kreitek.school.infrastructure.repository;

import com.kreitek.school.domain.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}
