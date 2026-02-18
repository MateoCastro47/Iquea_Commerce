import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { login } from '../api/auth';
import { useAuth } from '../context/AuthContext';
import './Auth.css';

export default function Login() {
    const navigate = useNavigate();
    const { setToken } = useAuth();

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setError('');
        setLoading(true);

        try {
            const data = await login({ email, password });
            if (data.token) {
                setToken(data.token);
                navigate('/');
            } else {
                setError('No se recibió token del servidor.');
            }
        } catch (err) {
            console.error(err);
            setError('Credenciales incorrectas o error en el servidor.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="auth-page">
            <h1 className="auth-title">Iniciar Sesión</h1>

            {error && <div className="auth-error">{error}</div>}

            <form className="auth-form" onSubmit={handleSubmit}>
                <div className="form-group">
                    <label className="form-label" htmlFor="email">Email</label>
                    <input
                        id="email"
                        type="email"
                        className="form-input"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                        placeholder="tu@email.com"
                    />
                </div>

                <div className="form-group">
                    <label className="form-label" htmlFor="password">Contraseña</label>
                    <input
                        id="password"
                        type="password"
                        className="form-input"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                        placeholder="••••••••"
                    />
                </div>

                <button type="submit" className="auth-btn" disabled={loading}>
                    {loading ? 'Cargando...' : 'Entrar'}
                </button>
            </form>

            <div className="auth-footer">
                <p>¿No tienes cuenta? <Link to="/register" className="auth-link">Regístrate aquí</Link></p>
            </div>
        </div>
    );
}
