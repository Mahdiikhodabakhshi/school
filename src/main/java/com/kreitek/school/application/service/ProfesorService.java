package com.kreitek.school.application.service;

import com.kreitek.school.application.dto.ProfesorDto;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {
    List<ProfesorDto> obtenerProfesores();
    Optional<ProfesorDto> obtenerProfesorPorId(Long profesorId);
    ProfesorDto crearProfesor(ProfesorDto profesor);
}
