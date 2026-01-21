package com.edu.mcs.Iquea.models.dto.detalle;

import java.util.List;

import com.edu.mcs.Iquea.models.dto.resumen.ProductoResumenDTO;

public class CategoriaDetalleDTO {
    private Long categoriaId;
    private String nombre;
    private String slug;
    private List<ProductoResumenDTO> productos;

    public CategoriaDetalleDTO() {
    }

    public CategoriaDetalleDTO(Long categoriaId, String nombre, String slug, List<ProductoResumenDTO> productos) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
        this.slug = slug;
        this.productos = productos;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<ProductoResumenDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoResumenDTO> productos) {
        this.productos = productos;
    }
}
