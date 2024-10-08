package com.gob.biblioteca_santa_fe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;
    private String nombre;
    private String autor;
    private Integer cantidad;
    private Date fechaCreacion;
    private Date fechaModificacion;

    @OneToMany(mappedBy = "libro")
    private List<Prestamo> prestamos;
}
