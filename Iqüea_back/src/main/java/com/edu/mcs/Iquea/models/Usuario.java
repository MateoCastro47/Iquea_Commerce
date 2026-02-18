package com.edu.mcs.Iquea.models;

import java.time.LocalDate;

import com.edu.mcs.Iquea.models.Vo.Email;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuario_id;

    @Column(name = "username", length = 100, nullable = false)
    private String username;

    @Column(name = "fecha_nacimiento", length = 100, nullable = false)
    private LocalDate fecha_nacimiento;

    @Column(name = "direccion_envio", nullable = false)
    private String direccion_envio;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "Email", nullable = false, unique = true))
    private Email email;

    @Column(name = "activo")
    private boolean activo;

    @Column(name = "password", nullable = false)
    private String password;

    public Usuario() {

    }

    public Usuario(boolean activo, String direccion_envio, Email email, LocalDate fecha_nacimiento, String username,
            Long usuario_id, String password) {
        this.activo = activo;
        this.direccion_envio = direccion_envio;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.username = username;
        this.usuario_id = usuario_id;
        this.password = password;
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
