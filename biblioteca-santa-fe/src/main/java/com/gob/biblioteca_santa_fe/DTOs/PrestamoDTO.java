package com.gob.biblioteca_santa_fe.DTOs;

import org.springframework.cglib.core.Local;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class PrestamoDTO {
    private Long idLibro;
    private Long idUsuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private Instant fechaCreacion;
    private Instant fechaModificacion;
}
