package com.edu.mcs.Iquea.models.dto.detalle;

import java.util.List;

import com.edu.mcs.Iquea.models.dto.resumen.ProductoResumenDTO;

public class CategoriaDetalleDTO {
    private Long categoria_id;
    private String nombre;
    private String slug;
    private List<ProductoResumenDTO> productos;

    public CategoriaDetalleDTO() {
    }

    public CategoriaDetalleDTO(Long categoria_id, String nombre, String slug, List<ProductoResumenDTO> productos) {
        this.categoria_id = categoria_id;
        this.nombre = nombre;
        this.slug = slug;
        this.productos = productos;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
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
