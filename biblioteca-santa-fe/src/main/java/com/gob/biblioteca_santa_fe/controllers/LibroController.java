package com.gob.biblioteca_santa_fe.controllers;

import com.gob.biblioteca_santa_fe.interfaces.LibroService;
import com.gob.biblioteca_santa_fe.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libro")
public class LibroController {

    @Autowired
    LibroService libroService;

    @GetMapping()
    public ResponseEntity<List<Libro>> findAll(){
        List<Libro> libros = libroService.findAll();
        return  ResponseEntity.ok(libros);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Libro> findByNombre(@PathVariable String nombre){

        return ResponseEntity.ok(libroService.findByNombre(nombre));
    }

    @PostMapping()
    public ResponseEntity<String> crearLibro(@RequestBody Libro libro){

        return ResponseEntity.ok("El libro se creo con exito");
    }
}
