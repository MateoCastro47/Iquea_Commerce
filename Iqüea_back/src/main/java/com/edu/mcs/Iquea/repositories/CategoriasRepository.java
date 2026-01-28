package com.edu.mcs.Iquea.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.mcs.Iquea.models.Categorias;



public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
    
    boolean existsByNombre(String nombre);

    void deleteByNombre(String nombre);
    
    Optional<Categorias> findByNombre(String nombre);
}
