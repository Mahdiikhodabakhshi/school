package com.kreitek.school.infrastructure.repository;

import com.kreitek.school.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
