package com.taller.libreria.feign;

import com.taller.libreria.feign.config.FeignClientConfig;
import com.taller.libreria.feign.dto.ConsultaDNIDTO;
import com.taller.libreria.feign.dto.ReniecFeignDTO;
import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import static com.taller.libreria.utils.Constantes.AUTHORIZATION;

@FeignClient(name = "reniecFeignClient",
        configuration = FeignClientConfig.class,
        url = "https://www.softwarelion.xyz/api")
public interface ReniecFeignClient {
    @PostMapping("/reniec/reniec-dni")
    ReniecFeignDTO consultaDNI(@RequestHeader(AUTHORIZATION) String token, ConsultaDNIDTO consultaDNIDTO) throws FeignException;
}
