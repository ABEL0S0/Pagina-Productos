package com.e.comerce.api.controller;

import com.e.comerce.api.model.Producto;
import com.e.comerce.api.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/producto")
public class ImagenController {

    @Autowired
    private ImageRepository productoRepository;

    private static String subida_dir = "subir/";

    @PostMapping("/{id}/subirImg")
    public ResponseEntity<String> subirImagen(@PathVariable("id") Integer id, @RequestParam("image") MultipartFile image) {
        if (image == null) {
            return ResponseEntity.badRequest().body("No se ha proporcionado ninguna imagen");
        }

        try {
            Path subirPath = Paths.get(subida_dir);
            if (!Files.exists(subirPath)) {
                Files.createDirectories(subirPath);
            }

            String fileName = id + "_" + image.getOriginalFilename();
            Path filePath = subirPath.resolve(fileName);
            Files.copy(image.getInputStream(), filePath); // Usamos Files.move para mover el archivo correctamente

            Producto producto = productoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            producto.setImg(filePath.toString());
            productoRepository.save(producto);

            return ResponseEntity.ok().body("Imagen subida con éxito: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al subir la imagen");
        } catch (NullPointerException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("No se ha proporcionado ninguna imagen");
        }
    }
    @GetMapping("/{id}/imagen")
    public ResponseEntity<Resource> obtenerImagen(@PathVariable("id") Integer id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Path imagePath = Paths.get(producto.getImg());
        try {
            Resource resource = new UrlResource(imagePath.toUri());
            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

