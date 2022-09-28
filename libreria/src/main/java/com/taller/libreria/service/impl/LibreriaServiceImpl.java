package com.taller.libreria.service.impl;

import com.taller.libreria.dto.RegistrarLibroDTO;
import com.taller.libreria.entity.Autor;
import com.taller.libreria.entity.Libro;
import com.taller.libreria.mapper.LibroMapper;
import com.taller.libreria.repository.AutorRepository;
import com.taller.libreria.repository.LibreriaRepository;
import com.taller.libreria.service.LibreriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.Set;

import static com.taller.libreria.utils.Constantes.AUTHOR_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class LibreriaServiceImpl implements LibreriaService {

    @Autowired
    private LibroMapper libroMapper;
    @Autowired
    private LibreriaRepository libreriaRepository;
    @Autowired
    private AutorRepository autorRepository;

    @Override
    public Libro registrarLibro(RegistrarLibroDTO registrarLibroDTO) throws Exception {
        Libro libro = libroMapper.libroDTOToLibro(registrarLibroDTO);
        Autor autor = autorRepository.findById(registrarLibroDTO.getAutorId()).orElseThrow(() -> new Exception(AUTHOR_NOT_FOUND));
        libro.setAutor(autor);
        return libreriaRepository.save(libro);
    }

}
