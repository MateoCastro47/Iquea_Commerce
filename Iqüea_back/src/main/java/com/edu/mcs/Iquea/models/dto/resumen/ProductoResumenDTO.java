package com.edu.mcs.Iquea.models.dto.resumen;

import java.math.BigDecimal;

public class ProductoResumenDTO {
    private Long productoId;
    private String nombre;
    private BigDecimal precioCantidad;
    private String precioMoneda;
    boolean esDestacado;

    public ProductoResumenDTO() {
    }

    public ProductoResumenDTO(Long productoId, String nombre, BigDecimal precioCantidad, String precioMoneda,
            boolean esDestacado) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.precioCantidad = precioCantidad;
        this.precioMoneda = precioMoneda;
        this.esDestacado = esDestacado;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
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

    public boolean isEsDestacado() {
        return esDestacado;
    }

    public void setEsDestacado(boolean esDestacado) {
        this.esDestacado = esDestacado;
    }

}
