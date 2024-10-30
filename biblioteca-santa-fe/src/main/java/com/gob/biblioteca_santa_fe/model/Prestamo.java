package com.gob.biblioteca_santa_fe.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;


@Data
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
    
    private String estado;

    @Column(name = "FECHA_CREACION")
    private LocalDate fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    private LocalDate fechaModificacion;
}
