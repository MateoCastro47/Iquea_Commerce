package com.edu.mcs.Iquea.models.dto.resumen;

import com.edu.mcs.Iquea.models.Vo.Email;

public class UsuarioResumenDTO {
    private Long usuario_id;
    private String username;
    private Email email;

    public UsuarioResumenDTO() {
    }

    public UsuarioResumenDTO(Long usuario_id, String username, Email email) {
        this.usuario_id = usuario_id;
        this.username = username;
        this.email = email;
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

}
