package com.edu.mcs.Iquea.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.mcs.Iquea.mappers.ProductoMapper;
import com.edu.mcs.Iquea.models.Producto;
import com.edu.mcs.Iquea.models.dto.detalle.ProductoDetalleDTO;
import com.edu.mcs.Iquea.services.implementaciones.ProductoServiceImpl;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoServiceImpl productoService;
    private final ProductoMapper productoMapper;

    public ProductoController(ProductoMapper productoMapper, ProductoServiceImpl productoService) {
        this.productoMapper = productoMapper;
        this.productoService = productoService;
    }

    @GetMapping
    public ResponseEntity<List<ProductoDetalleDTO>> listarTodos() {
        List<Producto> productos = productoService.obtenertodoslosproductos();
        return ResponseEntity.ok(productoMapper.toDTOlist(productos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDetalleDTO> obtenerPorId(@PathVariable Long id) {
        return productoService.obtenerProductoPorId(id).map(p -> ResponseEntity.ok(productoMapper.toDTO(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<ProductoDetalleDTO> obtenerPorSku(@PathVariable String sku) {
        return productoService.obtenerProductoPorSku(sku)
                .map(p -> ResponseEntity.ok(productoMapper.toDTO(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/precio")
    public ResponseEntity<List<ProductoDetalleDTO>> porRangoPrecio(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {
        List<Producto> productos = productoService.obtenerProductoPorRango(min, max);
        return ResponseEntity.ok(productoMapper.toDTOlist(productos));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ProductoDetalleDTO>> buscarPorNombre(@RequestParam String nombre) {
        List<Producto> productos = productoService.obtenerProductoPorLetra(nombre);
        return ResponseEntity.ok(productoMapper.toDTOlist(productos));
    }

    @GetMapping("/destacados")
    public ResponseEntity<List<ProductoDetalleDTO>> destacados() {
        List<Producto> productos = productoService.obtenerProductosPorDestacado(true);
        return ResponseEntity.ok(productoMapper.toDTOlist(productos));
    }

    @PostMapping
    public ResponseEntity<ProductoDetalleDTO> crear(@RequestBody ProductoDetalleDTO dto) {
        Producto creado = productoService.crearProducto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoMapper.toDTO(creado));
    }

    @PutMapping("/sku/{sku}")
    public ResponseEntity<ProductoDetalleDTO> actualizar(
            @PathVariable String sku,
            @RequestBody ProductoDetalleDTO dto) {
        Producto actualizado = productoService.actualizarProducto(sku, dto);
        return ResponseEntity.ok(productoMapper.toDTO(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.borrarProducto(id);
        return ResponseEntity.noContent().build();
    }
}
