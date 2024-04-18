package com.kreitek.school.infrastructure.rest;

import com.kreitek.school.application.dto.AlumnoDto;
import com.kreitek.school.application.dto.CursoSimpleDto;
import com.kreitek.school.application.service.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoRestController {

    private final AlumnoService alumnoService;

    public AlumnoRestController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping(value = "/alumnos" , produces = "application/json")
    public ResponseEntity<List<AlumnoDto>> findAll() {
        List<AlumnoDto> alumnoDtos = alumnoService.obtenerAlumnos();
        return ResponseEntity.ok(alumnoDtos);
    }

    @GetMapping(value = "/alumnos/{alumnoId}" , produces = "application/json")
    public ResponseEntity<AlumnoDto> findById(@PathVariable Long alumnoId) {
        return alumnoService
                .obtenerAlumnoPorId(alumnoId)
                .map(alumno -> new ResponseEntity<>(alumno, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/alumnos" , produces = "application/json" , consumes = "application/json")
    public ResponseEntity<AlumnoDto> create(@RequestBody AlumnoDto alumnoDto) {
        alumnoDto = alumnoService.crearAlumno(alumnoDto);
        return new ResponseEntity<>(alumnoDto, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/alumnos/{alumnoId}" , produces = "application/json")
    public ResponseEntity<Void> eliminarAlumnoPorId(@PathVariable Long alumnoId) {
        alumnoService.eliminarAlumnoPorId(alumnoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/alumnos/{alumnoId}/cursos" , produces = "application/json" , consumes = "application/json")
    public ResponseEntity<List<CursoSimpleDto>> registrarAlumnoEnCurso(@PathVariable Long alumnoId, @RequestBody CursoSimpleDto cursoSimpleDto) {
        List<CursoSimpleDto> cursoSimpleDtos = alumnoService.registrarAlumnoEnCurso(alumnoId, cursoSimpleDto);
        return new ResponseEntity<>(cursoSimpleDtos, HttpStatus.OK);
    }

    @DeleteMapping(value = "/alumnos/{alumnoId}/cursos/{cursoId}")
    public ResponseEntity<Void> eliminarCursoDeAlumno(@PathVariable Long alumnoId, @PathVariable Long cursoId) {
        alumnoService.eliminarCursoDeAlumno(alumnoId,cursoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
