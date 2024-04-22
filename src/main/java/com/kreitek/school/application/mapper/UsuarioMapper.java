package com.kreitek.school.application.mapper;

import com.kreitek.school.application.dto.UsuarioDto;
import com.kreitek.school.domain.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends EntityMapper<UsuarioDto, Usuario> {
}
