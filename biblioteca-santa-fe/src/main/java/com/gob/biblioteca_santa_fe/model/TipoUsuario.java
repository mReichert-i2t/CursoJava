package com.gob.biblioteca_santa_fe.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;
    private Date fechaCreacion;
    private Date fechaModificacion;

    @OneToMany(mappedBy = "tipoUsuario")
    private List<Usuario> usuarios;
}
