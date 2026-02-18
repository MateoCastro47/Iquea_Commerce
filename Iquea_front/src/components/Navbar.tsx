import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { MdChair } from 'react-icons/md';
import { FiShoppingCart, FiUser, FiSearch, FiLogOut } from 'react-icons/fi';
import { useAuth } from '../context/AuthContext';
import './Navbar.css';

export default function Navbar() {
    const { isAuthenticated, logout } = useAuth();
    const navigate = useNavigate();
    const [searchOpen, setSearchOpen] = useState(false);
    const [searchQuery, setSearchQuery] = useState('');

    function handleLogout() {
        logout();
        navigate('/');
    }

    function handleSearch(e: React.FormEvent) {
        e.preventDefault();
        if (searchQuery.trim()) {
            navigate(`/productos?q=${encodeURIComponent(searchQuery.trim())}`);
            setSearchQuery('');
            setSearchOpen(false);
        }
    }

    return (
        <header className="navbar">
            <div className="navbar__container">
                {/* Logo */}
                <Link to="/" className="navbar__logo">
                    <MdChair className="navbar__logo-icon" />
                    <span className="navbar__logo-text">Iquea</span>
                </Link>

                {/* Center nav links */}
                <nav className="navbar__links">
                    <Link to="/productos" className="navbar__link">Productos</Link>
                    <Link to="/habitaciones" className="navbar__link">Habitaciones</Link>
                    <Link to="/nosotros" className="navbar__link">Nosotros</Link>
                    <Link to="/contacto" className="navbar__link">Contacto</Link>
                </nav>

                {/* Right actions */}
                <div className="navbar__actions">
                    {/* Search */}
                    <div className={`navbar__search-wrap ${searchOpen ? 'navbar__search-wrap--open' : ''}`}>
                        {searchOpen && (
                            <form onSubmit={handleSearch} className="navbar__search-form">
                                <input
                                    type="text"
                                    className="navbar__search-input"
                                    placeholder="Buscar productos..."
                                    value={searchQuery}
                                    onChange={(e) => setSearchQuery(e.target.value)}
                                    autoFocus
                                    onBlur={() => { if (!searchQuery) setSearchOpen(false); }}
                                />
                            </form>
                        )}
                        <button
                            className="navbar__icon-btn"
                            onClick={() => setSearchOpen((v) => !v)}
                            aria-label="Buscar"
                        >
                            <FiSearch />
                        </button>
                    </div>

                    {/* User / Auth */}
                    {isAuthenticated ? (
                        <button onClick={handleLogout} className="navbar__icon-btn" aria-label="Cerrar sesión">
                            <FiLogOut />
                        </button>
                    ) : (
                        <Link to="/login" className="navbar__icon-btn" aria-label="Entrar">
                            <FiUser />
                        </Link>
                    )}

                    {/* Cart */}
                    {isAuthenticated && (
                        <Link to="/carrito" className="navbar__icon-btn navbar__icon-btn--cart" aria-label="Carrito">
                            <FiShoppingCart />
                        </Link>
                    )}
                </div>
            </div>
        </header>
    );
}
