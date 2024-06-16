package com.e.comerce.api.controller;

import com.e.comerce.api.model.Categoria;
import com.e.comerce.api.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/list", produces = "application/json")
    public Iterable<Categoria> findAll() {
        return service.findAll();
    }

    @PostMapping(value = "/save",produces = "application/json")
    public Categoria save(@RequestBody Categoria categoria) {
        return service.save(categoria);
    }

    @PutMapping(value = "/update/{id}",produces = "application/json")
    public Categoria update(@PathVariable Integer id, @RequestBody Categoria categoria) {
        return service.save(categoria);
    }

    @DeleteMapping(value = "/delete/{id}",produces = "application/json")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping(value = "/show/{id}", produces = "application/json")
    public Optional<Categoria> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
