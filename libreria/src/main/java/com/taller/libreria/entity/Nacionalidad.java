package com.taller.libreria.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nacionalidad")
@Getter
@Setter
public class Nacionalidad {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String pais;
}
