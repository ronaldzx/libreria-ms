package com.taller.libreria.service.impl;

import com.taller.libreria.dto.RegistrarAutorDTO;
import com.taller.libreria.entity.Autor;
import com.taller.libreria.feign.ReniecFeignClient;
import com.taller.libreria.feign.dto.ConsultaDNIDTO;
import com.taller.libreria.feign.dto.ReniecFeignDTO;
import com.taller.libreria.feign.dto.ResultReniecDTO;
import com.taller.libreria.mapper.AutorMapper;
import com.taller.libreria.repository.AutorRepository;
import com.taller.libreria.service.AutorService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.taller.libreria.utils.Constantes.TOKEN_BEARER;

@RequiredArgsConstructor
@Service("autorService")
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorMapper autorMapper;
    @Autowired
    private ReniecFeignClient reniecFeignClient;
    @Autowired
    private AutorRepository autorRepository;
    @Value("${reniec.token}")
    private String token;

    @Override
    public Autor guardarAutor(RegistrarAutorDTO registrarAutorDTO) throws Exception {
        ConsultaDNIDTO consultaDNIDTO = new ConsultaDNIDTO();
        consultaDNIDTO.setDni(registrarAutorDTO.getDni());
        ReniecFeignDTO reniecFeignDTO;

        try {
            reniecFeignDTO = reniecFeignClient.consultaDNI(TOKEN_BEARER + token, consultaDNIDTO);
        } catch (FeignException e) {
            throw new Exception(e);
        }
        if (!reniecFeignDTO.getSuccess()) {
            throw new Exception(reniecFeignDTO.getMessage());
        }

        Autor autor = autorMapper.autorDTOToAutor(registrarAutorDTO);
        autor.setNombre(reniecFeignDTO.getResult().getNombres());
        autor.setApellido(reniecFeignDTO.getResult().getPaterno() + " " + reniecFeignDTO.getResult().getMaterno());

        return autorRepository.save(autor);
    }
}
