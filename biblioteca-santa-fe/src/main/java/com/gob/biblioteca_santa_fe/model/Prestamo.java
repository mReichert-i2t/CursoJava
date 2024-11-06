package com.gob.biblioteca_santa_fe.model;

import java.time.Instant;
import java.util.Date;

import com.gob.biblioteca_santa_fe.enums.EstadoPrestamo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PrestamoId.class)
@Entity
@Table(name = "PRESTAMO")
public class Prestamo {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_libro", nullable = false)
    private Libro libro;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "FECHA_INICIO")
    private LocalDate fechaInicio;

    @Column(name = "FECHA_FIN")
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    private EstadoPrestamo estado;

    @Column(name = "FECHA_CREACION")
    private Instant fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    private Instant fechaModificacion;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prestamo prestamo)) return false;
        return Objects.equals(libro, prestamo.libro) && Objects.equals(usuario, prestamo.usuario) && Objects.equals(fechaInicio, prestamo.fechaInicio) && estado == prestamo.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(libro, usuario, fechaInicio, estado);
    }
}
