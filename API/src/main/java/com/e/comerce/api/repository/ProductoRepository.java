package com.e.comerce.api.repository;
import com.e.comerce.api.model.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductoRepository extends CrudRepository<Producto, Integer>{
    public <S extends Producto> S save(S Producto);

    public <S extends Producto> Iterable<S> saveAll(Iterable<S> iterable);

    public Optional<Producto> findById(Integer id);

    public boolean existsById(Integer id);

    public Iterable<Producto> findAll();

    public Iterable<Producto> findAllById(Iterable<Integer> iterable);

    public long count();

    public void deleteById(Integer id);

    public void delete(Producto u);

    public void deleteAll(Iterable<? extends Producto> iterable);

    public void deleteAll();
}
