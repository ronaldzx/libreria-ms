package com.taller.libreria.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "libro")
@Getter
@Setter
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "titulo")
    private String titulo;
    private Integer paginas;
    private Date fechaLanzamiento;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

}
