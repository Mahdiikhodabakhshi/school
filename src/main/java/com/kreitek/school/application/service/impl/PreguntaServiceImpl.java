package com.kreitek.school.application.service.impl;

import com.kreitek.school.application.dto.PreguntaDto;
import com.kreitek.school.application.mapper.PreguntaMapper;
import com.kreitek.school.application.service.PreguntaService;
import com.kreitek.school.infrastructure.repository.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaServiceImpl implements PreguntaService {


    private final PreguntaRepository preguntaRepository;
    private final PreguntaMapper preguntaMapper;

    @Autowired
    public PreguntaServiceImpl(PreguntaRepository preguntaRepository, PreguntaMapper preguntaMapper) {
        this.preguntaRepository = preguntaRepository;
        this.preguntaMapper = preguntaMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<PreguntaDto> obtenerpreguntas() {
        var preguntas = preguntaRepository.findAll();
        return preguntaMapper.toDto(preguntas);
    }

    @Override
    public Optional<PreguntaDto> obtenerpreguntaPorId(Long preguntaId) {
        return preguntaRepository
                .findById(preguntaId)
                .map(preguntaMapper::toDto);
    }

    @Override
    public PreguntaDto crearpregunta(PreguntaDto preguntaDto) {
        var pregunta = preguntaMapper.toEntity(preguntaDto);
        pregunta = preguntaRepository.save(pregunta);
        return preguntaMapper.toDto(pregunta);
    }
}
