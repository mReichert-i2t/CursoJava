package com.gob.biblioteca_santa_fe.interfaces;

import com.gob.biblioteca_santa_fe.model.Libro;

import java.util.List;

public interface LibroService {

    public List<Libro> findAll();

    public Libro findByNombre(String nombre);

    public Libro findByAutor(String autor);

    public void agregarLibro(Libro libro);
}
