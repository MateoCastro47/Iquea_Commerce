package com.edu.mcs.Iquea.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.edu.mcs.Iquea.models.Producto;
import com.edu.mcs.Iquea.models.dto.resumen.ProductoResumenDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductoMapperResumen {

    ProductoResumenDTO toDTO(Producto producto);

    Producto toEntity(ProductoResumenDTO dto);

}
