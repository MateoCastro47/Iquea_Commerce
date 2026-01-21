package com.edu.mcs.Iquea.mappers;

import org.mapstruct.Mapper;

import com.edu.mcs.Iquea.models.Categorias;
import com.edu.mcs.Iquea.models.dto.resumen.CategoriaResumenDTO;

@Mapper(componentModel = "spring")
public interface CategoriaMapperResumen {
    
    CategoriaResumenDTO toDTO(Categorias categorias);

    Categorias toEntity(CategoriaResumenDTO dto);

    
}
