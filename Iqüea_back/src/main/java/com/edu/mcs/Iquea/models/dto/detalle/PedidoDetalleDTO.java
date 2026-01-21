package com.edu.mcs.Iquea.models.dto.detalle;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.edu.mcs.Iquea.models.Enums.EstadoPedido;
import com.edu.mcs.Iquea.models.dto.resumen.UsuarioResumenDTO;

public class PedidoDetalleDTO {
    private Long pedido_id;
    private UsuarioResumenDTO usuario;
    private LocalDateTime fechaPedido;
    private EstadoPedido estado;
    private List<DetallePedidoDTO> detalles;
    private BigDecimal total;

    public PedidoDetalleDTO() {
    }

    public PedidoDetalleDTO(Long pedido_id, UsuarioResumenDTO usuario, LocalDateTime fechaPedido,
            EstadoPedido estado, List<DetallePedidoDTO> detalles, BigDecimal total) {
        this.pedido_id = pedido_id;
        this.usuario = usuario;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.detalles = detalles;
        this.total = total;
    }

    public Long getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
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

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
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
