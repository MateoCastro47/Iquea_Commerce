package com.edu.mcs.Iquea.services;

import java.util.List;
import java.util.Optional;

import com.edu.mcs.Iquea.models.Producto;
import com.edu.mcs.Iquea.models.dto.detalle.ProductoDetalleDTO;

public interface IProductoService {
    
    Producto crearProducto(ProductoDetalleDTO dto);

    Optional<Producto> obtenerProductoPorId(Long id);

    List<Producto> obtenertodoslosproductos();

    Producto actualizarProducto(String sku, ProductoDetalleDTO dto);

    void borrarProducto(Long id);

    Optional<Producto> obtenerProductoPorSku(String sku);
}
