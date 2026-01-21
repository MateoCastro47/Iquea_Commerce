package com.edu.mcs.Iquea.models.dto.resumen;

public class CategoriaResumenDTO {
    private Long categoria_id;
    private String nombre;
    private String slug;

    public CategoriaResumenDTO() {
    }

    public CategoriaResumenDTO(Long categoria_id, String nombre, String slug) {
        this.categoria_id = categoria_id;
        this.nombre = nombre;
        this.slug = slug;
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
}
