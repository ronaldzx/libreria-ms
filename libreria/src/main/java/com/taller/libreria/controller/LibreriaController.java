package com.taller.libreria.controller;

import com.taller.libreria.dto.LibroDTO;
import com.taller.libreria.dto.RegistrarLibroDTO;
import com.taller.libreria.mapper.LibroMapper;
import com.taller.libreria.service.LibreriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibreriaController {
    @Autowired
    private LibreriaService libreriaService;
    @Autowired
    private LibroMapper libroMapper;

    @ApiOperation(
            value = "Guardar Libro",
            nickname = "Guardar Libro",
            response = LibroDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")})
    @PostMapping(value = "/libro/")
    public ResponseEntity<LibroDTO> guardarLibro(@RequestBody RegistrarLibroDTO registrarLibroDTO) throws Exception {
        LibroDTO result = libroMapper.libroToLibroDTO(libreriaService.registrarLibro(registrarLibroDTO));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
