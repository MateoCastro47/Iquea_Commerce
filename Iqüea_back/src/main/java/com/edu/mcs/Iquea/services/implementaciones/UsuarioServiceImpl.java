package com.edu.mcs.Iquea.services.implementaciones;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.mcs.Iquea.mappers.UsuarioMapper;
import com.edu.mcs.Iquea.models.Usuario;
import com.edu.mcs.Iquea.models.dto.detalle.UsuarioDetalleDTO;
import com.edu.mcs.Iquea.repositories.UsuarioRepository;
import com.edu.mcs.Iquea.services.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper,
            PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void borrarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("El usuario con ID " + id + " no existe.");
        }
    }

    @Override
    @Transactional
    public Usuario crearUsuario(UsuarioDetalleDTO dto) {
        // Validar mayoría de edad (requerido por el enunciado)
        if (dto.getFecha_nacimiento() == null) {
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria");
        }
        if (dto.getFecha_nacimiento().isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("Debes ser mayor de 18 años para registrarte");
        }

        // Validar email único
        if (dto.getEmail() != null) {
            boolean emailExistente = usuarioRepository.existsByEmail(dto.getEmail());
            if (emailExistente) {
                throw new IllegalArgumentException("Ya existe un usuario con ese email");
            }
        }

        // Validar username único
        if (dto.getUsername() != null) {
            boolean usernameExistente = usuarioRepository.existsByUsername(dto.getUsername());
            if (usernameExistente) {
                throw new IllegalArgumentException("Ya existe un usuario con ese nombre de usuario");
            }
        }

        Usuario usuario = usuarioMapper.toEntity(dto);

        // Encriptar contraseña con BCrypt
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> obtenerUsuariosPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuario actualizarUsuario(String username, UsuarioDetalleDTO dto) {
        try {
            Usuario usuarioActualizado = usuarioRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con nombre " + username));

            usuarioMapper.updateUsuarioFromDTO(dto, usuarioActualizado);

            // Si se envía nueva contraseña, encriptarla
            if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
                usuarioActualizado.setPassword(passwordEncoder.encode(dto.getPassword()));
            }

            return usuarioRepository.save(usuarioActualizado);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Datos del usuario no validos");
        }
    }

}
