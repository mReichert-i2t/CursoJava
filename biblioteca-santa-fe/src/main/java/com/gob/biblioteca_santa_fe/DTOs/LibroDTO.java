package com.gob.biblioteca_santa_fe.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.util.Date;

@Getter
@AllArgsConstructor
public class LibroDTO {
    private Long id;

    private String isbn;
    private String nombre;
    private String autor;
    private Integer cantidad;
    private Instant fechaCreacion;
    private Instant fechaModificacion;
}
