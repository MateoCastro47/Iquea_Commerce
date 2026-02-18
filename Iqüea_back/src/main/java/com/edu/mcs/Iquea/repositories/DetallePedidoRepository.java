package com.edu.mcs.Iquea.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.mcs.Iquea.models.Detalle_pedido;

public interface DetallePedidoRepository extends JpaRepository<Detalle_pedido, Long> {

    List<Detalle_pedido> findByPedido(Long pedido_id);

    Optional<Detalle_pedido> findByPedidoandProducto(Long pedido_id, Long producto_id);
}
