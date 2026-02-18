import { Link, useNavigate } from 'react-router-dom';
import { MdChair } from 'react-icons/md';
import { FiShoppingCart, FiLogOut, FiLogIn, FiUserPlus } from 'react-icons/fi';
import { useAuth } from '../context/AuthContext';
import './Navbar.css';

export default function Navbar() {
    const { isAuthenticated, logout } = useAuth();
    const navigate = useNavigate();

    function handleLogout() {
        logout();
        navigate('/');
    }

    return (
        <header className="navbar">
            <div className="navbar__container">
                <Link to="/" className="navbar__logo">
                    <MdChair className="navbar__logo-icon" />
                    <span className="navbar__logo-text">Iquea</span>
                </Link>

                <nav className="navbar__links">
                    <Link to="/" className="navbar__link">Inicio</Link>
                    <Link to="/productos" className="navbar__link">Productos</Link>
                    {isAuthenticated && (
                        <Link to="/carrito" className="navbar__link navbar__link--cart">
                            <FiShoppingCart /> Carrito
                        </Link>
                    )}
                </nav>

                <div className="navbar__actions">
                    {isAuthenticated ? (
                        <button onClick={handleLogout} className="btn btn--outline">
                            <FiLogOut /> Cerrar sesión
                        </button>
                    ) : (
                        <>
                            <Link to="/login" className="btn btn--outline"><FiLogIn /> Entrar</Link>
                            <Link to="/registro" className="btn btn--primary"><FiUserPlus /> Registrarse</Link>
                        </>
                    )}
                </div>
            </div>
        </header>
    );
}
