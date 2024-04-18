package com.kreitek.school.application.mapper;

import com.kreitek.school.application.dto.CursoDto;
import com.kreitek.school.domain.entity.Curso;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {LeccionMapper.class})
public interface CursoMapper extends EntityMapper<CursoDto, Curso> {

    default Curso fromId(Long id) {
        if (id == null) { return null; }
        Curso curso = new Curso();
        curso.setId(id);
        return curso;
    }
}
