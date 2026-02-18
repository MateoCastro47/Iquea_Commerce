package com.edu.mcs.Iquea.services.implementaciones;

import java.util.List;

import com.edu.mcs.Iquea.mappers.DetallePedidoMapper;
import com.edu.mcs.Iquea.models.Detalle_pedido;
import com.edu.mcs.Iquea.models.Pedido;
import com.edu.mcs.Iquea.models.dto.detalle.DetallePedidoDTO;
import com.edu.mcs.Iquea.repositories.DetallePedidoRepository;
import com.edu.mcs.Iquea.repositories.PedidoRepository;
import com.edu.mcs.Iquea.services.IDetalleService;

import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl implements IDetalleService {

    private final DetallePedidoRepository detallePedidoRepository;
    private final PedidoRepository pedidoRepository;
    private final DetallePedidoMapper detallePedidoMapper;

    public DetalleServiceImpl(DetallePedidoRepository detallePedidoRepository,
            DetallePedidoMapper detallePedidoMapper, PedidoRepository pedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
        this.detallePedidoMapper = detallePedidoMapper;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public DetallePedidoDTO anhadirDetalle(Long pedido_id, DetallePedidoDTO dto) {
        if (!pedidoRepository.existsById(pedido_id)) {
            throw new IllegalArgumentException("No existe un pedido con ese id");
        }

        Pedido pedido = pedidoRepository.findById(pedido_id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));

        Detalle_pedido detalle = detallePedidoMapper.toEntity(dto);

        detalle.setPedido(pedido);

        Detalle_pedido savedDetalle = detallePedidoRepository.save(detalle);
        return detallePedidoMapper.toDTO(savedDetalle);
    }

    @Override
    public void eliminarDetalle(Long detalle_id) {
        if (detallePedidoRepository.existsById(detalle_id)) {
            detallePedidoRepository.deleteById(detalle_id);
        } else {
            throw new IllegalArgumentException("No existe un pedido con ese id");
        }

    }

    @Override
    public List<Detalle_pedido> obtenerDetallesPorPedido(Long pedido_id) {
        return detallePedidoRepository.findByPedido(pedido_id);
    }

    @Override
    public DetallePedidoDTO actualizarCantidad(Long detalleId, Integer nuevaCantidad) {

        Detalle_pedido detalle = detallePedidoRepository.findById(detalleId)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado con ID: " + detalleId));

        if (nuevaCantidad <= 0) {
            detallePedidoRepository.delete(detalle);
            return null;
        } else {
            detalle.setCantidad(nuevaCantidad);
            return detallePedidoMapper.toDTO(detallePedidoRepository.save(detalle));
        }
    }

}
