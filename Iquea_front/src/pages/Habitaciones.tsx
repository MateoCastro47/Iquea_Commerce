import { Link } from 'react-router-dom';
import './Habitaciones.css';

const ROOMS = [
    {
        id: 'salon',
        name: 'Salón',
        image: 'https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=600&q=80',
        description: 'Espacios acogedores para compartir y relajarse.'
    },
    {
        id: 'comedor',
        name: 'Comedor',
        image: 'https://images.unsplash.com/photo-1617806118233-18e1de247200?w=600&q=80',
        description: 'Donde las mejores conversaciones tienen lugar.'
    },
    {
        id: 'dormitorio',
        name: 'Dormitorio',
        image: 'https://images.unsplash.com/photo-1505693416388-b034631ac0f3?w=600&q=80',
        description: 'Tu santuario personal de descanso.'
    },
    {
        id: 'cocina',
        name: 'Cocina',
        image: 'https://images.unsplash.com/photo-1556911220-e15b29be8c8f?w=600&q=80',
        description: 'El corazón del hogar, funcional y elegante.'
    },
    {
        id: 'bano',
        name: 'Baño',
        image: 'https://images.unsplash.com/photo-1552321554-5fefe8c9ef14?w=600&q=80',
        description: 'Organización y estilo para tu aseo diario.'
    },
    {
        id: 'oficina',
        name: 'Oficina',
        image: 'https://images.unsplash.com/photo-1524758631624-e2822e304c36?w=600&q=80',
        description: 'Productividad y confort para trabajar en casa.'
    }
];

export default function Habitaciones() {
    return (
        <div className="habitaciones-page">
            <header className="habitaciones-header">
                <div className="habitaciones-header__content">
                    <h1 className="habitaciones-title">Inspírate por Habitaciones</h1>
                    <p className="habitaciones-subtitle">
                        Encuentra la combinación perfecta para cada rincón de tu hogar.
                    </p>
                </div>
            </header>

            <section className="habitaciones-grid">
                {ROOMS.map((room) => (
                    <Link to={`/productos?q=${room.id}`} key={room.id} className="habitaciones-card">
                        <div className="habitaciones-card__img-wrap">
                            <img
                                src={room.image}
                                alt={room.name}
                                className="habitaciones-card__img"
                                loading="lazy"
                            />
                            <div className="habitaciones-card__overlay">
                                <span className="habitaciones-card__btn">Ver Productos</span>
                            </div>
                        </div>
                        <div className="habitaciones-card__info">
                            <h2 className="habitaciones-card__title">{room.name}</h2>
                            <p className="habitaciones-card__desc">{room.description}</p>
                        </div>
                    </Link>
                ))}
            </section>
        </div>
    );
}
