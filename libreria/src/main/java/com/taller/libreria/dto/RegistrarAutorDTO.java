package com.taller.libreria.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class RegistrarAutorDTO {
    private String dni;
    private Date fechaNacimiento;
    private Integer nacionalidadId;
}
