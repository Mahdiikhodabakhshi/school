package com.kreitek.school.infrastructure.rest;

import com.kreitek.school.application.dto.AdjuntoDto;
import com.kreitek.school.application.service.AdjuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdjuntoRestController {

    private final AdjuntoService adjuntoService;

    @Autowired
    public AdjuntoRestController(AdjuntoService adjuntoService) {
        this.adjuntoService = adjuntoService;
    }

    @GetMapping(value = "/adjuntos" , produces = "application/json")
    public ResponseEntity<List<AdjuntoDto>> findAll() {
        List<AdjuntoDto> adjuntoDtos = adjuntoService.obtenerAdjuntos();
        return ResponseEntity.ok(adjuntoDtos);
    }

    @GetMapping(value = "/adjuntos/{adjuntoId}" , produces = "application/json")
    public ResponseEntity<AdjuntoDto> findById(@PathVariable Long adjuntoId) {
        return adjuntoService
                .obtenerAdjuntoPorId(adjuntoId)
                .map(adjunto -> new ResponseEntity<>(adjunto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/adjuntos" , produces = "application/json" , consumes = "application/json")
    public ResponseEntity<AdjuntoDto> create(@RequestBody AdjuntoDto adjuntoDto) {
        adjuntoDto = adjuntoService.crearAdjunto(adjuntoDto);
        return new ResponseEntity<>(adjuntoDto, HttpStatus.CREATED);
    }


}
