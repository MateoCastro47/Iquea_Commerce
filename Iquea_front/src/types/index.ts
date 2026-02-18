
export interface LoginDTO {
    email: string;
    password: string;
}

export interface RegistroDTO {
    username: string;
    nombre: string;
    apellidos: string;
    email: { value: string };
    password: string;
    fecha_nacimiento: string; // "YYYY-MM-DD"
    direccion_envio?: string;
}

export interface TokenDTO {
    token: string;
}

export interface UsuarioDTO {
    usuario_id: number;
    username: string;
    nombre: string;
    apellidos: string;
    email: { value: string };
    fecha_nacimiento: string;
    direccion_envio?: string;
    activo: boolean;
    rol: 'ADMIN' | 'CLIENTE';
}


export interface CategoriaResumen {
    categoria_id: number;
    nombre: string;
    slug: string;
}


export interface Producto {
    producto_id: number;
    sku: string;
    nombre: string;
    descripcion: string;
    precioCantidad: number;
    precioMoneda: string;
    dimensionesAlto: number;
    dimensionesAncho: number;
    dimensionesProfundo: number;
    es_destacado: boolean;
    stock: number;
    imagen_url: string;
    categoria: CategoriaResumen;
}


export type EstadoPedido = 'PENDIENTE' | 'CONFIRMADO' | 'ENVIADO' | 'ENTREGADO' | 'CANCELADO';

export interface ProductoResumen {
    producto_id: number;
    nombre: string;
    precioCantidad: number;
    imagen_url: string;
}

export interface DetallePedido {
    detalle_id: number;
    producto: ProductoResumen;
    cantidad: number;
    precioUnitario: number;
    subtotal: number;
}

export interface Pedido {
    pedido_id: number;
    referencia: string;
    fecha_creacion: string;
    estado: EstadoPedido;
    total: number;
    detalles: DetallePedido[];
}


export interface CartItem {
    producto: Producto;
    cantidad: number;
}
