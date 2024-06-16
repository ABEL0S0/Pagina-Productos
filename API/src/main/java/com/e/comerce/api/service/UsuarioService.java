package com.e.comerce.api.service;

import com.e.comerce.api.model.Usuario;
import com.e.comerce.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Iterable<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario entity){
        return usuarioRepository.save(entity);
    }

    public void delete(Integer id){
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }
}
