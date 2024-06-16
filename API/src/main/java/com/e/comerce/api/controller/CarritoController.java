package com.e.comerce.api.controller;

import com.e.comerce.api.model.Carrito;
import com.e.comerce.api.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService service;

    @GetMapping(value = "/list", produces = "application/json")
    public Iterable<Carrito> findAll() {
        return service.findAll();
    }

    @PostMapping(value = "/save",produces = "application/json")
    public Carrito save(@RequestBody Carrito carrito) {
        return service.save(carrito);
    }

    @PutMapping(value = "/update/{id}",produces = "application/json")
    public Carrito update(@PathVariable Integer id, @RequestBody Carrito carrito) {
        return service.save(carrito);
    }

    @DeleteMapping(value = "/delete/{id}",produces = "application/json")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping(value = "/show/{id}", produces = "application/json")
    public Optional<Carrito> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
