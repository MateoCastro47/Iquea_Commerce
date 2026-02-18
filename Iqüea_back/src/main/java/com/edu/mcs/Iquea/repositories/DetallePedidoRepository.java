package com.edu.mcs.Iquea.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edu.mcs.Iquea.models.Detalle_pedido;

public interface DetallePedidoRepository extends JpaRepository<Detalle_pedido, Long> {

    @Query("SELECT d FROM Detalle_pedido d WHERE d.pedido.pedido_id = :pedidoId")
    List<Detalle_pedido> findByPedidoId(@Param("pedidoId") Long pedidoId);

    Optional<Detalle_pedido> findByPedidoAndProducto(Long pedido_id, Long producto_id);
}
