package com.taller.libreria.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LibroDTO {
    private Integer id;
    private String titulo;
    private Integer paginas;
    private Date fechaLanzamiento;
    private AutorDTO autor;
}
