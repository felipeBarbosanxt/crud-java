package com.bbsnxt.cadastro_usuario.infrastructure.repository;

import com.bbsnxt.cadastro_usuario.infrastructure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
