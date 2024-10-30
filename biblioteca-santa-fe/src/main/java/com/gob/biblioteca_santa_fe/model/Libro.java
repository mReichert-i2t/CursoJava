package com.gob.biblioteca_santa_fe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LIBRO")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;

    private String nombre;

    private String autor;

    private Integer cantidad;

    @Column(name = "FECHA_CREACION")
    private Instant fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    private Instant fechaModificacion;

//    @OneToMany(mappedBy = "libro")
//    private List<Prestamo> prestamos;

    public Libro(String isbn, String nombre, String autor, Integer cantidad) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.cantidad = cantidad;
        this.fechaCreacion = Instant.now();
    }
}
