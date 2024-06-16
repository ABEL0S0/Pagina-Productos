package com.e.comerce.api.controller;

import com.e.comerce.api.model.Producto_pedido;
import com.e.comerce.api.service.Producto_pedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/p-p")
public class Producto_pedidoController {

    @Autowired
    private Producto_pedidoService service;

    @GetMapping(value = "/list", produces = "application/json")
    public Iterable<Producto_pedido> findAll() {
        return service.findAll();
    }

    @PostMapping(value = "/save",produces = "application/json")
    public Producto_pedido save(@RequestBody Producto_pedido pp) {
        return service.save(pp);
    }

    @PutMapping(value = "/update/{id}",produces = "application/json")
    public Producto_pedido update(@PathVariable Integer id, @RequestBody Producto_pedido pp) {
        return service.save(pp);
    }

    @DeleteMapping(value = "/delete/{id}",produces = "application/json")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping(value = "/show/{id}", produces = "application/json")
    public Optional<Producto_pedido> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
