package com.gob.biblioteca_santa_fe.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class ErrorResponseDTO implements Serializable {

    private String mensaje;
    private Instant timestamp;
}
