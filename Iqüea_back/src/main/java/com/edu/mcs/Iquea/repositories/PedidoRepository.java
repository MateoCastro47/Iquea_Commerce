package com.edu.mcs.Iquea.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.mcs.Iquea.models.Pedido;
import com.edu.mcs.Iquea.models.Usuario;
import com.edu.mcs.Iquea.models.Enums.EstadoPedido;
import java.time.LocalDateTime;



public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByEstado(EstadoPedido estado);

    List<Pedido> findByUsuario(Usuario usuario);

    List<Pedido> findByFechaPedido(LocalDateTime fechaPedido);

}
