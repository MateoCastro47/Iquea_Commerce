import { apiFetch } from './client';
import type { CategoriaResumen } from '../types';

export function getCategorias(): Promise<CategoriaResumen[]> {
    return apiFetch<CategoriaResumen[]>('/categorias');
}
