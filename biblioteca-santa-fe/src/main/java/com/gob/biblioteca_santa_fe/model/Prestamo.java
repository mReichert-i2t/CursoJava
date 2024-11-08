package com.gob.biblioteca_santa_fe.model;

import java.time.Instant;
import java.util.Date;

import com.gob.biblioteca_santa_fe.DTOs.ResponseStoredDTO;
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
@NamedStoredProcedureQuery(
        name="listarPrstamosPorEstadoPrestamo",
        procedureName = "listarPrestamosPorEstado",
        parameters = {
                @StoredProcedureParameter(
                        name = "estado",
                        type = String.class,
                        mode = ParameterMode.IN)
        },
        resultSetMappings ="getPrestamosPorEstadoPrestamo"
)
@SqlResultSetMapping(name= "getPrestamosPorEstadoPrestamo", classes = @ConstructorResult(
        targetClass = ResponseStoredDTO.class,
        columns = {
                @ColumnResult(name = "isbn", type = String.class),
                @ColumnResult(name = "nombre_libro", type = String.class),
                @ColumnResult(name = "autor", type = String.class),
                @ColumnResult(name = "fecha_inicio", type = LocalDate.class),
                @ColumnResult(name = "fecha_fin", type = LocalDate.class),
                @ColumnResult(name = "estado", type = String.class),
                @ColumnResult(name = "nombre_usuario", type = String.class),
                @ColumnResult(name = "apellido", type = String.class)
        }
))
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
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return Objects.equals(libro, prestamo.libro) && Objects.equals(usuario, prestamo.usuario) && Objects.equals(fechaInicio, prestamo.fechaInicio) && estado == prestamo.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(libro, usuario, fechaInicio, estado);
    }
}
