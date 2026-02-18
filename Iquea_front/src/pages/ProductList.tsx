import { useState, useEffect, useMemo } from 'react';
import { useSearchParams } from 'react-router-dom';
import { getProductos, buscarProductos } from '../api/productos';
import { getCategorias } from '../api/categorias';
import type { Producto, CategoriaResumen } from '../types';
import ProductoCard from '../components/ProductoCard';
import './ProductList.css';

export default function ProductList() {
    const [searchParams, setSearchParams] = useSearchParams();
    const query = searchParams.get('q') || '';

    const [productos, setProductos] = useState<Producto[]>([]);
    const [categorias, setCategorias] = useState<CategoriaResumen[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');

    // Filters state
    const [selectedCategory, setSelectedCategory] = useState<number | null>(null);
    const [priceRange, setPriceRange] = useState<{ min: number; max: number }>({ min: 0, max: 10000 });

    // Initial load
    useEffect(() => {
        setLoading(true);
        setError('');

        const fetchProducts = query ? buscarProductos(query) : getProductos();
        const fetchCats = getCategorias();

        Promise.all([fetchProducts, fetchCats])
            .then(([prodsData, catsData]) => {
                setProductos(prodsData);
                setCategorias(catsData);
            })
            .catch((err) => {
                console.error(err);
                setError('Error al cargar los productos. Inténtalo de nuevo.');
            })
            .finally(() => setLoading(false));
    }, [query]);

    // Client-side filtering
    const filteredProducts = useMemo(() => {
        return productos.filter((p) => {
            // Category filter
            if (selectedCategory && p.categoria?.categoria_id !== selectedCategory) {
                return false;
            }
            // Price filter
            const precio = p.precioCantidad || 0;
            if (precio < priceRange.min || precio > priceRange.max) {
                return false;
            }
            return true;
        });
    }, [productos, selectedCategory, priceRange]);

    const handleCategoryClick = (catId: number | null) => {
        setSelectedCategory(catId);
    };

    return (
        <div className="product-list-page">
            {/* Sidebar Filters */}
            <aside className="filters-sidebar">
                <h3 className="filters-title">Filtros</h3>

                <div className="filter-group">
                    <label>Categorías</label>
                    <button
                        className={`filter-category-btn ${selectedCategory === null ? 'active' : ''}`}
                        onClick={() => handleCategoryClick(null)}
                    >
                        Todas
                    </button>
                    {categorias.map((cat) => (
                        <button
                            key={cat.categoria_id}
                            className={`filter-category-btn ${selectedCategory === cat.categoria_id ? 'active' : ''}`}
                            onClick={() => handleCategoryClick(cat.categoria_id)}
                        >
                            {cat.nombre}
                        </button>
                    ))}
                </div>

                <div className="filter-group">
                    <label>Precio (€)</label>
                    <div className="price-inputs">
                        <input
                            type="number"
                            className="price-input"
                            placeholder="Min"
                            value={priceRange.min}
                            onChange={(e) => setPriceRange(prev => ({ ...prev, min: Number(e.target.value) }))}
                        />
                        <span>-</span>
                        <input
                            type="number"
                            className="price-input"
                            placeholder="Max"
                            value={priceRange.max}
                            onChange={(e) => setPriceRange(prev => ({ ...prev, max: Number(e.target.value) }))}
                        />
                    </div>
                </div>
            </aside>

            {/* Main Content */}
            <div className="product-list-content">
                <div className="flex justify-between items-center mb-6">
                    <h1 className="text-2xl font-bold">
                        {query ? `Resultados para "${query}"` : 'Colección de Productos'}
                    </h1>
                    <span className="text-gray-500">{filteredProducts.length} productos</span>
                </div>

                {loading ? (
                    <div className="text-center py-10">Cargando productos...</div>
                ) : error ? (
                    <div className="text-red-500 text-center py-10">{error}</div>
                ) : filteredProducts.length === 0 ? (
                    <div className="no-results">
                        <p>No se encontraron productos que coincidan con tu búsqueda.</p>
                        <button
                            className="mt-4 text-blue-600 underline"
                            onClick={() => {
                                setSelectedCategory(null);
                                setPriceRange({ min: 0, max: 10000 });
                                setSearchParams({});
                            }}
                        >
                            Limpiar filtros
                        </button>
                    </div>
                ) : (
                    <div className="products-grid">
                        {filteredProducts.map((p) => (
                            <ProductoCard key={p.producto_id} producto={p} />
                        ))}
                    </div>
                )}
            </div>
        </div>
    );
}
