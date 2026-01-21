package com.edu.mcs.Iquea.mappers;

import com.edu.mcs.Iquea.models.Producto;
import com.edu.mcs.Iquea.models.dto.resumen.ProductoResumenDTO;

public interface ProductoMapperResumen {
    
    ProductoResumenDTO toDTO(Producto producto);

    Producto toEntity(ProductoResumenDTO dto);

}
