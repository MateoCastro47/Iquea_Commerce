package com.edu.mcs.Iquea.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.edu.mcs.Iquea.models.Categorias;
import com.edu.mcs.Iquea.models.dto.detalle.CategoriaDetalleDTO;

@Mapper(componentModel = "spring", uses = {ProductoMapperResumen.class})
public interface CategoriaMapper {
    
    @Mapping(source = "productos", target = "productos")
    CategoriaDetalleDTO toDTO(Categorias categoria);

    @Mapping(source = "productos", target = "productos")
    Categorias toEntity(CategoriaDetalleDTO dto);

    List<CategoriaDetalleDTO> toDTOlist(List<Categorias> categoria);
    
    @Mapping(source = "productos", target = "productos")
    void updatefromEntity(CategoriaDetalleDTO dto, @MappingTarget Categorias categorias);
}
