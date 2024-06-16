package com.e.comerce.api.service;

import com.e.comerce.api.model.Categoria;
import com.e.comerce.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Iterable<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria entity){
        return categoriaRepository.save(entity);
    }

    public void delete(Integer id){
        categoriaRepository.deleteById(id);
    }

    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }
}
