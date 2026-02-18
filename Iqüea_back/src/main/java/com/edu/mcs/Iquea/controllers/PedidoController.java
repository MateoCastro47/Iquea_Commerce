package com.edu.mcs.Iquea.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edu.mcs.Iquea.mappers.PedidoMapper;
import com.edu.mcs.Iquea.models.Pedido;
import com.edu.mcs.Iquea.models.Enums.EstadoPedido;
import com.edu.mcs.Iquea.models.dto.detalle.PedidoDetalleDTO;
import com.edu.mcs.Iquea.services.implementaciones.PedidoServiceImpl;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoServiceImpl pedidoService;
    private final PedidoMapper pedidoMapper;

    public PedidoController(PedidoServiceImpl pedidoService, PedidoMapper pedidoMapper) {
        this.pedidoService = pedidoService;
        this.pedidoMapper = pedidoMapper;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDetalleDTO>> listarTodos() {
        List<Pedido> pedidos = pedidoService.obtenerTodoslosPedidos();
        return ResponseEntity.ok(pedidoMapper.toDTOlist(pedidos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDetalleDTO> obtenerPorId(@PathVariable Long id) {
        return pedidoService.obtenerPedidoPorReferencia(id)
                .map(p -> ResponseEntity.ok(pedidoMapper.toDTO(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<PedidoDetalleDTO>> porEstado(@PathVariable EstadoPedido estado) {
        List<Pedido> pedidos = pedidoService.buscarPorEstado(estado);
        return ResponseEntity.ok(pedidoMapper.toDTOlist(pedidos));
    }

    @PostMapping
    public ResponseEntity<PedidoDetalleDTO> crear(@RequestBody PedidoDetalleDTO dto) {
        Pedido creado = pedidoService.crearPedido(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoMapper.toDTO(creado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDetalleDTO> actualizar(
            @PathVariable Long id,
            @RequestBody PedidoDetalleDTO dto) {
        Pedido actualizado = pedidoService.actualizarPedido(id, dto);
        return ResponseEntity.ok(pedidoMapper.toDTO(actualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pedidoService.borrarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
