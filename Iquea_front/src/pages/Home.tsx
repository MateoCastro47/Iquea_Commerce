import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { FiArrowRight, FiStar, FiMapPin, FiInstagram, FiFacebook } from 'react-icons/fi';
import { FaPinterest } from 'react-icons/fa';
import { getDestacados } from '../api/productos';
import type { Producto } from '../types';

import './Home.css';

/* ── Fallback mock products (shown when API is offline) ── */
const MOCK_PRODUCTS = [
    { producto_id: 1, nombre: 'Sofá Esmeralda', categoria: { nombre: 'Salón', slug: 'salon', categoria_id: 1 }, precioCantidad: 1299, precioMoneda: '€', imagen_url: 'https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=600&q=80', es_destacado: true, stock: 5, sku: '', descripcion: '', dimensionesAlto: 0, dimensionesAncho: 0, dimensionesProfundo: 0 },
    { producto_id: 2, nombre: 'Sillón Nordic', categoria: { nombre: 'Salón', slug: 'salon', categoria_id: 1 }, precioCantidad: 599, precioMoneda: '€', imagen_url: 'https://images.unsplash.com/photo-1567538096630-e0c55bd6374c?w=600&q=80', es_destacado: false, stock: 8, sku: '', descripcion: '', dimensionesAlto: 0, dimensionesAncho: 0, dimensionesProfundo: 0 },
    { producto_id: 3, nombre: 'Lámpara Arc', categoria: { nombre: 'Iluminación', slug: 'iluminacion', categoria_id: 2 }, precioCantidad: 249, precioMoneda: '€', imagen_url: 'https://images.unsplash.com/photo-1507473885765-e6ed057f782c?w=600&q=80', es_destacado: false, stock: 12, sku: '', descripcion: '', dimensionesAlto: 0, dimensionesAncho: 0, dimensionesProfundo: 0 },
    { producto_id: 4, nombre: 'Mesa de Centro Oak', categoria: { nombre: 'Mesas', slug: 'mesas', categoria_id: 3 }, precioCantidad: 450, precioMoneda: '€', imagen_url: 'https://images.unsplash.com/photo-1533090481720-856c6e3c1fdc?w=600&q=80', es_destacado: false, stock: 4, sku: '', descripcion: '', dimensionesAlto: 0, dimensionesAncho: 0, dimensionesProfundo: 0 },
    { producto_id: 5, nombre: 'Conjunto Aero Dining', categoria: { nombre: 'Comedor', slug: 'comedor', categoria_id: 4 }, precioCantidad: 2100, precioMoneda: '€', imagen_url: 'https://images.unsplash.com/photo-1617806118233-18e1de247200?w=600&q=80', es_destacado: true, stock: 2, sku: '', descripcion: '', dimensionesAlto: 0, dimensionesAncho: 0, dimensionesProfundo: 0 },
    { producto_id: 6, nombre: 'Cómoda Minimalist', categoria: { nombre: 'Dormitorio', slug: 'dormitorio', categoria_id: 5 }, precioCantidad: 750, precioMoneda: '€', imagen_url: 'https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=600&q=80', es_destacado: false, stock: 6, sku: '', descripcion: '', dimensionesAlto: 0, dimensionesAncho: 0, dimensionesProfundo: 0 },
] as Producto[];

function StarRating({ rating = 4 }: { rating?: number }) {
    return (
        <div className="home__stars">
            {[1, 2, 3, 4, 5].map((s) => (
                <FiStar
                    key={s}
                    className={`home__star ${s <= rating ? 'home__star--filled' : ''}`}
                />
            ))}
        </div>
    );
}

