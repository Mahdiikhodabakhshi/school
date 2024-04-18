package com.kreitek.school.application.mapper;

import com.kreitek.school.application.dto.LeccionDto;
import com.kreitek.school.domain.entity.Leccion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" , uses = {CursoMapper.class})
public interface LeccionMapper extends EntityMapper<LeccionDto,Leccion> {

    @Override
    @Mapping(source = "cursoId" , target = "curso")
    Leccion toEntity(LeccionDto dto);

    @Override
    @Mapping(source = "curso.id" , target = "cursoId")
    @Mapping(source = "curso.nombre" , target = "cursoNombre")
    LeccionDto toDto(Leccion entity);
}
