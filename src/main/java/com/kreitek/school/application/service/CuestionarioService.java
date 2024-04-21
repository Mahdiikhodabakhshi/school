package com.kreitek.school.application.service;



import com.kreitek.school.application.dto.CuestionarioDto;
import com.kreitek.school.application.dto.PreguntaQuestionarioDto;

import java.util.List;
import java.util.Optional;

public interface CuestionarioService {
    List<CuestionarioDto> obtenerCuestionarios();
    Optional<CuestionarioDto> obtenerCuestionarioPorId(Long id);
    CuestionarioDto crearCuestionario(CuestionarioDto cuestionarioDto);

    List<PreguntaQuestionarioDto> anadePreguntaEnCuestionario(Long cuestionarioId, PreguntaQuestionarioDto preguntaQuestionarioDto);

    List<PreguntaQuestionarioDto> obtenerPreguntaDeCuestionario(Long cuestionarioId);
}
