package com.gob.biblioteca_santa_fe.interfaces;

import com.gob.biblioteca_santa_fe.DTOs.ResponseStoredDTO;

import java.util.List;

public interface PrestamoService {

    void realizarPrestamo(Long idLibro, Long idUsuario);

    List<ResponseStoredDTO> getPrestamoPorEstado(String estado);
}
