package com.edu.mcs.Iquea.models;

import com.edu.mcs.Iquea.models.Vo.Dimensiones;
import com.edu.mcs.Iquea.models.Vo.Precio;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producto_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id") // La columna en la tabla Producto que une con Categoria
    private Categorias categoria;

    @Column(name = "nombre", length = 155, nullable = false)
    private String nombre;

    @Column(name = "sku", unique = true, nullable = false, length = 50)
    private String sku;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cantidad", column = @Column(name = "Cantidad", nullable = false, scale = 2)),
            @AttributeOverride(name = "moneda", column = @Column(name = "Moneda", nullable = false, length = 3))
    })
    private Precio precio;

    @Column(name = "es_destacado")
    private boolean es_destacado;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "alto", column = @Column(name = "Alto", nullable = false)),
            @AttributeOverride(name = "ancho", column = @Column(name = "Ancho", nullable = false)),
            @AttributeOverride(name = "profundidad", column = @Column(name = "Profundidad", nullable = false))
    })
    private Dimensiones dimensiones;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "stock", nullable = false)
    private Integer stock = 0;

    @Column(name = "imagen_url")
    private String imagenUrl;

    public Producto() {
    }

    public Producto(Categorias categoria, Dimensiones dimensiones, boolean es_destacado, String nombre, Precio precio,
            Long producto_id, String sku, String descripcion, Integer stock, String imagenUrl) {
        this.categoria = categoria;
        this.dimensiones = dimensiones;
        this.es_destacado = es_destacado;
        this.nombre = nombre;
        this.precio = precio;
        this.producto_id = producto_id;
        this.sku = sku;
        this.descripcion = descripcion;
        this.stock = stock;
        this.imagenUrl = imagenUrl;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSku() {
        return sku;
    }

    public Precio getPrecio() {
        return precio;
    }

    public boolean isEs_destacado() {
        return es_destacado;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void vincularCategoria(Categorias categoria) {
        if (this.categoria == categoria) {
            return;
        }
        if (this.categoria != null) {
            this.categoria.getProductos().remove(this);
        }

        this.categoria = categoria;

        if (categoria != null && !categoria.getProductos().contains(this)) {
            categoria.getProductos().add(this);
        }
    }

    public void setCategoria(Categorias categoria) {
        vincularCategoria(categoria);
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    public void setEs_destacado(boolean es_destacado) {
        this.es_destacado = es_destacado;
    }

    public void setDimensiones(Dimensiones dimensiones) {
        this.dimensiones = dimensiones;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

}