import { createContext, useContext, useState, useEffect, type ReactNode } from 'react';
import type { Producto, CartItem } from '../types';

interface CartContextType {
    cart: CartItem[];
    addToCart: (product: Producto, quantity: number) => void;
    removeFromCart: (productId: number) => void;
    updateQuantity: (productId: number, quantity: number) => void;
    clearCart: () => void;
    total: number;
    count: number;
}

const CartContext = createContext<CartContextType | undefined>(undefined);

export function CartProvider({ children }: { children: ReactNode }) {
    const [cart, setCart] = useState<CartItem[]>(() => {
        const saved = localStorage.getItem('cart');
        return saved ? JSON.parse(saved) : [];
    });

    useEffect(() => {
        localStorage.setItem('cart', JSON.stringify(cart));
    }, [cart]);

    const addToCart = (product: Producto, quantity: number) => {
        setCart((prev) => {
            const existing = prev.find((item) => item.producto.producto_id === product.producto_id);
            if (existing) {
                return prev.map((item) =>
                    item.producto.producto_id === product.producto_id
                        ? { ...item, cantidad: item.cantidad + quantity }
                        : item
                );
            }
            return [...prev, { producto: product, cantidad: quantity }];
        });
    };

    const removeFromCart = (productId: number) => {
        setCart((prev) => prev.filter((item) => item.producto.producto_id !== productId));
    };

    const updateQuantity = (productId: number, quantity: number) => {
        if (quantity <= 0) {
            removeFromCart(productId);
            return;
        }
        setCart((prev) =>
            prev.map((item) =>
                item.producto.producto_id === productId ? { ...item, cantidad: quantity } : item
            )
        );
    };

    const clearCart = () => setCart([]);

    const total = cart.reduce((sum, item) => sum + (item.producto.precioCantidad * item.cantidad), 0);
    const count = cart.reduce((sum, item) => sum + item.cantidad, 0);

    return (
        <CartContext.Provider value={{ cart, addToCart, removeFromCart, updateQuantity, clearCart, total, count }}>
            {children}
        </CartContext.Provider>
    );
}

export function useCart() {
    const context = useContext(CartContext);
    if (context === undefined) {
        throw new Error('useCart must be used within a CartProvider');
    }
    return context;
}
