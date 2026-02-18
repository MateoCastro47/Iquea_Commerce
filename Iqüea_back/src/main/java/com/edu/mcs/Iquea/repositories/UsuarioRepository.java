package com.edu.mcs.Iquea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.mcs.Iquea.models.Usuario;
import com.edu.mcs.Iquea.models.Vo.Email;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(Email email);

    boolean existsByUsername(String username);

    Optional<Usuario> findByUsername(String username);

    // Busca por el String interno del Value Object Email (usado en login)
    Optional<Usuario> findByEmailValue(String emailValue);

}
