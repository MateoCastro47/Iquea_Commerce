package com.edu.mcs.Iquea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.mcs.Iquea.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
