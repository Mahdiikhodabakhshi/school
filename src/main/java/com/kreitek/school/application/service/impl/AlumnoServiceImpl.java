package com.kreitek.school.application.service.impl;

import com.kreitek.school.application.dto.AlumnoDto;
import com.kreitek.school.application.dto.CalificacionDto;
import com.kreitek.school.application.dto.CursoSimpleDto;
import com.kreitek.school.application.mapper.AlumnoMapper;
import com.kreitek.school.application.service.AlumnoService;
import com.kreitek.school.domain.entity.Alumno;
import com.kreitek.school.infrastructure.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;

    @Autowired
    public AlumnoServiceImpl(AlumnoRepository alumnoRepository, AlumnoMapper alumnoMapper) {
        this.alumnoRepository = alumnoRepository;
        this.alumnoMapper = alumnoMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<AlumnoDto> obtenerAlumnos() {
        var alumnos = alumnoRepository.findAll();
        return alumnoMapper.toDto(alumnos);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AlumnoDto> obtenerAlumnoPorId(Long id) {
        return alumnoRepository
                .findById(id).
                map(alumnoMapper::toDto);
    }

    @Override
    @Transactional
    public AlumnoDto crearAlumno(AlumnoDto alumnoDto) {
        var alumno = alumnoMapper.toEntity(alumnoDto);
        alumno = alumnoRepository.save(alumno);
        return alumnoMapper.toDto(alumno);
    }

    @Override
    public void eliminarAlumnoPorId(Long alumnoId) {
        alumnoRepository.deleteById(alumnoId);
    }

    @Override
    @Transactional
    public List<CursoSimpleDto> registrarAlumnoEnCurso(Long alumnoId, CursoSimpleDto cursoSimpleDtos) {
        AlumnoDto alumnoDto = obtenerAlumnoPorId(alumnoId).orElseThrow(()-> new RuntimeException("El alumno no existe"));
        alumnoDto.getCursos().add(cursoSimpleDtos);
        Alumno alumno = alumnoRepository.save(alumnoMapper.toEntity(alumnoDto));
        alumnoDto = alumnoMapper.toDto(alumno);
        return alumnoDto.getCursos();
    }

    @Override
    @Transactional
    public void eliminarCursoDeAlumno(Long alumnoId, Long cursoId) {
        Alumno alumno = alumnoRepository.findById(alumnoId).orElseThrow(()-> new RuntimeException("El alumno no existe"));
        //alumno.getCursos().remove(cursoId);
        alumno.eliminarCursoPorId(cursoId);
        alumnoRepository.save(alumno);
    }

    @Override
    public AlumnoDto anadirCalificacion(Long alumnoId, CalificacionDto calificacionDto) {
        AlumnoDto alumnoDto = obtenerAlumnoPorId(alumnoId)
                .orElseThrow(()-> new RuntimeException("El alumno no existe"));
        alumnoDto.getCalificaciones().add(calificacionDto);
        Alumno alumno = alumnoRepository.save(alumnoMapper.toEntity(alumnoDto));
        return alumnoMapper.toDto(alumno);
    }
}
