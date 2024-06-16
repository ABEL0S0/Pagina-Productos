package com.e.comerce.api.controller;

import com.e.comerce.api.model.Producto;
import com.e.comerce.api.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductController {

    @Autowired
    private ProductoService service;

    @GetMapping(value = "/list", produces = "application/json")
    public Iterable<Producto> findAll() {
        return service.findAll();
    }

    @PostMapping(value = "/save",produces = "application/json")
    public Producto save(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @PutMapping(value = "/update/{id}",produces = "application/json")
    public Producto update(@PathVariable Integer id, @RequestBody Producto producto) {
        return service.save(producto);
    }

    @DeleteMapping(value = "/delete/{id}",produces = "application/json")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping(value = "/show/{id}", produces = "application/json")
    public Optional<Producto> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
