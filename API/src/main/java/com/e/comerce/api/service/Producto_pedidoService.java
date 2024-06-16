package com.e.comerce.api.service;

import com.e.comerce.api.model.Producto_pedido;
import com.e.comerce.api.repository.Producto_pedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Producto_pedidoService {

    @Autowired
    private Producto_pedidoRepository ppRepository;

    public Iterable<Producto_pedido> findAll() {
        return ppRepository.findAll();
    }

    public Producto_pedido save(Producto_pedido entity){
        return ppRepository.save(entity);
    }

    public void delete(Integer id){
        ppRepository.deleteById(id);
    }

    public Optional<Producto_pedido> findById(Integer id) {
        return ppRepository.findById(id);
    }
}
