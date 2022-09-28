package com.taller.libreria.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class AutorDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaNacimiento;
    private NacionalidadDTO nacionalidad;
}
