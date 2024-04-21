package com.kreitek.school.application.service.impl;

import com.kreitek.school.application.dto.AlumnoDto;
import com.kreitek.school.application.dto.CalificacionDto;
import com.kreitek.school.application.mapper.CalificacionMapper;
import com.kreitek.school.application.service.AlumnoService;
import com.kreitek.school.application.service.CalificacionService;
import com.kreitek.school.domain.entity.Calificacion;
import com.kreitek.school.infrastructure.repository.CalificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class CalificacionServiceImpl implements CalificacionService {
    private final CalificacionRepository calificacionRepository;
    private final CalificacionMapper calificacionMapper;
    private final AlumnoService alumnoService;

    @Autowired
    public CalificacionServiceImpl(CalificacionRepository calificacionRepository, CalificacionMapper calificacionMapper, AlumnoService alumnoService) {
        this.calificacionRepository = calificacionRepository;
        this.calificacionMapper = calificacionMapper;
        this.alumnoService = alumnoService;
    }


    @Override
    @Transactional(readOnly = true)
    public List<CalificacionDto> obtenerCalificacionesDeUnAlumno(Long alumnoId) {
        List<Calificacion> calificaciones = calificacionRepository.findByAlumno_Id(alumnoId);
        return calificacionMapper.toDto(calificaciones);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CalificacionDto> obtenerCalificacionDeUnAlumno(Long alumnoId ,  Long calificacionId) {

        return calificacionRepository
                .findOneByIdAndAlumno_Id(alumnoId , calificacionId)
                .map(calificacionMapper::toDto);
    }

    @Override
    @Transactional
    public List<CalificacionDto> crearCalificacionDeAlumno(Long alumnoId, CalificacionDto calificacionDto) {
        calificacionDto.setAlumnoId(alumnoId);
        AlumnoDto alumnoDto = alumnoService.anadirCalificacion(alumnoId, calificacionDto);
        return alumnoDto.getCalificaciones();
    }
}
