import { Link } from 'react-router-dom';
import type { Producto } from '../types';
import './ProductoCard.css';

interface Props {
    producto: Producto;
}

export default function ProductoCard({ producto }: Props) {
    const precio = producto.precioCantidad?.toFixed(2) ?? '—';

    return (
        <Link to={`/productos/${producto.producto_id}`} className="producto-card">
            <div className="producto-card__img-wrap">
                <img
                    src={producto.imagen_url || 'https://placehold.co/400x300?text=Sin+imagen'}
                    alt={producto.nombre}
                    className="producto-card__img"
                    loading="lazy"
                />
                {producto.es_destacado && (
                    <span className="producto-card__badge">Destacado</span>
                )}
                {producto.stock === 0 && (
                    <span className="producto-card__badge producto-card__badge--agotado">Agotado</span>
                )}
            </div>

            <div className="producto-card__body">
                {producto.categoria && (
                    <span className="producto-card__categoria">{producto.categoria.nombre}</span>
                )}
                <h3 className="producto-card__nombre">{producto.nombre}</h3>
                <p className="producto-card__precio">
                    {precio} <span className="producto-card__moneda">{producto.precioMoneda}</span>
                </p>
            </div>
        </Link>
    );
}
