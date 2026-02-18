import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { registro } from '../api/auth';
import { useAuth } from '../context/AuthContext';
import './Auth.css';

export default function Register() {
    const navigate = useNavigate();
    const { setToken } = useAuth();

    const [formData, setFormData] = useState({
        username: '',
        nombre: '',
        apellidos: '',
        email: '',
        password: '',
        fecha_nacimiento: '',
        direccion_envio: ''
    });

    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const calculateAge = (birthDate: string) => {
        const today = new Date();
        const birth = new Date(birthDate);
        let age = today.getFullYear() - birth.getFullYear();
        const m = today.getMonth() - birth.getMonth();
        if (m < 0 || (m === 0 && today.getDate() < birth.getDate())) {
            age--;
        }
        return age;
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setError('');

        // Validations
        if (calculateAge(formData.fecha_nacimiento) < 18) {
            setError('Debes ser mayor de edad para registrarte.');
            return;
        }

        setLoading(true);

        try {
            // Note: The structure for email in RegisterDTO is `{ value: string }` based on types/index.ts
            // But state has string. Need to adapt.
            const payload = {
                ...formData,
                email: { value: formData.email }
            };

            const data = await registro(payload);
            if (data.token) {
                setToken(data.token);
                navigate('/');
            } else {
                setError('Registro exitoso pero no se recibió token.');
            }
        } catch (err: any) {
            console.error(err);
            setError(err.message || 'Error al registrar usuario.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div className="auth-page" style={{ maxWidth: '500px' }}>
            <h1 className="auth-title">Crear Cuenta</h1>

            {error && <div className="auth-error">{error}</div>}

            <form className="auth-form" onSubmit={handleSubmit}>
                <div className="form-group">
                    <label className="form-label" htmlFor="username">Nombre de usuario</label>
                    <input
                        id="username"
                        name="username"
                        type="text"
                        className="form-input"
                        value={formData.username}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className="form-row">
                    <div className="form-group">
                        <label className="form-label" htmlFor="nombre">Nombre</label>
                        <input
                            id="nombre"
                            name="nombre"
                            type="text"
                            className="form-input"
                            value={formData.nombre}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label className="form-label" htmlFor="apellidos">Apellidos</label>
                        <input
                            id="apellidos"
                            name="apellidos"
                            type="text"
                            className="form-input"
                            value={formData.apellidos}
                            onChange={handleChange}
                            required
                        />
                    </div>
                </div>

                <div className="form-group">
                    <label className="form-label" htmlFor="email">Email</label>
                    <input
                        id="email"
                        name="email"
                        type="email"
                        className="form-input"
                        value={formData.email}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className="form-group">
                    <label className="form-label" htmlFor="password">Contraseña</label>
                    <input
                        id="password"
                        name="password"
                        type="password"
                        className="form-input"
                        value={formData.password}
                        onChange={handleChange}
                        required
                        minLength={6}
                    />
                </div>

                <div className="form-group">
                    <label className="form-label" htmlFor="fecha_nacimiento">Fecha de Nacimiento</label>
                    <input
                        id="fecha_nacimiento"
                        name="fecha_nacimiento"
                        type="date"
                        className="form-input"
                        value={formData.fecha_nacimiento}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div className="form-group">
                    <label className="form-label" htmlFor="direccion_envio">Dirección (Opcional)</label>
                    <input
                        id="direccion_envio"
                        name="direccion_envio"
                        type="text"
                        className="form-input"
                        value={formData.direccion_envio}
                        onChange={handleChange}
                    />
                </div>

                <button type="submit" className="auth-btn" disabled={loading}>
                    {loading ? 'Creando cuenta...' : 'Registrarse'}
                </button>
            </form>

            <div className="auth-footer">
                <p>¿Ya tienes cuenta? <Link to="/login" className="auth-link">Inicia Sesión</Link></p>
            </div>
        </div>
    );
}
