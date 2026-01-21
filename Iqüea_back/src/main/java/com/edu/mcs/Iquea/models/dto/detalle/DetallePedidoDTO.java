package com.edu.mcs.Iquea.models.dto.detalle;

import java.math.BigDecimal;

import com.edu.mcs.Iquea.models.dto.resumen.ProductoResumenDTO;

public class DetallePedidoDTO {
    private Long detalle_id;
    private ProductoResumenDTO producto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    public DetallePedidoDTO() {
    }

    public DetallePedidoDTO(Long detalle_id, ProductoResumenDTO producto, Integer cantidad,
            BigDecimal precioUnitario, BigDecimal subtotal) {
        this.detalle_id = detalle_id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public Long getDetalle_id() {
        return detalle_id;
    }

    public void setDetalle_id(Long detalle_id) {
        this.detalle_id = detalle_id;
    }

    public ProductoResumenDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoResumenDTO producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}
