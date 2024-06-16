package com.e.comerce.api.controller;

import com.e.comerce.api.model.Producto_carrito;
import com.e.comerce.api.service.Producto_carritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/p-c")
public class Producto_carritoController {

    @Autowired
    private Producto_carritoService service;

    @GetMapping(value = "/list", produces = "application/json")
    public Iterable<Producto_carrito> findAll() {
        return service.findAll();
    }

    @PostMapping(value = "/save",produces = "application/json")
    public Producto_carrito save(@RequestBody Producto_carrito pc) {
        return service.save(pc);
    }

    @PutMapping(value = "/update/{id}",produces = "application/json")
    public Producto_carrito update(@PathVariable Integer id, @RequestBody Producto_carrito pc) {
        return service.save(pc);
    }

    @DeleteMapping(value = "/delete/{id}",produces = "application/json")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping(value = "/show/{id}", produces = "application/json")
    public Optional<Producto_carrito> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
