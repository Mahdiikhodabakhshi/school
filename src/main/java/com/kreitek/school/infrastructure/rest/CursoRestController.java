package com.kreitek.school.infrastructure.rest;

import com.kreitek.school.application.dto.CursoDto;
import com.kreitek.school.application.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CursoRestController {
    private final CursoService cursoService;


    public CursoRestController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping(value = "/cursos" , produces = "application/json")
    public ResponseEntity<List<CursoDto>> findAll() {
        List<CursoDto> cursoDtos = cursoService.obtenerCursos();
        return ResponseEntity.ok(cursoDtos);
    }

    @GetMapping(value = "/cursos/{cursoId}" , produces = "application/json")
    public ResponseEntity<CursoDto> findById(@PathVariable Long cursoId) {
        return cursoService
                .obtenerCursoPorId(cursoId)
                .map(curso -> new ResponseEntity<>(curso, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/cursos" , produces = "application/json" , consumes = "application/json")
    public ResponseEntity<CursoDto> create(@RequestBody CursoDto cursoDto) {
         cursoDto = cursoService.crearCurso(cursoDto);
         return new ResponseEntity<>(cursoDto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/cursos/{cursoId}")
    public ResponseEntity<Void> delete(@PathVariable Long cursoId) {
        cursoService.eliminarCurso(cursoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
