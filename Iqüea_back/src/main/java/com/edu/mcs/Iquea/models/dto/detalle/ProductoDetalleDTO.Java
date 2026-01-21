package com.edu.mcs.Iquea.models.dto.detalle;

public class ProductoDetalleDTO {

    private Long productoId;
    private String nombre;
    private BigDecimal precioCantidad;
    private String precioMoneda;
    private Double dimensionesAlto;
    private Double dimensionesAncho;
    private Double dimensionesProfundo;
    private boolean esDestacado;
    private CategoriaResumenDTO categoria;

    public ProductoDetalleDTO() {
    }

    public ProductoDetalleDTO(Long productoId, String nombre, BigDecimal precioCantidad, String precioMoneda,
            Double dimensionesAlto, Double dimensionesAncho, Double dimensionesProfundo, boolean esDestacado,
            CategoriaResumenDTO categoria) {
        this.productoId = productoId;
        this.nombre = nombre;
        this.precioCantidad = precioCantidad;
        this.precioMoneda = precioMoneda;
        this.dimensionesAlto = dimensionesAlto;
        this.dimensionesAncho = dimensionesAncho;
        this.dimensionesProfundo = dimensionesProfundo;
        this.esDestacado = esDestacado;
        this.categoria = categoria;
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

    public boolean isEsDestacado() {
        return esDestacado;
    }

    public void setEsDestacado(boolean esDestacado) {
        this.esDestacado = esDestacado;
    }

    public CategoriaResumenDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResumenDTO categoria) {
        this.categoria = categoria;
    }
}
