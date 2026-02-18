import { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import { getProducto } from '../api/productos';
import { useAuth } from '../context/AuthContext';
import { useCart } from '../context/CartContext';
import type { Producto } from '../types';
import './ProductDetail.css';

export default function ProductDetail() {
    const { id } = useParams<{ id: string }>();
    const { isAuthenticated } = useAuth();
    const { addToCart } = useCart();

    const [producto, setProducto] = useState<Producto | null>(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');
    const [qty, setQty] = useState(1);
    const [adding, setAdding] = useState(false);

    useEffect(() => {
        if (id) {
            setLoading(true);
            getProducto(Number(id))
                .then(setProducto)
                .catch((err) => {
                    console.error(err);
                    setError('No se pudo cargar el producto.');
                })
                .finally(() => setLoading(false));
        }
    }, [id]);

    const handleAddToCart = () => {
        if (producto) {
            setAdding(true);
            addToCart(producto, qty);
            setTimeout(() => setAdding(false), 500);
        }
    };

    if (loading) return <div className="text-center py-20">Cargando...</div>;
    if (error || !producto) return <div className="text-center py-20 text-red-500">{error || 'Producto no encontrado'}</div>;

    const stockAvailable = producto.stock > 0;
    const precio = producto.precioCantidad?.toFixed(2);

    return (
        <div className="product-detail-page">
            <div className="product-detail__img-wrap">
                <img
                    src={producto.imagen_url || 'https://placehold.co/600x400?text=Sin+imagen'}
                    alt={producto.nombre}
                    className="product-detail__img"
                />
            </div>

            <div className="product-detail__info">
                {producto.categoria && (
                    <span className="product-detail__cat">{producto.categoria.nombre}</span>
                )}
                <h1 className="product-detail__title">{producto.nombre}</h1>
                <p className="product-detail__price">
                    {precio} <small>{producto.precioMoneda}</small>
                </p>

                <div className="product-detail__desc">
                    <p>{producto.descripcion || 'Sin descripción disponible.'}</p>
                </div>

                <div className="product-meta">
                    <div className="product-meta-item">
                        <span>SKU:</span>
                        <span>{producto.sku || 'N/A'}</span>
                    </div>

                    {(producto.dimensionesAlto > 0 || producto.dimensionesAncho > 0) && (
                        <div className="product-meta-item">
                            <span>Dimensiones:</span>
                            <span>{producto.dimensionesAlto}x{producto.dimensionesAncho}x{producto.dimensionesProfundo} cm</span>
                        </div>
                    )}
                    <div className="product-meta-item">
                        <span>Stock:</span>
                        <span>{producto.stock} unidades</span>
                    </div>
                </div>

                {stockAvailable ? (
                    isAuthenticated ? (
                        <div className="product-detail__actions">
                            <input
                                type="number"
                                min="1"
                                max={producto.stock}
                                value={qty}
                                onChange={(e) => setQty(Number(e.target.value))}
                                className="product-qty-input"
                            />
                            <button
                                className="add-to-cart-btn"
                                onClick={handleAddToCart}
                                disabled={adding}
                            >
                                {adding ? '¡Añadido!' : 'Añadir al Carrito'}
                            </button>
                        </div>
                    ) : (
                        <div className="mb-8">
                            <p className="mb-4 text-gray-600">Inicia sesión para comprar este producto.</p>
                            <Link to="/login" className="login-redirect-btn">
                                Iniciar Sesión para Comprar
                            </Link>
                        </div>
                    )
                ) : (
                    <div className="text-red-500 font-bold mb-8 text-xl">Agotado</div>
                )}
            </div>
        </div>
    );
}
