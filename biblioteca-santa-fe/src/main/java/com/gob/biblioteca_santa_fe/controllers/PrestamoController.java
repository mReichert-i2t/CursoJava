package com.gob.biblioteca_santa_fe.controllers;

import com.gob.biblioteca_santa_fe.DTOs.PrestamoDTO;
import com.gob.biblioteca_santa_fe.DTOs.ResponseStoredDTO;
import com.gob.biblioteca_santa_fe.interfaces.PrestamoService;
import com.gob.biblioteca_santa_fe.model.Prestamo;
import com.gob.biblioteca_santa_fe.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/prestamo")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping()
    public ResponseEntity<List<ResponseStoredDTO>> getPrestamosPorEstado(@RequestParam String estado){

        return ResponseEntity.ok(prestamoService.getPrestamoPorEstado(estado));
    }
}
