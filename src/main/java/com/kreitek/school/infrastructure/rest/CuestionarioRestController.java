package com.kreitek.school.infrastructure.rest;


import com.kreitek.school.application.dto.CuestionarioDto;
import com.kreitek.school.application.dto.PreguntaQuestionarioDto;
import com.kreitek.school.application.service.CuestionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CuestionarioRestController {

    private final CuestionarioService cuestionarioService;



    public CuestionarioRestController(CuestionarioService cuestionarioService) {
        this.cuestionarioService = cuestionarioService;
    }

    @GetMapping(value = "/cuestionarios" , produces = "application/json")
    public ResponseEntity<List<CuestionarioDto>> findAll() {
        List<CuestionarioDto> cuestionarioDto = cuestionarioService.obtenerCuestionarios();
        return ResponseEntity.ok(cuestionarioDto);
    }

    @GetMapping(value = "/cuestionarios/{cuestionarioId}" , produces = "application/json")
    public ResponseEntity<CuestionarioDto> findById(@PathVariable Long cuestionarioId) {
        return cuestionarioService
                .obtenerCuestionarioPorId(cuestionarioId)
                .map(cuestionario -> new ResponseEntity<>(cuestionario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/cuestionarios" , produces = "application/json" , consumes = "application/json")
    public ResponseEntity<CuestionarioDto> create(@RequestBody CuestionarioDto cuestionarioDto) {
        cuestionarioDto = cuestionarioService.crearCuestionario(cuestionarioDto);
        return new ResponseEntity<>(cuestionarioDto , HttpStatus.CREATED);
    }

    @PutMapping(value = "/cuestionarios/{cuestionarioId}/preguntas" , produces = "application/json" , consumes = "application/json")
    public ResponseEntity<List<PreguntaQuestionarioDto>> anadePreguntaEnCuestionario(
            @PathVariable Long cuestionarioId ,
            @RequestBody PreguntaQuestionarioDto preguntaQuestionarioDto) {
        List<PreguntaQuestionarioDto> preguntaQuestionarioDtos = cuestionarioService.anadePreguntaEnCuestionario(cuestionarioId,preguntaQuestionarioDto);

        return new ResponseEntity<>(preguntaQuestionarioDtos , HttpStatus.CREATED);
    }

    @GetMapping(value = "/cuestionarios/{cuestionarioId}/preguntas" , produces = "application/json" )
    public ResponseEntity<List<PreguntaQuestionarioDto>> obtenerPreguntaDeCuestionario(@PathVariable Long cuestionarioId) {
        List<PreguntaQuestionarioDto> preguntaQuestionarioDtos = cuestionarioService.obtenerPreguntaDeCuestionario(cuestionarioId);

        return new ResponseEntity<>(preguntaQuestionarioDtos , HttpStatus.CREATED);
    }



}
