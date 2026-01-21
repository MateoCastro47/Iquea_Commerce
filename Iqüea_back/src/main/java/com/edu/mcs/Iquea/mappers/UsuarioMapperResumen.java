package com.edu.mcs.Iquea.mappers;

import org.mapstruct.Mapper;

import com.edu.mcs.Iquea.models.Usuario;
import com.edu.mcs.Iquea.models.dto.resumen.UsuarioResumenDTO;

@Mapper(componentModel = "spring")
public interface UsuarioMapperResumen {
    
    UsuarioResumenDTO toDTO(Usuario usuario);

    Usuario toEntity(UsuarioResumenDTO dto);
    
}
