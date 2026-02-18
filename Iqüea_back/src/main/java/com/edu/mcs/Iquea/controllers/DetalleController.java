package com.edu.mcs.Iquea.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edu.mcs.Iquea.mappers.DetallePedidoMapper;
import com.edu.mcs.Iquea.models.dto.detalle.DetallePedidoDTO;
import com.edu.mcs.Iquea.services.IDetalleService;

@RestController
@RequestMapping("/api")
public class DetalleController {

    private final IDetalleService detalleService;
    private final DetallePedidoMapper detalleMapper;

    public DetalleController(IDetalleService detalleService, DetallePedidoMapper detalleMapper) {
        this.detalleService = detalleService;
        this.detalleMapper = detalleMapper;
    }

    @GetMapping("/pedidos/{pedidoId}/detalles")
    public ResponseEntity<List<DetallePedidoDTO>> obtenerDetalles(@PathVariable Long pedidoId) {
        return ResponseEntity.ok(
            detalleService.obtenerDetallesPorPedido(pedidoId)
                .stream().map(detalleMapper::toDTO).toList()
        );
    }

    @PostMapping("/pedidos/{pedidoId}/detalles")
    public ResponseEntity<DetallePedidoDTO> añadirDetalle(
            @PathVariable Long pedidoId,
            @RequestBody DetallePedidoDTO dto) {
        DetallePedidoDTO creado = detalleService.anhadirDetalle(pedidoId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PutMapping("/detalles/{detalleId}")
    public ResponseEntity<DetallePedidoDTO> actualizarCantidad(
            @PathVariable Long detalleId,
            @RequestParam Integer cantidad) {
        DetallePedidoDTO actualizado = detalleService.actualizarCantidad(detalleId, cantidad);
        if (actualizado == null) return ResponseEntity.noContent().build(); // cantidad = 0 → eliminado
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/detalles/{detalleId}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Long detalleId) {
        detalleService.eliminarDetalle(detalleId);
        return ResponseEntity.noContent().build();
    }
}
