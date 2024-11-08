package com.gob.biblioteca_santa_fe.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class ResponseStoredDTO {

    private String isbn;
    private String nombreLibro;
    private String autor;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private String nombreUsuario;
    private String apellidoUsuario;
}
