package com.e.comerce.api.service;

import com.e.comerce.api.model.Carrito;
import com.e.comerce.api.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository categoriaRepository;

    public Iterable<Carrito> findAll() {
        return categoriaRepository.findAll();
    }

    public Carrito save(Carrito entity){
        return categoriaRepository.save(entity);
    }

    public void delete(Integer id){
        categoriaRepository.deleteById(id);
    }

    public Optional<Carrito> findById(Integer id) {
        return categoriaRepository.findById(id);
    }
}
