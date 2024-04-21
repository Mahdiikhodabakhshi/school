package com.kreitek.school.application.service.impl;

import com.kreitek.school.application.dto.CuestionarioDto;
import com.kreitek.school.application.dto.PreguntaQuestionarioDto;
import com.kreitek.school.application.mapper.CuestionarioMapper;
import com.kreitek.school.application.service.CuestionarioService;
import com.kreitek.school.domain.entity.Cuestionario;
import com.kreitek.school.infrastructure.repository.CuestionarioRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CuestionarioServiceImpl implements CuestionarioService {


    private final CuestionarioRepositoy cuestionarioRepositoy;
    private final CuestionarioMapper cuestionarioMapper;

    @Autowired
    public CuestionarioServiceImpl(CuestionarioRepositoy cuestionarioRepositoy, CuestionarioMapper cuestionarioMapper) {
        this.cuestionarioRepositoy = cuestionarioRepositoy;
        this.cuestionarioMapper = cuestionarioMapper;
    }


    @Override
    @Transactional(readOnly = true)
    public List<CuestionarioDto> obtenerCuestionarios() {
        var cuestionarios = cuestionarioRepositoy.findAll();
        return cuestionarioMapper.toDto(cuestionarios);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CuestionarioDto> obtenerCuestionarioPorId(Long id) {

        return cuestionarioRepositoy
                .findById(id)
                .map(cuestionarioMapper::toDto);
    }

    @Override
    @Transactional
    public CuestionarioDto crearCuestionario(CuestionarioDto cuestionarioDto) {
        var cuestionario = cuestionarioMapper.toEntity(cuestionarioDto);
        cuestionario = cuestionarioRepositoy.save(cuestionario);
        return cuestionarioMapper.toDto(cuestionario);
    }

    @Override
    @Transactional
    public List<PreguntaQuestionarioDto> anadePreguntaEnCuestionario(Long cuestionarioId, PreguntaQuestionarioDto preguntaQuestionarioDto) {


        CuestionarioDto cuestionarioDto = obtenerCuestionarioPorId(cuestionarioId)
                .orElseThrow(()-> new RuntimeException("Cuestionario no encontrado"));

        preguntaQuestionarioDto.setCuestionarioId(cuestionarioId);

        cuestionarioDto.getPreguntas().add(preguntaQuestionarioDto);

        Cuestionario cuestionario = cuestionarioRepositoy.save(cuestionarioMapper.toEntity(cuestionarioDto));

        cuestionarioDto = cuestionarioMapper.toDto(cuestionario);
        return cuestionarioDto.getPreguntas();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PreguntaQuestionarioDto> obtenerPreguntaDeCuestionario(Long cuestionarioId) {
        CuestionarioDto cuestionarioDto= obtenerCuestionarioPorId(cuestionarioId)
                .orElseThrow(()-> new RuntimeException("Cuestionario no encontrado"));


        return cuestionarioDto.getPreguntas();
    }
}
