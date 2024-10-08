package com.gob.biblioteca_santa_fe.model;

import java.io.Serializable;

import jakarta.persistence.Entity;

public class PrestamoId implements Serializable{
    private Long libro;
    private Long usuario;
}
