package com.kreitek.school.application.mapper;

import com.kreitek.school.application.dto.PreguntaQuestionarioDto;
import com.kreitek.school.domain.entity.PreguntaCuestionario;
import com.kreitek.school.domain.entity.key.PreguntaCuestionarioKey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" , uses = {PreguntaMapper.class , CuestionarioMapper.class})
public interface PreguntaCuestionarioMapper extends EntityMapper<PreguntaQuestionarioDto, PreguntaCuestionario> {

    @Override
    @Mapping(source = "cuestionarioId" , target = "cuestionario")
    @Mapping(source = "preguntaId" , target = "pregunta")
    @Mapping(source = "preguntaId" , target = "id.preguntaId")
    PreguntaCuestionario toEntity(PreguntaQuestionarioDto dto);

    @Override
    @Mapping(source = "cuestionario.id" , target = "cuestionarioId")
    @Mapping(source = "cuestionario.titulo" , target = "cuestionarioTitulo")
    @Mapping(source = "pregunta.id" , target = "preguntaId")
    @Mapping(source = "pregunta.pregunta" , target = "preguntaPregunta")
    PreguntaQuestionarioDto toDto(PreguntaCuestionario entity);


    default PreguntaCuestionario fromId(PreguntaCuestionarioKey id) {
        if (id == null) {return null;}
        PreguntaCuestionario preguntaCuestionario = new PreguntaCuestionario();
        preguntaCuestionario.setId(id);
        return preguntaCuestionario;
    }
}
