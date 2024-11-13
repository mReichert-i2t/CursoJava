package com.gob.biblioteca_santa_fe.services;

import com.gob.biblioteca_santa_fe.DTOs.LibroDTO;
import com.gob.biblioteca_santa_fe.exceptions.EntidadNoEncontradaExcpetion;
import com.gob.biblioteca_santa_fe.exceptions.EntidadRepetidaException;
import com.gob.biblioteca_santa_fe.interfaces.LibroService;
import com.gob.biblioteca_santa_fe.model.Libro;
import com.gob.biblioteca_santa_fe.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Page<Libro> findAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());

        return libroRepository.findAll(pageable);
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

    @Override
    public Libro findById(Long id) {

        return libroRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaExcpetion("El libro con id " + id + " no existe"));
    }

    @Override
    @Transactional
    public List<LibroDTO> listarLibros() {

        List<Libro> libros = libroRepository.listarLibros();

        List<LibroDTO> result = new ArrayList<>();

        result = libros.stream().
            map( libro -> new LibroDTO(
                       libro.getId(),libro.getIsbn(), libro.getNombre(), libro.getAutor(), libro.getCantidad(), libro.getFechaCreacion(), libro.getFechaModificacion()))
               .toList();

        return result;
    }
}
