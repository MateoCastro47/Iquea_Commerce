import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { MdChair, MdOutlineLocalShipping, MdOutlineVerified } from 'react-icons/md';
import { FiArrowRight } from 'react-icons/fi';
import { getDestacados } from '../api/productos';
import type { Producto } from '../types';
import ProductoCard from '../components/ProductoCard';
import './Home.css';

const CATEGORIAS = [
    { nombre: 'Sofás', emoji: '🛋️', slug: 'sofas' },
    { nombre: 'Mesas', emoji: '🪑', slug: 'mesas' },
    { nombre: 'Dormitorio', emoji: '🛏️', slug: 'dormitorio' },
    { nombre: 'Iluminación', emoji: '💡', slug: 'iluminacion' },
];

const VALORES = [
    {
        icon: <MdChair size={28} />,
        titulo: 'Artesanía española',
        desc: 'Cada pieza fabricada con materiales seleccionados y acabados a mano.',
    },
    {
        icon: <MdOutlineLocalShipping size={28} />,
        titulo: 'Envío gratuito',
        desc: 'En pedidos superiores a 200 €. Entrega en 5–10 días laborables.',
    },
    {
        icon: <MdOutlineVerified size={28} />,
        titulo: 'Garantía 5 años',
        desc: 'Respaldamos la calidad de nuestros muebles con garantía extendida.',
    },
];

export default function Home() {
    const [destacados, setDestacados] = useState<Producto[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        getDestacados()
            .then((data) => setDestacados(data.slice(0, 4)))
            .catch(() => setError('No se pudieron cargar los productos destacados.'))
            .finally(() => setLoading(false));
    }, []);

    return (
        <main className="home">

            {/* ── Hero ─────────────────────────────────────────────── */}
            <section className="home__hero">
                <div className="home__hero-content">
                    <p className="home__hero-eyebrow">Nueva colección 2025</p>
                    <h1 className="home__hero-title">
                        Muebles con alma.<br />Diseño con propósito.
                    </h1>
                    <p className="home__hero-subtitle">
                        Descubre piezas únicas que transforman tu hogar en un espacio que te inspira cada día.
                    </p>
                    <div className="home__hero-actions">
                        <Link to="/productos" className="btn btn--primary btn--lg">
                            Ver catálogo <FiArrowRight />
                        </Link>
                        <Link to="/productos?destacados=true" className="btn btn--ghost btn--lg">
                            Destacados
                        </Link>
                    </div>
                </div>
                <div className="home__hero-visual">
                    <div className="home__hero-blob" />
                    <div className="home__hero-img-wrap">
                        <MdChair className="home__hero-icon" />
                    </div>
                </div>
            </section>

            {/* ── Valores ──────────────────────────────────────────── */}
            <section className="home__valores">
                <div className="home__section-inner">
                    {VALORES.map((v) => (
                        <div key={v.titulo} className="home__valor-card">
                            <span className="home__valor-icon">{v.icon}</span>
                            <h3 className="home__valor-titulo">{v.titulo}</h3>
                            <p className="home__valor-desc">{v.desc}</p>
                        </div>
                    ))}
                </div>
            </section>

            {/* ── Categorías ───────────────────────────────────────── */}
            <section className="home__section home__categorias-section">
                <div className="home__section-inner">
                    <div className="home__section-header">
                        <h2 className="home__section-title">Explora por categoría</h2>
                        <Link to="/productos" className="home__section-link">
                            Ver todo <FiArrowRight />
                        </Link>
                    </div>
                    <div className="home__categorias-grid">
                        {CATEGORIAS.map((cat) => (
                            <Link
                                key={cat.slug}
                                to={`/productos?categoria=${cat.slug}`}
                                className="home__categoria-card"
                            >
                                <span className="home__categoria-emoji">{cat.emoji}</span>
                                <span className="home__categoria-nombre">{cat.nombre}</span>
                            </Link>
                        ))}
                    </div>
                </div>
            </section>

            {/* ── Destacados ───────────────────────────────────────── */}
            <section className="home__section home__destacados-section">
                <div className="home__section-inner">
                    <div className="home__section-header">
                        <h2 className="home__section-title">Productos destacados</h2>
                        <Link to="/productos" className="home__section-link">
                            Ver todos <FiArrowRight />
                        </Link>
                    </div>

                    {loading && (
                        <div className="home__loading">
                            <span className="home__spinner" />
                            Cargando productos…
                        </div>
                    )}

                    {error && <p className="home__error">{error}</p>}

                    {!loading && !error && destacados.length === 0 && (
                        <p className="home__empty">No hay productos destacados por ahora.</p>
                    )}

                    {!loading && !error && destacados.length > 0 && (
                        <div className="home__productos-grid">
                            {destacados.map((p) => (
                                <ProductoCard key={p.producto_id} producto={p} />
                            ))}
                        </div>
                    )}
                </div>
            </section>

            {/* ── CTA Banner ───────────────────────────────────────── */}
            <section className="home__cta">
                <div className="home__cta-inner">
                    <h2 className="home__cta-title">¿Buscas algo especial?</h2>
                    <p className="home__cta-desc">
                        Nuestro equipo puede ayudarte a encontrar o diseñar el mueble perfecto para tu espacio.
                    </p>
                    <Link to="/productos" className="btn btn--accent btn--lg">
                        Explorar catálogo completo <FiArrowRight />
                    </Link>
                </div>
            </section>

        </main>
    );
}