export default function Home() {
    const [productos, setProductos] = useState<Producto[]>(MOCK_PRODUCTS);
    useEffect(() => {
        getDestacados()
            .then((data) => {
                if (data.length > 0) setProductos(data.slice(0, 6));
            })
            .catch(() => {/* keep mock */ });
    }, []);

    return (
        <main className="home">

            {/* ── HERO ─────────────────────────────────────────────── */}
            <section className="home__hero">
                <img
                    src="https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=1600&q=85"
                    alt="Sofá moderno en salón minimalista"
                    className="home__hero-bg"
                />
                <div className="home__hero-overlay" />
                <div className="home__hero-content">
                    <span className="home__hero-eyebrow">Nueva colección 2025</span>
                    <h1 className="home__hero-title">
                        Eleva tu<br />
                        <span className="home__hero-title--accent">Espacio Vital</span>
                    </h1>
                    <p className="home__hero-subtitle">
                        Descubre diseños que combinan forma y función.<br />
                        Transforma tu hogar en un santuario de confort moderno.
                    </p>
                    <Link to="/productos" className="home__hero-btn">
                        Ver ahora <FiArrowRight />
                    </Link>
                </div>
            </section>

            {/* ── FEATURED COLLECTION ──────────────────────────────── */}
            <section className="home__featured">
                <div className="home__container">
                    <div className="home__section-head">
                        <h2 className="home__section-title">Colección Destacada</h2>
                        <div className="home__title-bar" />
                        <p className="home__section-sub">
                            Piezas seleccionadas a mano que definen elegancia contemporánea. Materiales de calidad, diseño atemporal.
                        </p>
                    </div>

                    <div className="home__products-grid">
                        {productos.map((p: Producto, i: number) => (
                            <Link
                                key={p.producto_id}
                                to={`/productos/${p.producto_id}`}
                                className="home__product-card"
                            >
                                {i === 0 && <span className="home__product-badge">-30%</span>}
                                <div className="home__product-img-wrap">
                                    <img
                                        src={p.imagen_url || 'https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=600&q=80'}
                                        alt={p.nombre}
                                        className="home__product-img"
                                        loading="lazy"
                                    />
                                </div>
                                <div className="home__product-info">
                                    <span className="home__product-cat">{p.categoria?.nombre}</span>
                                    <h3 className="home__product-name">{p.nombre}</h3>
                                    <div className="home__product-bottom">
                                        <span className="home__product-price">
                                            ${p.precioCantidad?.toLocaleString('es-ES')}
                                        </span>
                                        <StarRating rating={4 + (p.producto_id % 2)} />
                                    </div>
                                </div>
                            </Link>
                        ))}
                    </div>

                    <div className="home__view-all-wrap">
                        <Link to="/productos" className="home__view-all-btn">
                            Ver todos los productos
                        </Link>
                    </div>
                </div>
            </section>

            {/* ── ABOUT / STATS ────────────────────────────────────── */}
            <section className="home__about">
                <div className="home__container home__about-inner">
                    <div className="home__about-text">
                        <h2 className="home__about-title">
                            Vida Moderna para<br />
                            <span className="home__about-title--accent">Hogares Modernos</span>
                        </h2>
                        <p className="home__about-desc">
                            En Iquea creemos que el mobiliario es más que simples objetos funcionales.
                            Es una extensión de tu personalidad. Nuestros diseños se crean con precisión,
                            sostenibilidad y el estilo de vida moderno en mente.
                        </p>
                        <p className="home__about-desc">
                            Visita nuestra tienda insignia para experimentar la calidad de primera mano,
                            o explora nuestro catálogo digital desde la comodidad de tu hogar.
                        </p>
                        <div className="home__stats">
                            <div className="home__stat">
                                <span className="home__stat-num">15+</span>
                                <span className="home__stat-label">Años de experiencia</span>
                            </div>
                            <div className="home__stat">
                                <span className="home__stat-num">100%</span>
                                <span className="home__stat-label">Garantía de calidad</span>
                            </div>
                        </div>
                        <div className="home__about-socials">
                            <a href="https://instagram.com" target="_blank" rel="noreferrer" className="home__social-btn"><FiInstagram /></a>
                            <a href="https://facebook.com" target="_blank" rel="noreferrer" className="home__social-btn"><FiFacebook /></a>
                            <a href="https://pinterest.com" target="_blank" rel="noreferrer" className="home__social-btn"><FaPinterest /></a>
                        </div>
                    </div>

                    <div className="home__about-map">
                        <div className="home__map-wrap">
                            <iframe
                                title="Ubicación Iquea"
                                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3037.4!2d-3.7038!3d40.4168!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd422997800a3c81%3A0xc436dec1618c2269!2sMadrid%2C%20Spain!5e0!3m2!1sen!2ses!4v1700000000000"
                                width="100%"
                                height="100%"
                                style={{ border: 0 }}
                                allowFullScreen
                                loading="lazy"
                                referrerPolicy="no-referrer-when-downgrade"
                            />
                        </div>
                        <div className="home__store-card">
                            <FiMapPin className="home__store-icon" />
                            <div>
                                <p className="home__store-name">Tienda Principal</p>
                                <p className="home__store-addr">Calle del Mueble 42, Madrid, 28001</p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>



        </main>
    );
}
