package com.kreitek.school.infrastructure.rest;

import com.kreitek.school.application.dto.LeccionDto;
import com.kreitek.school.application.dto.ProfesorDto;
import com.kreitek.school.application.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfesorRestController {
    private final ProfesorService profesorService;

    @Autowired
    public ProfesorRestController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }


    @GetMapping(value = "/profesores" , produces = "application/json")
    public ResponseEntity<List<ProfesorDto>> listarProfesores(){
        List<ProfesorDto> profesorDtos = profesorService.obtenerProfesores();
        return ResponseEntity.ok(profesorDtos);
    }


    @GetMapping(value = "/profesores/{profesorId}" , produces = "application/json")
    public ResponseEntity<ProfesorDto> obtenerProfesor (@PathVariable("profesorId") Long profesorId){
        return profesorService
                .obtenerProfesorPorId( profesorId)
                .map(ResponseEntity::ok)
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping(value = "/profesores" , produces = "application/json" , consumes = "application/json")
    public ResponseEntity<ProfesorDto> crearProfesor(@RequestBody ProfesorDto profesorDto){
        profesorDto=   profesorService.crearProfesor(profesorDto);
        return new  ResponseEntity<>(profesorDto , HttpStatus.CREATED);
    }


}
