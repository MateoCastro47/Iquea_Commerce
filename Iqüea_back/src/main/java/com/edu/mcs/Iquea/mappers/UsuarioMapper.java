package com.edu.mcs.Iquea.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.edu.mcs.Iquea.models.Usuario;
import com.edu.mcs.Iquea.models.dto.detalle.UsuarioDetalleDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {

    // No devolver el hash de la contraseña en las respuestas JSON
    @Mapping(target = "password", ignore = true)
    UsuarioDetalleDTO toDTO(Usuario usuario);

    List<UsuarioDetalleDTO> toDTOlist(List<Usuario> usuarios);

    Usuario toEntity(UsuarioDetalleDTO dto);

    void updateUsuarioFromDTO(UsuarioDetalleDTO dto, @MappingTarget Usuario usuario);
}
