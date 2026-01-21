package com.edu.mcs.Iquea.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="categorias")
public class Categorias {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long categoria_id;

    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;

    @Column(name = "Slug", length = 155, nullable = false)
    private String slug;

    @OneToMany(mappedBy= "categoria", fetch=FetchType.LAZY)
    private List<Producto>productos;



    public Categorias(){

    }

    public Categorias(Long categoria_id, String nombre, String slug) {
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (!this.productos.contains(producto)) {
            this.productos.add(producto);
            producto.vincularCategoria(this);
        }
    }
    public void removerProducto(Producto producto) {
        if (producto != null && this.productos.contains(producto)) {
            this.productos.remove(producto);
        }
    }

    
}
