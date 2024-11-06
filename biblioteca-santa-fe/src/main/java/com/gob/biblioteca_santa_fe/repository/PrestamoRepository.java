package com.gob.biblioteca_santa_fe.repository;

import com.gob.biblioteca_santa_fe.enums.EstadoPrestamo;
import com.gob.biblioteca_santa_fe.model.Libro;
import com.gob.biblioteca_santa_fe.model.PrestamoId;
import com.gob.biblioteca_santa_fe.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gob.biblioteca_santa_fe.model.Prestamo;

import java.time.LocalDate;
import java.util.Optional;

public interface PrestamoRepository extends JpaRepository<Prestamo, PrestamoId> {

    Long countByLibroAndEstado(Libro libro, EstadoPrestamo estado);

    Optional<Prestamo> findByLibroAndFechaInicioAndUsuarioAndEstado(
            Libro libro,
            LocalDate fechaInicio,
            Usuario usuario,
            EstadoPrestamo estadoPrestamo);
}
