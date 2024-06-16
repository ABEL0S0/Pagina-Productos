package com.e.comerce.api.repository;

import com.e.comerce.api.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    public <S extends Usuario> S save(S usuario);

    public <S extends Usuario> Iterable<S> saveAll(Iterable<S> iterable);

    public Optional<Usuario> findById(Integer id);

    public boolean existsById(Integer id);

    public Iterable<Usuario> findAll();

    public Iterable<Usuario> findAllById(Iterable<Integer> iterable);

    public long count();

    public void deleteById(Integer id);

    public void delete(Usuario u);

    public void deleteAll(Iterable<? extends Usuario> iterable);

    public void deleteAll();

}
