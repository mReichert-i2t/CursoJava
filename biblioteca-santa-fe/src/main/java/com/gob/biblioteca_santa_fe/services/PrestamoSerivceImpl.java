package com.gob.biblioteca_santa_fe.services;

import com.gob.biblioteca_santa_fe.DTOs.ResponseStoredDTO;
import com.gob.biblioteca_santa_fe.enums.EstadoPrestamo;
import com.gob.biblioteca_santa_fe.exceptions.EntidadRepetidaException;
import com.gob.biblioteca_santa_fe.exceptions.NoHayLibrosException;
import com.gob.biblioteca_santa_fe.interfaces.LibroService;
import com.gob.biblioteca_santa_fe.interfaces.PrestamoService;
import com.gob.biblioteca_santa_fe.interfaces.UsuarioService;
import com.gob.biblioteca_santa_fe.model.Libro;
import com.gob.biblioteca_santa_fe.model.Prestamo;
import com.gob.biblioteca_santa_fe.model.Usuario;
import com.gob.biblioteca_santa_fe.repository.PrestamoDao;
import com.gob.biblioteca_santa_fe.repository.PrestamoRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoSerivceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final LibroService libroService;
    private final UsuarioService usuarioService;
    private final PrestamoDao prestamoDao;

    public PrestamoSerivceImpl(PrestamoRepository prestamoRepository, LibroService libroService,
                               UsuarioService usuarioService, PrestamoDao prestamoDao) {
        this.prestamoRepository = prestamoRepository;
        this.libroService = libroService;
        this.usuarioService = usuarioService;
        this.prestamoDao = prestamoDao;
    }

    @Override
    public void realizarPrestamo(Long idLibro, Long idUsuario) {

        Usuario usuario = usuarioService.findById(idUsuario);

        Libro libro = libroService.findById(idLibro);

        Long cantPrestamos = prestamoRepository.countByLibroAndEstado(libro, EstadoPrestamo.PRESTADO);

        if(cantPrestamos.equals(Long.valueOf(libro.getCantidad()))){

            throw new NoHayLibrosException("No hay libros disponibles para el préstamo");
        }

        Optional<Prestamo> prestamoRep = prestamoRepository.findByLibroAndFechaInicioAndUsuarioAndEstado(
                libro,
                LocalDate.now(),
                usuario,
                EstadoPrestamo.PRESTADO
        );

        if(prestamoRep.isPresent()){
            throw new EntidadRepetidaException("El prestamo ya existe para el libro "+ libro.getNombre()+
                    "usuario "+usuario.getNombre() + "en la fecha "+ LocalDate.now());
        }

        Prestamo prestamo = new Prestamo(
                libro,
                usuarioService.findById(idUsuario),
                LocalDate.now(), // Fecha de préstamo
                LocalDate.now().plusDays(14), // Prestamo por 14 días
                EstadoPrestamo.PRESTADO,
                Instant.now(), // Fecha de creación
                null
        );

        prestamoRepository.save(prestamo);
    }

    @Override
    public List<ResponseStoredDTO> getPrestamoPorEstado(String estado) {

        return prestamoDao.getPrestamosPorEstado(estado);
    }
}
