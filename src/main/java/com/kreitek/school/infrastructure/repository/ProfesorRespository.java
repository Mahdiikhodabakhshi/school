package com.kreitek.school.infrastructure.repository;

import com.kreitek.school.domain.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRespository extends JpaRepository<Profesor, Long> {
}
