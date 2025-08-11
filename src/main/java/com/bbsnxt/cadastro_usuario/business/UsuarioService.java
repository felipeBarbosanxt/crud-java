package com.bbsnxt.cadastro_usuario.business;

import com.bbsnxt.cadastro_usuario.infrastructure.entitys.Usuario;
import com.bbsnxt.cadastro_usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(()
                -> new RuntimeException("Email não encontrado"));
    }

    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorEmail(String email, Usuario usuario){
        Usuario usuarioEntity = buscarUsuarioPorEmail(email);
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();
        repository.saveAndFlush(usuarioAtualizado);
    }
}
