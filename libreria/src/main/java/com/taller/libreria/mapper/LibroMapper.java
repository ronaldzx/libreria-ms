package com.taller.libreria.mapper;

import com.taller.libreria.dto.LibroDTO;
import com.taller.libreria.dto.RegistrarLibroDTO;
import com.taller.libreria.entity.Libro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibroMapper {
    Libro libroDTOToLibro(RegistrarLibroDTO registrarLibroDTO);

    LibroDTO libroToLibroDTO(Libro libro);

    default Libro afterlibroDTO(RegistrarLibroDTO registrarLibroDTO){

        return null;
    }

}
