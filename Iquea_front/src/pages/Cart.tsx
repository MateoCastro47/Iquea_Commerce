import { Link, useNavigate } from 'react-router-dom';
import { useCart } from '../context/CartContext';
import { useAuth } from '../context/AuthContext';
import { useEffect } from 'react';
import './Cart.css';

export default function Cart() {
    const { cart, updateQuantity, removeFromCart, total, clearCart } = useCart();
    const { isAuthenticated } = useAuth();
    const navigate = useNavigate();

    useEffect(() => {
        if (!isAuthenticated) {
            navigate('/login');
        }
    }, [isAuthenticated, navigate]);

    if (!isAuthenticated) return null;

    if (cart.length === 0) {
        return (
            <div className="cart-page">
                <div className="cart-empty">
                    <p>Tu carrito está vacío</p>
                    <Link to="/productos" className="continue-shopping-btn">
                        Ver Productos
                    </Link>
                </div>
            </div>
        );
    }

    const handleCheckout = () => {
        alert('¡Gracias por tu compra! (Funcionalidad de pago mock)');
        clearCart();
        navigate('/');
    };

    return (
        <div className="cart-page">
            <h1 className="cart-title">Tu Carrito de Compras</h1>

            <div className="cart-grid">
                <div className="cart-items">
                    {cart.map((item) => (
                        <div key={item.producto.producto_id} className="cart-item">
                            <img
                                src={item.producto.imagen_url || 'https://placehold.co/100?text=Sin+imagen'}
                                alt={item.producto.nombre}
                                className="cart-item__img"
                            />

                            <div className="cart-item__info">
                                <h3>{item.producto.nombre}</h3>
                                {item.producto.categoria && (
                                    <span className="cart-item__cat">{item.producto.categoria.nombre}</span>
                                )}
                            </div>

                            <div className="cart-item__qty">
                                <button
                                    className="cart-qty-btn"
                                    onClick={() => updateQuantity(item.producto.producto_id, item.cantidad - 1)}
                                >-</button>
                                <span className="cart-qty-val">{item.cantidad}</span>
                                <button
                                    className="cart-qty-btn"
                                    onClick={() => updateQuantity(item.producto.producto_id, item.cantidad + 1)}
                                >+</button>
                            </div>

                            <div className="text-right">
                                <div className="cart-item__price">
                                    {(item.producto.precioCantidad * item.cantidad).toFixed(2)} {item.producto.precioMoneda}
                                </div>
                                <button
                                    className="cart-item__remove"
                                    onClick={() => {
                                        if (window.confirm('¿Seguro que quieres eliminar este producto?')) {
                                            removeFromCart(item.producto.producto_id);
                                        }
                                    }}
                                >
                                    Eliminar
                                </button>
                            </div>
                        </div>
                    ))}
                </div>

                <div className="cart-summary">
                    <h3>Resumen del Pedido</h3>
                    <div className="cart-summary__row">
                        <span>Subtotal</span>
                        <span>{total.toFixed(2)} €</span>
                    </div>
                    <div className="cart-summary__row">
                        <span>Envío</span>
                        <span>Gratis</span>
                    </div>
                    <div className="cart-summary__row cart-summary__row--total">
                        <span>Total</span>
                        <span>{total.toFixed(2)} €</span>
                    </div>

                    <button className="checkout-btn" onClick={handleCheckout}>
                        Tramitar Pedido
                    </button>
                </div>
            </div>
        </div>
    );
}
