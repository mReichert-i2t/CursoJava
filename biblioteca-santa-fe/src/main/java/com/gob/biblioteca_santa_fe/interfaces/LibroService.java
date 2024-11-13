package com.gob.biblioteca_santa_fe.interfaces;

import com.gob.biblioteca_santa_fe.DTOs.LibroDTO;
import com.gob.biblioteca_santa_fe.model.Libro;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LibroService {

    public List<Libro> findAll();

    public Page<Libro> findAll(int page, int size);

    public Libro findByNombre(String nombre);

    public List<Libro> findByAutor(String autor);

    public void agregarLibro(LibroDTO libro);

    public Libro findById(Long id);

    public List<LibroDTO> listarLibros();
}
