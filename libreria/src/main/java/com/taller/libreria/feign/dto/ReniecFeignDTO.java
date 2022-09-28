package com.taller.libreria.feign.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReniecFeignDTO {
    private Boolean success;
    private String message;
    private ResultReniecDTO result;
}
