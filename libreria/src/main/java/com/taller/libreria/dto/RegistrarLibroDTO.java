package com.taller.libreria.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RegistrarLibroDTO {
    private String titulo;
    private Integer paginas;
    private Integer autorId;
    private Date fechaLanzamiento;
}
