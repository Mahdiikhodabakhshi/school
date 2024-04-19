package com.kreitek.school.application.mapper;

import com.kreitek.school.application.dto.AdjuntoDto;
import com.kreitek.school.domain.entity.Adjunto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdjuntoMapper extends EntityMapper<AdjuntoDto, Adjunto>{
}
