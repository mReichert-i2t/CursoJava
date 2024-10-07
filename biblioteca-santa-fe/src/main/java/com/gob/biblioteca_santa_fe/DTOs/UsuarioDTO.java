package com.gob.biblioteca_santa_fe.DTOs;

import java.util.Date;

public class UsuarioDTO {
    private Long id;
    private String username;
    private String email;
    private String password; // Consider encrypting this in production
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private Integer idTipoUsuario; // Puede ser un objeto TipoUsuarioDTO si necesitas más datos
    private Date fechaCreacion;
    private Date fechaModificacion;
}
