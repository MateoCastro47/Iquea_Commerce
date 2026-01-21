package com.edu.mcs.Iquea.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.edu.mcs.Iquea.models.Usuario;
import com.edu.mcs.Iquea.models.dto.detalle.UsuarioDetalleDTO;

@Mapper(componentModel = "spring")
public interface  UsuarioMapper {
    
    UsuarioDetalleDTO toDTO(Usuario usuario);

    List<UsuarioDetalleDTO> toDTOlist(List<Usuario> usuarios);

    Usuario toEntity(UsuarioDetalleDTO dto);

    void updatefromEntity(UsuarioDetalleDTO dto, @MappingTarget Usuario usuario);
}
