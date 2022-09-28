package com.taller.libreria.service;

import com.taller.libreria.dto.RegistrarAutorDTO;
import com.taller.libreria.entity.Autor;

public interface AutorService {
    Autor guardarAutor(RegistrarAutorDTO registrarAutorDTO) throws Exception;
}
