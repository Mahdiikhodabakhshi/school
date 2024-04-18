package com.kreitek.school.application.service.impl;

import com.kreitek.school.application.dto.ProfesorDto;
import com.kreitek.school.application.mapper.ProfesorMapper;
import com.kreitek.school.application.service.ProfesorService;
import com.kreitek.school.infrastructure.repository.ProfesorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    private final ProfesorRespository profesorRespository;
    private final ProfesorMapper profesorMapper;

    @Autowired
    public ProfesorServiceImpl(ProfesorRespository profesorRespository, ProfesorMapper profesorMapper) {
        this.profesorRespository = profesorRespository;
        this.profesorMapper = profesorMapper;
    }


    @Override
    public List<ProfesorDto> obtenerProfesores() {
        var profesores = profesorRespository.findAll();
        return profesorMapper.toDto(profesores);
    }

    @Override
    public Optional<ProfesorDto> obtenerProfesorPorId(Long profesorId) {

        return profesorRespository.findById(profesorId)
                .map(profesorMapper::toDto);
    }

    @Override
    public ProfesorDto crearProfesor(ProfesorDto profesorDto) {
        var profesor = profesorMapper.toEntity(profesorDto);
        profesor = profesorRespository.save(profesor);
        return profesorMapper.toDto(profesor);
    }
}
