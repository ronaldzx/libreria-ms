package com.taller.libreria.repository;

import com.taller.libreria.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibreriaRepository extends JpaRepository<Libro, Integer> {

}
