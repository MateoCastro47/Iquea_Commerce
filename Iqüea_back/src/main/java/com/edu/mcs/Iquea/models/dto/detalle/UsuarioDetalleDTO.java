package com.edu.mcs.Iquea.models.dto.detalle;

import java.time.LocalDate;

import com.edu.mcs.Iquea.models.Vo.Email;

public class UsuarioDetalleDTO {
    private Long usuarioId;
    private String username;
    private Email email;
    private LocalDate fechaNacimiento;
    private String direccionEnvio;
    private Boolean activo;

    public UsuarioDetalleDTO() {
    }

    public UsuarioDetalleDTO(Long usuarioId, String username, Email email, LocalDate fechaNacimiento,
            String direccionEnvio, Boolean activo) {
        this.usuarioId = usuarioId;
        this.username = username;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.direccionEnvio = direccionEnvio;
        this.activo = activo;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
