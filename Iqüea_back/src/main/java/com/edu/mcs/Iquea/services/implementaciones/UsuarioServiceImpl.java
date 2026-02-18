package com.edu.mcs.Iquea.services.implementaciones;

import java.util.List;
import java.util.Optional;

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

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
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
        Usuario usuario = usuarioMapper.toEntity(dto);

        if (usuario.getEmail() != null) {
            boolean emailExistente = usuarioRepository.existsByEmail(dto.getEmail());

            if (emailExistente) {
                throw new IllegalArgumentException("Ya existe un usuario con ese email");
            }
        }

        if (usuario.getUsername() != null) {
            boolean usernameExistente = usuarioRepository.existsByUsername(dto.getUsername());

            if (usernameExistente) {
                throw new IllegalArgumentException("Ya existe un usuario con ese nombre de usuario");
            }
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

            usuarioMapper.updatefromEntity(dto, usuarioActualizado);

            return usuarioRepository.save(usuarioActualizado);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Datos del usuario no validos");
        }
    }

}
