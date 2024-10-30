package com.gob.biblioteca_santa_fe.exceptions;

import com.gob.biblioteca_santa_fe.DTOs.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.time.LocalDate;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleException(Exception e, HttpServletRequest request) {

        log.error("Error no controlado en " + request.getRequestURL().toString() +
                "exception: " + e.getLocalizedMessage());

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                "Error del servidor, vuelva a intentarlo más tarde",
                Instant.now()
        );

        return ResponseEntity.status(500).body(errorResponseDTO);
    }

    @ExceptionHandler(EntidadRepetidaException.class)
    public ResponseEntity<ErrorResponseDTO> handleEntidadRepetidaException(EntidadRepetidaException e, HttpServletRequest request) {

        log.error("Error de entidad repetida en " + request.getRequestURL().toString() +
                "exception: " + e.getLocalizedMessage());

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                e.getLocalizedMessage(),
                Instant.now()
        );

        return ResponseEntity.unprocessableEntity().body(errorResponseDTO);
    }

}
