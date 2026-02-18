import { createContext, useContext, useState, useEffect } from 'react';
import type { ReactNode } from 'react';
import { jwtDecode } from 'jwt-decode';

interface JwtPayload {
    sub: string;   // email
    rol: string;
    exp: number;
}

interface AuthContextType {
    token: string | null;
    email: string | null;
    rol: string | null;
    isAuthenticated: boolean;
    setToken: (token: string | null) => void;
    logout: () => void;
}

const AuthContext = createContext<AuthContextType | null>(null);

export function AuthProvider({ children }: { children: ReactNode }) {
    const [token, setTokenState] = useState<string | null>(
        () => localStorage.getItem('token')
    );

    const decoded = token ? jwtDecode<JwtPayload>(token) : null;
    const email = decoded?.sub ?? null;
    const rol = decoded?.rol ?? null;
    const isAuthenticated = !!token && (decoded?.exp ?? 0) > Date.now() / 1000;

    function setToken(newToken: string | null) {
        if (newToken) {
            localStorage.setItem('token', newToken);
        } else {
            localStorage.removeItem('token');
        }
        setTokenState(newToken);
    }

    function logout() {
        setToken(null);
    }

    // Limpiar token expirado al cargar
    useEffect(() => {
        if (token && (decoded?.exp ?? 0) < Date.now() / 1000) {
            logout();
        }
    }, []);

    return (
        <AuthContext.Provider value={{ token, email, rol, isAuthenticated, setToken, logout }}>
            {children}
        </AuthContext.Provider>
    );
}

export function useAuth() {
    const ctx = useContext(AuthContext);
    if (!ctx) throw new Error('useAuth must be used within AuthProvider');
    return ctx;
}
