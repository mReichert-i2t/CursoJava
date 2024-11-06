package com.gob.biblioteca_santa_fe.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.Date;

@Getter
public class LibroDTO {
    private Long id;

    private String isbn;
    private String nombre;
    private String autor;
    private Integer cantidad;
    private Date fechaCreacion;
    private Date fechaModificacion;
}
