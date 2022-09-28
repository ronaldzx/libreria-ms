package com.taller.libreria.service;

import com.taller.libreria.dto.RegistrarLibroDTO;
import com.taller.libreria.entity.Libro;

public interface LibreriaService {
    Libro registrarLibro(RegistrarLibroDTO registrarLibroDTO) throws Exception;
}
