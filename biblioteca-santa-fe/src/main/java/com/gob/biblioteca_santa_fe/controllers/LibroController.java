package com.gob.biblioteca_santa_fe.controllers;

import com.gob.biblioteca_santa_fe.DTOs.LibroDTO;
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

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Libro> findByNombre(@PathVariable String nombre){

        return ResponseEntity.ok(libroService.findByNombre(nombre));
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<Libro>> findByAutor(@PathVariable String autor){

        return ResponseEntity.ok(libroService.findByAutor(autor));
    }

    @PostMapping()
    public ResponseEntity<String> crearLibro(@RequestBody LibroDTO libro){
        libroService.agregarLibro(libro);
        return ResponseEntity.ok("El libro se creo con exito");
    }

    @GetMapping("/listarLibros")
    public ResponseEntity<List<LibroDTO>> listarLibros(){
        return ResponseEntity.ok(libroService.listarLibros());
    }
}
