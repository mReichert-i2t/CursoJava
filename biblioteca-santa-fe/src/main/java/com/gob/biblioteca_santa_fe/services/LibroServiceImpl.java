package com.gob.biblioteca_santa_fe.services;

import com.gob.biblioteca_santa_fe.interfaces.LibroService;
import com.gob.biblioteca_santa_fe.model.Libro;
import com.gob.biblioteca_santa_fe.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    LibroRepository libroRepository;

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro findByNombre(String nombre) {
        return libroRepository.findByNombre(nombre)
        .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public List<Libro> findByAutor(String autor) {
        return libroRepository.findByAutor(autor);
    }

    @Override
    public void agregarLibro(Libro libro) {
        libroRepository.save(libro);
    }
}
