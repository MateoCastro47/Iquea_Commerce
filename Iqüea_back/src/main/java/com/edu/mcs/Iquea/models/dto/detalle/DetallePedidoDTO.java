package com.edu.mcs.Iquea.models.dto.detalle;

import java.math.BigDecimal;

import com.edu.mcs.Iquea.models.dto.resumen.ProductoResumenDTO;

public class DetallePedidoDTO {
    private Long detallePedidoId;
    private ProductoResumenDTO producto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    public DetallePedidoDTO() {
    }

    public DetallePedidoDTO(Long detallePedidoId, ProductoResumenDTO producto, Integer cantidad,
            BigDecimal precioUnitario, BigDecimal subtotal) {
        this.detallePedidoId = detallePedidoId;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public Long getDetallePedidoId() {
        return detallePedidoId;
    }

    public void setDetallePedidoId(Long detallePedidoId) {
        this.detallePedidoId = detallePedidoId;
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
