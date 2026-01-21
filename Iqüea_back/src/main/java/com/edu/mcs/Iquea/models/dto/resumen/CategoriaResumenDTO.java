package com.edu.mcs.Iquea.models.dto.resumen;

public class CategoriaResumenDTO {
    private Long categoriaId;
    private String nombre;
    private String slug;

    public CategoriaResumenDTO() {
    }

    public CategoriaResumenDTO(Long categoriaId, String nombre, String slug) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
        this.slug = slug;
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
}
