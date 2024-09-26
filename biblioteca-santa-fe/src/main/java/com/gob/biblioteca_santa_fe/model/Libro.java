package com.gob.biblioteca_santa_fe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    private String nombre;
    private String autor;
    private Integer cantidad;
    private Integer prestados;
}
