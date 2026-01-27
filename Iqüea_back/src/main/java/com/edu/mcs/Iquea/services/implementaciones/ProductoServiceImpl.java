package com.edu.mcs.Iquea.services.implementaciones;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.mcs.Iquea.mappers.ProductoMapper;
import com.edu.mcs.Iquea.models.Producto;
import com.edu.mcs.Iquea.models.dto.detalle.ProductoDetalleDTO;
import com.edu.mcs.Iquea.repositories.ProductoRepository;
import com.edu.mcs.Iquea.services.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{
    
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoServiceImpl(ProductoMapper productoMapper, ProductoRepository productoRepository) {
        this.productoMapper = productoMapper;
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional
    public Producto actualizarProducto(String sku, ProductoDetalleDTO dto) {
        try{
        Producto productoActualizado = productoRepository.findBySku(sku)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado con Sku " + sku));

        productoMapper.updatefromEntity(dto, productoActualizado);

        return productoRepository.save(productoActualizado);
        }catch(IllegalArgumentException e){
            throw new RuntimeException("Datos del producto no validos");
        }
    }

    @Override
    @Transactional
    public void borrarProducto(Long id) {
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
        }else{
            throw new RuntimeException("El producto con id " + id + " no existe");
        }
    }

    @Override
    @Transactional
    public Producto crearProducto(ProductoDetalleDTO dto) {
        if (productoRepository.existsBySku(dto.getSku())) {
            throw new IllegalArgumentException("Ya existe un producto con el SKU: " + dto.getSku());
        }
        Producto producto = productoMapper.toEntity(dto);
        return productoRepository.save(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> obtenertodoslosproductos() {
        return productoRepository.findAll();
    }
    
    @Transactional
    public List<Producto> obtenerProductosPorCategoria(Long categoriaId) {
        return productoRepository.findbyCategoriaId(categoriaId);
    }

    @Transactional
    public List<Producto> obtenerProductosPorDestacado(boolean es_destacado){
        return productoRepository.findbyes_destacado(es_destacado);
    }

    @Transactional
    public List<Producto> obtenerProductoPorRango(BigDecimal precioMinimo, BigDecimal precioMaximo){
        if (precioMaximo.compareTo(precioMinimo) < 0) {
            throw new IllegalArgumentException("El precio máximo no puede ser menor que el mínimo");
        }
        return productoRepository.findbyPrecioCantidadBetween(precioMinimo, precioMaximo);
    }

    @Transactional
    public List<Producto> obtenerProductoPorLetra(String nombre){
        return productoRepository.findbyNombreContainingCase(nombre);
    }

}