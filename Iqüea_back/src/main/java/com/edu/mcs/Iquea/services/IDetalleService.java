package com.edu.mcs.Iquea.services;

import java.util.List;

import com.edu.mcs.Iquea.models.Detalle_pedido;
import com.edu.mcs.Iquea.models.dto.detalle.DetallePedidoDTO;

public interface IDetalleService {

    List<Detalle_pedido> obtenerDetallesPorPedido(Long pedido_id);

    DetallePedidoDTO anhadirDetalle(Long pedido_id, DetallePedidoDTO dto);

    void eliminarDetalle(Long detalle_id);

    DetallePedidoDTO actualizarCantidad(Long detalleId, Integer nuevaCantidad);
}
