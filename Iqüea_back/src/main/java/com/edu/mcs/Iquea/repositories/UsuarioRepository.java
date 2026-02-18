package com.edu.mcs.Iquea.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.mcs.Iquea.models.Usuario;
import com.edu.mcs.Iquea.models.Vo.Email;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(Email email);

    boolean existsByUsername(String username);

    Optional<Usuario> findByUsername(String username);

}
