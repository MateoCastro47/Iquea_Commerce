package com.edu.mcs.Iquea.services;

import java.util.List;
import java.util.Optional;

import com.edu.mcs.Iquea.models.Pedido;
import com.edu.mcs.Iquea.models.dto.detalle.PedidoDetalleDTO;

public interface IPedidoService {
    
    Pedido crearPedido(PedidoDetalleDTO dto);

    Optional<Pedido> obtenerPedidoPorReferencia(Long pedido_id);

    List<Pedido> obtenerTodoslosPedidos();

    Pedido actualizarPedido(Long pedido_id, PedidoDetalleDTO dto);

    void borrarPedido(Long pedido_id);
}
