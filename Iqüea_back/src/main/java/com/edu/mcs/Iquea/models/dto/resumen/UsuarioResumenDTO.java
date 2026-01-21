package com.edu.mcs.Iquea.models.dto.resumen;

import com.edu.mcs.Iquea.models.Vo.Email;

public class UsuarioResumenDTO {
    private Long usuarioId;
    private String username;
    private Email email;

    public UsuarioResumenDTO() {
    }

    public UsuarioResumenDTO(Long usuarioId, String username, Email email) {
        this.usuarioId = usuarioId;
        this.username = username;
        this.email = email;
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

}
