package com.kreitek.school.infrastructure.repository;

import com.kreitek.school.domain.entity.Leccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LeccionRepository extends JpaRepository<Leccion, Long> {
    List<Leccion> findAllByCurso_Id(Long cursoId);

    Optional<Leccion> findOneByIdAndCurso_Id(Long leccionId, Long cursoid);
}
