package com.e.comerce.api.repository;

import com.e.comerce.api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Producto, Integer> {
}
