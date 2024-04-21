package com.kreitek.school.application.service;



import com.kreitek.school.application.dto.PreguntaDto;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {
    List<PreguntaDto> obtenerpreguntas();
    Optional<PreguntaDto> obtenerpreguntaPorId(Long preguntaId);
    PreguntaDto crearpregunta(PreguntaDto preguntaDto);
}
