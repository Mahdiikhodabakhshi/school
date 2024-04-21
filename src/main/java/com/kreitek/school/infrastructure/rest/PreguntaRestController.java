package com.kreitek.school.infrastructure.rest;


import com.kreitek.school.application.dto.PreguntaDto;
import com.kreitek.school.application.service.PreguntaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PreguntaRestController {

    private final PreguntaService preguntaService;

    public PreguntaRestController(PreguntaService preguntaService) {
        this.preguntaService = preguntaService;

    }


    @GetMapping(value = "/preguntas" , produces = "application/json")
    public ResponseEntity<List<PreguntaDto>> findAll() {
        List<PreguntaDto> preguntaDto = preguntaService.obtenerpreguntas();
        return ResponseEntity.ok(preguntaDto);
    }

    @GetMapping(value = "/preguntas/{preguntaId}" , produces = "application/json")
    public ResponseEntity<PreguntaDto> findById(@PathVariable Long preguntaId) {
        return preguntaService
                .obtenerpreguntaPorId(preguntaId)
                .map(pregunta -> new ResponseEntity<>(pregunta, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/preguntas" , produces = "application/json" , consumes = "application/json")
    public ResponseEntity<PreguntaDto> create(@RequestBody PreguntaDto preguntaDto) {
        preguntaDto = preguntaService.crearpregunta(preguntaDto);
        return new ResponseEntity<>(preguntaDto , HttpStatus.CREATED);
    }
}
