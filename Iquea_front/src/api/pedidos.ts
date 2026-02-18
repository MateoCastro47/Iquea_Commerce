import { apiFetch } from './client';
import type { Pedido, DetallePedido } from '../types';

export function getPedidos(): Promise<Pedido[]> {
    return apiFetch<Pedido[]>('/pedidos');
}

export function getPedido(id: number): Promise<Pedido> {
    return apiFetch<Pedido>(`/pedidos/${id}`);
}

export function crearPedido(usuarioId: number): Promise<Pedido> {
    return apiFetch<Pedido>('/pedidos', {
        method: 'POST',
        body: JSON.stringify({ usuario_id: usuarioId }),
    });
}

export function getDetallesPedido(pedidoId: number): Promise<DetallePedido[]> {
    return apiFetch<DetallePedido[]>(`/pedidos/${pedidoId}/detalles`);
}

export function anhadirDetalle(
    pedidoId: number,
    productoId: number,
    cantidad: number
): Promise<DetallePedido> {
    return apiFetch<DetallePedido>(`/pedidos/${pedidoId}/detalles`, {
        method: 'POST',
        body: JSON.stringify({ producto_id: productoId, cantidad }),
    });
}

export function eliminarDetalle(detalleId: number): Promise<void> {
    return apiFetch<void>(`/detalles/${detalleId}`, { method: 'DELETE' });
}

export function actualizarCantidad(detalleId: number, cantidad: number): Promise<DetallePedido> {
    return apiFetch<DetallePedido>(`/detalles/${detalleId}/cantidad?cantidad=${cantidad}`, {
        method: 'PUT',
    });
}
