import { apiFetch } from './client';
import type { LoginDTO, RegistroDTO, TokenDTO } from '../types';

export function login(data: LoginDTO): Promise<TokenDTO> {
    return apiFetch<TokenDTO>('/auth/login', {
        method: 'POST',
        body: JSON.stringify(data),
    });
}

export function registro(data: RegistroDTO): Promise<TokenDTO> {
    return apiFetch<TokenDTO>('/auth/registro', {
        method: 'POST',
        body: JSON.stringify(data),
    });
}
