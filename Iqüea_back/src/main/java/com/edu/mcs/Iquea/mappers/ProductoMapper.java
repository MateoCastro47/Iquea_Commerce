package com.edu.mcs.Iquea.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.edu.mcs.Iquea.models.Producto;
import com.edu.mcs.Iquea.models.dto.detalle.ProductoDetalleDTO;
import com.edu.mcs.Iquea.models.dto.resumen.ProductoResumenDTO;

@Mapper(componentModel = "spring", uses = { CategoriaMapperResumen.class })
public interface ProductoMapper {

    @Mapping(source = "categoria", target = "categoria")
    @Mapping(source = "precio.cantidad", target = "precioCantidad")
    @Mapping(source = "precio.moneda", target = "precioMoneda")
    @Mapping(source = "dimensiones.alto", target = "dimensionesAlto")
    @Mapping(source = "dimensiones.ancho", target = "dimensionesAncho")
    @Mapping(source = "dimensiones.profundidad", target = "dimensionesProfundo")
    @Mapping(source = "imagenUrl", target = "imagen_url")
    ProductoDetalleDTO toDTO(Producto producto);

    @Mapping(source = "precio.cantidad", target = "precioCantidad")
    @Mapping(source = "precio.moneda", target = "precioMoneda")
    ProductoResumenDTO toResumenDTO(Producto producto);

    @Mapping(source = "categoria", target = "categoria")
    @Mapping(target = "precio", expression = "java(new Precio(dto.getPrecioCantidad(), dto.getPrecioMoneda()))")
    @Mapping(target = "dimensiones", expression = "java(new Dimensiones(dto.getDimensionesAlto(), dto.getDimensionesAncho(), dto.getDimensionesProfundo()))")
    Producto toEntity(ProductoDetalleDTO dto);

    List<ProductoDetalleDTO> toDTOlist(List<Producto> productos);

    @Mapping(source = "categoria", target = "categoria")
    @Mapping(target = "precio", expression = "java(new Precio(dto.getPrecioCantidad(), dto.getPrecioMoneda()))")
    @Mapping(target = "dimensiones", expression = "java(new Dimensiones(dto.getDimensionesAlto(), dto.getDimensionesAncho(), dto.getDimensionesProfundo()))")
    void updatefromEntity(ProductoDetalleDTO dto, @MappingTarget Producto producto);
}
