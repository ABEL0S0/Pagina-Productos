package com.e.comerce.api.service;

import com.e.comerce.api.model.Producto_carrito;
import com.e.comerce.api.repository.Producto_carritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Producto_carritoService {

    @Autowired
    private Producto_carritoRepository pcRepository;

    public Iterable<Producto_carrito> findAll() {
        return pcRepository.findAll();
    }

    public Producto_carrito save(Producto_carrito entity){
        return pcRepository.save(entity);
    }

    public void delete(Integer id){
        pcRepository.deleteById(id);
    }

    public Optional<Producto_carrito> findById(Integer id) {
        return pcRepository.findById(id);
    }
}
