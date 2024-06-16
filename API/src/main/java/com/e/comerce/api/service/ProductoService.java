package com.e.comerce.api.service;
import com.e.comerce.api.model.Producto;
import com.e.comerce.api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Iterable<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Producto save(Producto entity){
        return productoRepository.save(entity);
    }

    public void delete(Integer id){
        productoRepository.deleteById(id);
    }

    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }
}
