package com.kreitek.school.infrastructure.rest;


import com.kreitek.school.application.dto.AdjuntoDto;
import com.kreitek.school.application.dto.LeccionDto;
import com.kreitek.school.application.service.LeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos/{cursoId}")
public class LeccionController {

    private final LeccionService leccionService;

    @Autowired
    public LeccionController(LeccionService leccionService) {
        this.leccionService = leccionService;

    }

    @GetMapping(value = "/lecciones" , produces = "application/json")
    public ResponseEntity<List<LeccionDto>> listarLecciones(@PathVariable("cursoId") Long cursoId){
        List<LeccionDto> leccionDtos = leccionService.obtenerLeccionesDeUnCurso(cursoId);
        return ResponseEntity.ok(leccionDtos);
    }


    @GetMapping(value = "/lecciones/{leccionId}" , produces = "application/json")
    public ResponseEntity<LeccionDto> obtenerLeccion ( @PathVariable("cursoId") Long cursoId,@PathVariable("leccionId") Long leccionId){
        return leccionService
                .obtenerLeccionDeUnCurso(cursoId, leccionId)
                .map(ResponseEntity::ok)
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping(value = "/lecciones" , produces = "application/json" , consumes = "application/json")
    public ResponseEntity<LeccionDto> crearLeccionEnCurso(@PathVariable Long cursoId ,@RequestBody LeccionDto leccionDto){
       leccionDto=   leccionService.crearLeccion(cursoId, leccionDto);
       return new  ResponseEntity<>(leccionDto , HttpStatus.CREATED);
    }

    @PutMapping(value = "/lecciones/{leccionId}/adjuntos",produces = "application/json" , consumes = "application/json")
    public ResponseEntity<List<AdjuntoDto>> anadirAdjuntoEnLeccion(
                                                                @PathVariable Long cursoId,
                                                                @PathVariable Long leccionId,
                                                                @RequestBody AdjuntoDto adjuntoDto){
       List<AdjuntoDto> adjuntoDtoList =  leccionService.adjuntarFichero(cursoId,leccionId,adjuntoDto);
       return ResponseEntity.ok(adjuntoDtoList);
    }






}
