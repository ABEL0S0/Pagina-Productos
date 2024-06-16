package com.e.comerce.api.controller;

import com.e.comerce.api.model.Usuario;
import com.e.comerce.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/list",produces = "application/json")
    public Iterable<Usuario> findAll() {
        return service.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "/save",produces = "application/json")
    public Usuario save(@RequestBody Usuario usuario) {
        return service.save(usuario);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "/update/{id}",produces = "application/json")
    public Usuario update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        return service.save(usuario);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "/delete/{id}",produces = "application/json")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/show/{id}", produces = "application/json")
    public Optional<Usuario> findById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
