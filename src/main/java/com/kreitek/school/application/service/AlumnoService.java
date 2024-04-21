package com.kreitek.school.application.service;

import com.kreitek.school.application.dto.AlumnoDto;
import com.kreitek.school.application.dto.CalificacionDto;
import com.kreitek.school.application.dto.CursoSimpleDto;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    List<AlumnoDto> obtenerAlumnos();
    Optional<AlumnoDto> obtenerAlumnoPorId(Long id);
    AlumnoDto crearAlumno(AlumnoDto alumnoDto);

    void eliminarAlumnoPorId(Long alumnoId);

    List<CursoSimpleDto> registrarAlumnoEnCurso(Long alumnoId, CursoSimpleDto cursoSimpleDtos);

    void eliminarCursoDeAlumno(Long alumnoId, Long cursoId);

    AlumnoDto anadirCalificacion(Long alumnoId, CalificacionDto calificacionDto);
}
