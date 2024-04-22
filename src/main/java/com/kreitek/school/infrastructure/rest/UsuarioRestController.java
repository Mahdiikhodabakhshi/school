package com.kreitek.school.infrastructure.rest;

import com.kreitek.school.application.dto.UsuarioDto;
import com.kreitek.school.application.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioRestController {
    private final UsuarioService usuarioService;

    public UsuarioRestController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "/usuarios" , produces = "application/json")
    public ResponseEntity<List<UsuarioDto>> obtenerUsuarios() {
        var UsuariosDto = usuarioService.obtenerUsuarios();
        return ResponseEntity.ok(UsuariosDto);
    }

    @GetMapping(value = "/usuarios/{usuarioId}" , produces = "application/json")
    public ResponseEntity<UsuarioDto> obtenerUsuarios(@PathVariable Long usuarioId) {
        return usuarioService.obtenerUsuarioPorId(usuarioId)
                .map(usuarioDto -> new ResponseEntity<>(usuarioDto , HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));

    }
}
