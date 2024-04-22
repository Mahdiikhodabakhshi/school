package com.kreitek.school.application.service;

import com.kreitek.school.application.dto.UsuarioDto;
import com.kreitek.school.domain.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<UsuarioDto> obtenerUsuarios();
    Optional<UsuarioDto> obtenerUsuarioPorId(Long usuarioId);
    Usuario createUsuario(UsuarioDto usuarioDto);

}
