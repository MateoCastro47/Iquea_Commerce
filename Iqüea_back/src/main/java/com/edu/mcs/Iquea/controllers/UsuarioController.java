package com.edu.mcs.Iquea.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edu.mcs.Iquea.mappers.UsuarioMapper;
import com.edu.mcs.Iquea.models.Usuario;
import com.edu.mcs.Iquea.models.dto.detalle.UsuarioDetalleDTO;
import com.edu.mcs.Iquea.services.IUsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final IUsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(IUsuarioService usuarioService, UsuarioMapper usuarioMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDetalleDTO>> listarTodos() {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        return ResponseEntity.ok(usuarios.stream()
                .map(usuarioMapper::toDTO).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDetalleDTO> obtenerPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuariosPorId(id)
                .map(u -> ResponseEntity.ok(usuarioMapper.toDTO(u)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioDetalleDTO> crear(@RequestBody UsuarioDetalleDTO dto) {
        Usuario creado = usuarioService.crearUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioMapper.toDTO(creado));
    }

    @PutMapping("/{username}")
    public ResponseEntity<UsuarioDetalleDTO> actualizar(
            @PathVariable String username,
            @RequestBody UsuarioDetalleDTO dto) {
        Usuario actualizado = usuarioService.actualizarUsuario(username, dto);
        return ResponseEntity.ok(usuarioMapper.toDTO(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.borrarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
