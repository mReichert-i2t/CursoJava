package com.gob.biblioteca_santa_fe.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String nombre;
    private String apellido;

    @Column(name = "FECHA_NACIMIENTO")
    private LocalDate fechaNacimiento;

    @Column(name = "FECHA_CREACION")
    private LocalDate fechaCreacion;

    @Column(name = "FECHA_MODIFICACION")
    private LocalDate fechaModificacion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario", nullable = false)
    private Tipo_Usuario tipoUsuario;

//    @OneToMany(mappedBy = "usuario")
//    private List<Prestamo> prestamos;
}
