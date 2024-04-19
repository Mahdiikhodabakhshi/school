package com.kreitek.school.application.service.impl;

import com.kreitek.school.application.dto.AdjuntoDto;
import com.kreitek.school.application.dto.LeccionDto;
import com.kreitek.school.application.mapper.LeccionMapper;
import com.kreitek.school.application.service.LeccionService;
import com.kreitek.school.domain.entity.Leccion;
import com.kreitek.school.infrastructure.repository.LeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LeccionServiceImpl implements LeccionService {


    private final LeccionRepository leccionRepository;
    private final LeccionMapper leccionMapper;

    @Autowired
    public LeccionServiceImpl(LeccionRepository leccionRepository, LeccionMapper leccionMapper) {
        this.leccionRepository = leccionRepository;
        this.leccionMapper = leccionMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<LeccionDto> obtenerLeccionesDeUnCurso(Long cursoId) {
        List<Leccion> lecciones = leccionRepository.findAllByCurso_Id(cursoId);
        return leccionMapper.toDto(lecciones);
    }

    @Override
    public LeccionDto crearLeccion(Long cursoId, LeccionDto leccionDto) {
        leccionDto.setCursoId(cursoId);
        Leccion leccion = leccionMapper.toEntity(leccionDto);
        leccion= leccionRepository.save(leccion);
        return leccionMapper.toDto(leccion);
    }

    @Override
    public Optional<LeccionDto> obtenerLeccionDeUnCurso(Long leccionId, Long cursoId) {
        return leccionRepository.findOneByIdAndCurso_Id(leccionId,cursoId)
                .map(leccionMapper::toDto);
    }

    @Override
    @Transactional
    public List<AdjuntoDto> adjuntarFichero(Long cursoId, Long leccionId, AdjuntoDto adjuntoDto) {
        LeccionDto leccionDto = obtenerLeccionDeUnCurso(leccionId, cursoId)
                .orElseThrow(()-> new RuntimeException("El leccion no existe"));
        leccionDto.getAdjuntos().add(adjuntoDto);
        Leccion leccion = leccionRepository.save(leccionMapper.toEntity(leccionDto));
        leccionDto = leccionMapper.toDto(leccion);
        return leccionDto.getAdjuntos();
    }
}
