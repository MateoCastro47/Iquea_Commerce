package com.edu.mcs.Iquea.models.dto.detalle;

import java.math.BigDecimal;

import com.edu.mcs.Iquea.models.dto.resumen.CategoriaResumenDTO;

public class ProductoDetalleDTO {

    private Long producto_id;
    private String sku;
    private String nombre;
    private BigDecimal precioCantidad;
    private String precioMoneda;
    private Double dimensionesAlto;
    private Double dimensionesAncho;
    private Double dimensionesProfundo;
    private boolean es_destacado;
    private CategoriaResumenDTO categoria;

    public ProductoDetalleDTO() {
    }

    public ProductoDetalleDTO(Long producto_id, String nombre, BigDecimal precioCantidad, String precioMoneda,
            Double dimensionesAlto, Double dimensionesAncho, Double dimensionesProfundo, boolean es_destacado,
            CategoriaResumenDTO categoria, String sku) {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.precioCantidad = precioCantidad;
        this.precioMoneda = precioMoneda;
        this.dimensionesAlto = dimensionesAlto;
        this.dimensionesAncho = dimensionesAncho;
        this.dimensionesProfundo = dimensionesProfundo;
        this.es_destacado = es_destacado;
        this.categoria = categoria;
        this.sku = sku;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public Double getDimensionesAlto() {
        return dimensionesAlto;
    }

    public void setDimensionesAlto(Double dimensionesAlto) {
        this.dimensionesAlto = dimensionesAlto;
    }

    public Double getDimensionesAncho() {
        return dimensionesAncho;
    }

    public void setDimensionesAncho(Double dimensionesAncho) {
        this.dimensionesAncho = dimensionesAncho;
    }

    public Double getDimensionesProfundo() {
        return dimensionesProfundo;
    }

    public void setDimensionesProfundo(Double dimensionesProfundo) {
        this.dimensionesProfundo = dimensionesProfundo;
    }

    public boolean isEs_destacado() {
        return es_destacado;
    }

    public void setEs_destacado(boolean es_destacado) {
        this.es_destacado = es_destacado;
    }

    public CategoriaResumenDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResumenDTO categoria) {
        this.categoria = categoria;
    }
}
