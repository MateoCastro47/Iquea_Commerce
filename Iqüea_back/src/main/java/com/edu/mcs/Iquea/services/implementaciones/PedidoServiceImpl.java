package com.edu.mcs.Iquea.services.implementaciones;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.mcs.Iquea.mappers.PedidoMapper;
import com.edu.mcs.Iquea.models.Enums.EstadoPedido;
import com.edu.mcs.Iquea.models.Pedido;
import com.edu.mcs.Iquea.models.Usuario;
import com.edu.mcs.Iquea.models.dto.detalle.PedidoDetalleDTO;
import com.edu.mcs.Iquea.repositories.PedidoRepository;
import com.edu.mcs.Iquea.services.IPedidoService;

@Service
public class PedidoServiceImpl implements IPedidoService{
    
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }

    @Override
    @Transactional
    public Pedido actualizarPedido(Long pedido_id, PedidoDetalleDTO dto) {
        try{
            Pedido pedidoActualizado = pedidoRepository.findById(pedido_id)
            .orElseThrow(() -> new RuntimeException("No se encontró pedido con id: " + pedido_id));

            pedidoMapper.updateFromEntity(dto, pedidoActualizado);

            return pedidoRepository.save(pedidoActualizado);

        }catch(IllegalArgumentException e){
            throw new RuntimeException("Datos del pedido no válidos");
        }
    }

    @Override
    @Transactional
    public void borrarPedido(Long pedido_id) {
        if (pedidoRepository.existsById(pedido_id)) {
            pedidoRepository.deleteById(pedido_id);
        }
    }

    @Override
    @Transactional
    public Pedido crearPedido(PedidoDetalleDTO dto) {
        Pedido pedido = pedidoMapper.toEntity(dto);
        pedido.setFechaPedido(LocalDateTime.now()); // fecha automática
        pedido.setEstado(EstadoPedido.PENDIENTE); // estado inicial
        return pedidoRepository.save(pedido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pedido> obtenerPedidoPorReferencia(Long pedido_id) {
        return pedidoRepository.findById(pedido_id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> obtenerTodoslosPedidos() {
        return pedidoRepository.findAll();
    }

    @Transactional
    public List<Pedido> buscarPorEstado(EstadoPedido estadoPedido){
        return pedidoRepository.findByEstado(estadoPedido);
    }

    @Transactional
    public List<Pedido> buscarPorUsuario(Usuario usuario){
        return pedidoRepository.findByUsuario(usuario);
    }

    @Transactional
    public List<Pedido> buscarPorFechaPedido(LocalDateTime fechaPedido){
        return pedidoRepository.findByFechaPedido(fechaPedido);
    }
}
