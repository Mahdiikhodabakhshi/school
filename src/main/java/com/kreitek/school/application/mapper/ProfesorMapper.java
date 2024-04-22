package com.kreitek.school.application.mapper;

import com.kreitek.school.application.dto.ProfesorDto;
import com.kreitek.school.domain.entity.Profesor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {UsuarioMapper.class})
public interface ProfesorMapper extends EntityMapper<ProfesorDto , Profesor> {


    default Profesor fromId(Long id) {
        if (id == null) { return null; }
        Profesor profesor = new Profesor();
        profesor.setId(id);
        return profesor;
    }
}
