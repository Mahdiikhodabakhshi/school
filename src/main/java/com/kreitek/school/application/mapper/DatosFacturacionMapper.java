package com.kreitek.school.application.mapper;

import com.kreitek.school.application.dto.DatosFacturacionDto;
import com.kreitek.school.domain.entity.DatosFacturacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {AlumnoMapper.class})
public interface DatosFacturacionMapper extends EntityMapper<DatosFacturacionDto, DatosFacturacion> {

    default DatosFacturacion fromId(Long id) {
        if (id == null) {return null;}
        DatosFacturacion entity = new DatosFacturacion();
        entity.setId(id);
        return entity;
    }
}
