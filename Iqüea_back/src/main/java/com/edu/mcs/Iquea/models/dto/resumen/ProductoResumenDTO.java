package com.edu.mcs.Iquea.models.dto.resumen;

import java.math.BigDecimal;

public class ProductoResumenDTO {
    private Long producto_id;
    private String nombre;
    private BigDecimal precioCantidad;
    private String precioMoneda;
    private boolean es_destacado;

    public ProductoResumenDTO() {
    }

    public ProductoResumenDTO(Long producto_id, String nombre, BigDecimal precioCantidad, String precioMoneda,
            boolean es_destacado) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.precioCantidad = precioCantidad;
        this.precioMoneda = precioMoneda;
        this.es_destacado = es_destacado;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecioCantidad() {
        return precioCantidad;
    }

    public void setPrecioCantidad(BigDecimal precioCantidad) {
        this.precioCantidad = precioCantidad;
    }

    public String getPrecioMoneda() {
        return precioMoneda;
    }

    public void setPrecioMoneda(String precioMoneda) {
        this.precioMoneda = precioMoneda;
    }

    public boolean isEs_destacado() {
        return es_destacado;
    }

    public void setEs_destacado(boolean es_destacado) {
        this.es_destacado = es_destacado;
    }

}
