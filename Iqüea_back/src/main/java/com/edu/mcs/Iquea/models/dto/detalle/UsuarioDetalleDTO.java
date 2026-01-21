package com.edu.mcs.Iquea.models.dto.detalle;

import java.time.LocalDate;

import com.edu.mcs.Iquea.models.Vo.Email;

public class UsuarioDetalleDTO {
    private Long usuario_id;
    private String username;
    private Email email;
    private LocalDate fecha_nacimiento;
    private String direccion_envio;
    private Boolean activo;

    public UsuarioDetalleDTO() {
    }

    public UsuarioDetalleDTO(Long usuario_id, String username, Email email, LocalDate fecha_nacimiento,
            String direccion_envio, Boolean activo) {
        this.usuario_id = usuario_id;
        this.username = username;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion_envio = direccion_envio;
        this.activo = activo;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
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

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion_envio() {
        return direccion_envio;
    }

    public void setDireccion_envio(String direccion_envio) {
        this.direccion_envio = direccion_envio;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
