package com.gob.biblioteca_santa_fe.services;

import com.gob.biblioteca_santa_fe.DTOs.LibroDTO;
import com.gob.biblioteca_santa_fe.exceptions.EntidadRepetidaException;
import com.gob.biblioteca_santa_fe.interfaces.LibroService;
import com.gob.biblioteca_santa_fe.model.Libro;
import com.gob.biblioteca_santa_fe.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void agregarLibro(LibroDTO libroDTO) {

        Optional<Libro> libroRep = libroRepository.findByIsbn(libroDTO.getIsbn());

        if(libroRep.isPresent()){
            throw new EntidadRepetidaException(
                    "Libro con ISBN " + libroDTO.getIsbn()+ " ya existe");
        }

        Libro libro = new Libro(
                libroDTO.getIsbn(),
                libroDTO.getNombre(),
                libroDTO.getAutor(),
                libroDTO.getCantidad()
        );

        libroRepository.save(libro);
    }
}
