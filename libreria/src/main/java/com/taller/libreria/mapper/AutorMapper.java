package com.taller.libreria.mapper;

import com.taller.libreria.dto.AutorDTO;
import com.taller.libreria.dto.LibroDTO;
import com.taller.libreria.dto.RegistrarAutorDTO;
import com.taller.libreria.entity.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AutorMapper {
    AutorDTO autorToAutorDTO(Autor autor);
    Autor autorDTOToAutor(RegistrarAutorDTO registrarAutorDTO);
}
