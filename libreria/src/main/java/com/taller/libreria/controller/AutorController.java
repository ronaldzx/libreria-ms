package com.taller.libreria.controller;

import com.taller.libreria.dto.AutorDTO;
import com.taller.libreria.dto.LibroDTO;
import com.taller.libreria.dto.RegistrarAutorDTO;
import com.taller.libreria.dto.RegistrarLibroDTO;
import com.taller.libreria.mapper.AutorMapper;
import com.taller.libreria.service.AutorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@RestController
public class AutorController {
    @Autowired
    private AutorMapper autorMapper;
    @Autowired
    @Qualifier("autorService")
    private AutorService autorService;
    @ApiOperation(
            value = "Guardar Autor",
            nickname = "Guardar Autor",
            response = AutorDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")})
    @PostMapping(value = "/autor/")
    public ResponseEntity<AutorDTO> guardarAutor(@RequestBody RegistrarAutorDTO registrarAutorDTO) throws Exception {
        List<String> lista = new ArrayList<>();
        lista.add("a");
        lista.add("b");
        lista.add("c");
        lista.add("a");
        List<String> lista2 = lista.stream().sorted().collect(Collectors.toList());
        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        Consumer<LocalDateTime> a = t -> LocalDateTime.now();
        AutorDTO result = autorMapper.autorToAutorDTO(autorService.guardarAutor(registrarAutorDTO));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
