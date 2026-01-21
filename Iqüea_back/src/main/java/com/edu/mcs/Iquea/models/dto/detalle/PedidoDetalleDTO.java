package com.edu.mcs.Iquea.models.dto.detalle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.edu.mcs.Iquea.models.Enums.EstadoPedido;
import com.edu.mcs.Iquea.models.dto.resumen.UsuarioResumenDTO;

public class PedidoDetalleDTO {
    private Long pedidoId;
    private UsuarioResumenDTO usuario;
    private LocalDateTime fechaPedido;
    private EstadoPedido estadoPedido;
    private List<DetallePedidoDTO> detalles;
    private BigDecimal total;

    public PedidoDetalleDTO() {
    }

    public PedidoDetalleDTO(Long pedidoId, UsuarioResumenDTO usuario, LocalDateTime fechaPedido,
            EstadoPedido estadoPedido, List<DetallePedidoDTO> detalles, BigDecimal total) {
        this.pedidoId = pedidoId;
        this.usuario = usuario;
        this.fechaPedido = fechaPedido;
        this.estadoPedido = estadoPedido;
        this.detalles = detalles;
        this.total = total;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public UsuarioResumenDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioResumenDTO usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public List<DetallePedidoDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedidoDTO> detalles) {
        this.detalles = detalles;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

}
