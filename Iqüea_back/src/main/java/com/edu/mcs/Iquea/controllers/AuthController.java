package com.edu.mcs.Iquea.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.edu.mcs.Iquea.models.Usuario;
import com.edu.mcs.Iquea.models.dto.detalle.LoginDTO;
import com.edu.mcs.Iquea.models.dto.detalle.TokenDTO;
import com.edu.mcs.Iquea.models.dto.detalle.UsuarioDetalleDTO;
import com.edu.mcs.Iquea.repositories.UsuarioRepository;
import com.edu.mcs.Iquea.security.JwtUtil;
import com.edu.mcs.Iquea.services.IUsuarioService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final IUsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(IUsuarioService usuarioService, UsuarioRepository usuarioRepository,
                          JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // POST /api/auth/registro
    @PostMapping("/registro")
    public ResponseEntity<TokenDTO> registro(@RequestBody UsuarioDetalleDTO dto) {
        Usuario creado = usuarioService.crearUsuario(dto);
        String token = jwtUtil.generarToken(
                creado.getEmail().getValue(),
                creado.getRol().name()
        );
        return ResponseEntity.ok(new TokenDTO(token));
    }

    // POST /api/auth/login
    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO dto) {
        Usuario usuario = usuarioRepository.findByEmailValue(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(dto.getPassword(), usuario.getPassword())) {
            throw new IllegalArgumentException("Contraseña incorrecta");
        }

        String token = jwtUtil.generarToken(
                usuario.getEmail().getValue(),
                usuario.getRol().name()
        );
        return ResponseEntity.ok(new TokenDTO(token));
    }
}
