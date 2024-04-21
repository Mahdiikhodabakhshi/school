package com.kreitek.school.application.mapper;


import com.kreitek.school.application.dto.PreguntaDto;
import com.kreitek.school.domain.entity.Pregunta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {PreguntaCuestionarioMapper.class})
public interface PreguntaMapper extends EntityMapper<PreguntaDto, Pregunta>{

    default Pregunta fromId(Long id) {
        if (id == null) {return null;}
        Pregunta pregunta = new Pregunta();
        pregunta.setId(id);
        return pregunta;
    }
}
