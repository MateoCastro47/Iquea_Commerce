package com.edu.mcs.Iquea.services;

import java.util.List;
import java.util.Optional;

import com.edu.mcs.Iquea.models.Usuario;
import com.edu.mcs.Iquea.models.dto.detalle.UsuarioDetalleDTO;

public interface IUsuarioService {
    Usuario crearUsuario(UsuarioDetalleDTO dto);

    Optional<Usuario> obtenerUsuariosPorId(Long id);

    List<Usuario> obtenerTodosLosUsuarios();

    Usuario actualizarUsuario(String username, UsuarioDetalleDTO dto);

    void borrarUsuario(Long id);
}
