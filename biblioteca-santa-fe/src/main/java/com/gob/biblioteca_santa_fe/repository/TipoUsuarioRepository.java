package com.gob.biblioteca_santa_fe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gob.biblioteca_santa_fe.model.Tipo_Usuario;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<Tipo_Usuario, Long> {
}
