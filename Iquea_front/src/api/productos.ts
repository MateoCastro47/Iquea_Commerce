import { apiFetch } from './client';
import type { Producto } from '../types';

export function getProductos(): Promise<Producto[]> {
    return apiFetch<Producto[]>('/productos');
}

export function getProducto(id: number): Promise<Producto> {
    return apiFetch<Producto>(`/productos/${id}`);
}

export function getDestacados(): Promise<Producto[]> {
    return apiFetch<Producto[]>('/productos/destacados');
}

export function buscarProductos(texto: string): Promise<Producto[]> {
    return apiFetch<Producto[]>(`/productos/buscar?nombre=${encodeURIComponent(texto)}`);
}

export function getProductosPorCategoria(categoriaId: number): Promise<Producto[]> {
    return apiFetch<Producto[]>(`/productos/categoria/${categoriaId}`);
}

export function getProductosPorPrecio(min: number, max: number): Promise<Producto[]> {
    return apiFetch<Producto[]>(`/productos/precio?min=${min}&max=${max}`);
}
