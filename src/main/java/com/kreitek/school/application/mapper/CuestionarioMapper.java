package com.kreitek.school.application.mapper;

import com.kreitek.school.application.dto.CuestionarioDto;
import com.kreitek.school.domain.entity.Cuestionario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = { PreguntaCuestionarioMapper.class })
public interface CuestionarioMapper extends EntityMapper<CuestionarioDto,Cuestionario> {

    default Cuestionario fromId(Long id){
        if(id == null) return null;
        Cuestionario cuestionario = new Cuestionario();
        cuestionario.setId(id);
        return cuestionario;
    }
}
