

-- Categorías de muebles
INSERT IGNORE INTO categorias (categoria_id, nombre, Slug) VALUES
(1, 'Salón',        'salon'),
(2, 'Dormitorio',   'dormitorio'),
(3, 'Cocina',       'cocina'),
(4, 'Baño',         'bano'),
(5, 'Oficina',      'oficina'),
(6, 'Exterior',     'exterior');

-- Productos
INSERT IGNORE INTO Producto (producto_id, categoria_id, nombre, sku, Cantidad, Moneda, es_destacado, Alto, Ancho, Profundidad, descripcion, stock, imagen_url) VALUES

-- Salón
(1,  1, 'Sofá de 3 plazas Oslo',          'SAL-001', 799.99,  'EUR', true,  0.85, 2.20, 0.95, 'Sofá escandinavo de 3 plazas tapizado en tela gris. Patas de madera maciza de roble. Ideal para salones modernos.', 10, 'https://placehold.co/400x300?text=Sofa+Oslo'),
(2,  1, 'Mesa de Centro Nórdica',          'SAL-002', 229.99,  'EUR', false, 0.45, 1.10, 0.60, 'Mesa de centro rectangular en madera de pino natural con estante inferior. Estilo nórdico minimalista.', 15, 'https://placehold.co/400x300?text=Mesa+Centro'),
(3,  1, 'Estantería Modular Cubic',        'SAL-003', 349.99,  'EUR', true,  1.80, 0.90, 0.30, 'Estantería modular de 6 cubos en blanco mate. Perfecta para organizar libros, plantas y decoración.', 20, 'https://placehold.co/400x300?text=Estanteria+Cubic'),
(4,  1, 'Televisor Mueble Roble',          'SAL-004', 459.99,  'EUR', false, 0.55, 1.60, 0.40, 'Mueble TV de madera de roble con 2 cajones y puertas correderas. Capacidad para pantallas de hasta 65".', 8,  'https://placehold.co/400x300?text=Mueble+TV'),

-- Dormitorio
(5,  2, 'Cama Matrimonial Zen 150x200',    'DOR-001', 649.99,  'EUR', true,  0.90, 1.60, 2.10, 'Cama de matrimonio con cabecero tapizado en terciopelo gris. Base de lamas incluida. 150x200 cm.', 12, 'https://placehold.co/400x300?text=Cama+Zen'),
(6,  2, 'Armario 3 Puertas Correderas',    'DOR-002', 899.99,  'EUR', true,  2.20, 1.80, 0.62, 'Armario de 3 puertas correderas con espejo central. Interior con barras y estantes regulables.', 6,  'https://placehold.co/400x300?text=Armario+3P'),
(7,  2, 'Mesita de Noche Flotante',        'DOR-003', 119.99,  'EUR', false, 0.30, 0.45, 0.30, 'Mesita de noche suspendida en madera de nogal. Incluye un cajón y un estante abierto.', 25, 'https://placehold.co/400x300?text=Mesita+Noche'),
(8,  2, 'Cómoda 6 Cajones Vintage',        'DOR-004', 379.99,  'EUR', false, 0.95, 1.00, 0.45, 'Cómoda de 6 cajones en madera maciza con acabado vintage blanco roto. Tiradores dorados.', 14, 'https://placehold.co/400x300?text=Comoda+Vintage'),

-- Cocina
(9,  3, 'Taburete de Bar Alto Acero',      'COC-001', 89.99,   'EUR', false, 1.05, 0.40, 0.40, 'Taburete de bar con asiento acolchado en polipiel negra y estructura de acero inoxidable. Altura regulable.', 30, 'https://placehold.co/400x300?text=Taburete+Bar'),
(10, 3, 'Mesa de Cocina Extensible',       'COC-002', 299.99,  'EUR', true,  0.76, 1.20, 0.80, 'Mesa de cocina extensible de 120 a 180 cm. Tablero de melamina blanca y patas de acero. Hasta 6 comensales.', 18, 'https://placehold.co/400x300?text=Mesa+Extensible'),

-- Baño
(11, 4, 'Mueble de Baño Suspendido 80cm',  'BAN-001', 349.99,  'EUR', false, 0.50, 0.80, 0.46, 'Mueble de baño suspendido con lavabo integrado y 2 cajones de cierre suave. Acabado en blanco brillo.', 10, 'https://placehold.co/400x300?text=Mueble+Bano'),
(12, 4, 'Espejo con Luz LED 60x80',        'BAN-002', 149.99,  'EUR', false, 0.80, 0.60, 0.04, 'Espejo de baño con iluminación LED perimetral y función antivaho. Interruptor táctil.', 22, 'https://placehold.co/400x300?text=Espejo+LED'),

-- Oficina
(13, 5, 'Escritorio Esquinero Gris',       'OFI-001', 279.99,  'EUR', true,  0.75, 1.60, 1.10, 'Escritorio en L con amplia superficie de trabajo. Incluye soporte para monitor y gestión de cables.', 15, 'https://placehold.co/400x300?text=Escritorio+L'),
(14, 5, 'Silla Ergonómica Pro',            'OFI-002', 399.99,  'EUR', true,  1.20, 0.65, 0.65, 'Silla de oficina ergonómica con soporte lumbar ajustable, reposabrazos 4D y asiento de malla transpirable.', 20, 'https://placehold.co/400x300?text=Silla+Ergonomica'),
(15, 5, 'Cajonera Rodante 3 Cajones',      'OFI-003', 129.99,  'EUR', false, 0.60, 0.40, 0.50, 'Cajonera con ruedas para escritorio. 3 cajones con cierre de llave. Compatible con la mayoría de escritorios.', 28, 'https://placehold.co/400x300?text=Cajonera'),

-- Exterior
(16, 6, 'Mesa de Jardín Ratán 6 Sillas',   'EXT-001', 699.99,  'EUR', true,  0.75, 1.80, 0.90, 'Conjunto de jardín en ratán sintético con mesa y 6 sillas. Incluye cojines impermeables en color crema.', 5,  'https://placehold.co/400x300?text=Mesa+Jardin'),
(17, 6, 'Tumbona Plegable Aluminio',       'EXT-002', 149.99,  'EUR', false, 0.35, 0.65, 1.90, 'Tumbona reclinable de aluminio con textileno de secado rápido. Ligera y resistente a la intemperie.', 20, 'https://placehold.co/400x300?text=Tumbona');
