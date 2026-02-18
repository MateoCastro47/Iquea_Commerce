
## 🏗️ Arquitectura del Sistema

La aplicación sigue una arquitectura desacoplada de Cliente-Servidor:

*   **Frontend**: Una aplicación de página única (SPA) dinámica construida con **React** y **Vite**.
*   **Backend**: Una API RESTful potente construida con **Spring Boot 3**, que gestiona la lógica de negocio y la persistencia de datos.
*   **Base de Datos**: Sistema de gestión de bases de datos relacionales **MySQL** para el almacenamiento seguro de información.

---

## 🛠️ Tecnologías Utilizadas

| Componente | Tecnología | Versión Recomendada |
| :--- | :--- | :--- |
| **Backend** | Java | 21 (LTS) |
| **Framework** | Spring Boot | 3.4.0 |
| **Seguridad** | Spring Security + JWT | 0.12.6 |
| **Persistencia** | Spring Data JPA / Hibernate | - |
| **Base de Datos** | MySQL | 8.0+ |
| **Frontend** | React | 19.x |
| **Bundler** | Vite | 7.x |
| **Lenguaje** | TypeScript | 5.x |
| **Estilos** | CSS Puro | - |

---

## 📋 Requisitos Previos

Antes de comenzar, asegúrate de tener instaladas las siguientes herramientas en tu sistema:

1.  **Java Development Kit (JDK) 21**: Imprescindible para ejecutar el backend. [Descargar JDK 21](https://adoptium.net/temurin/releases/?version=21).
2.  **Node.js (v18.0 o superior)**: Necesario para el entorno de ejecución del frontend. [Descargar Node.js](https://nodejs.org/).
3.  **MySQL Server 8.0+**: Para la gestión de la base de datos. [Descargar MySQL](https://dev.mysql.com/downloads/installer/).
4.  **Git**: Para clonar el repositorio (opcional si ya tienes el código). [Descargar Git](https://git-scm.com/).

---

## 🚀 Guía de Instalación Paso a Paso

### 1. Configuración de la Base de Datos

El sistema está configurado para crear la base de datos automáticamente si no existe, pero se recomienda realizar los siguientes pasos en tu cliente MySQL (Workbench, línea de comandos, etc.):

1.  Conéctate a tu servidor MySQL.
2.  Ejecuta el siguiente comando para crear la base de datos:
    ```sql
    CREATE DATABASE IF NOT EXISTS apiIquea CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
    ```
3.  Asegúrate de tener un usuario con permisos suficientes (preferiblemente `root` para desarrollo inicial).

### 2. Configuración y Arranque del Backend

1.  Navega a la carpeta del backend:
    ```bash
    cd Iqüea_back
    ```
2.  **Configuración de Credenciales**:
    El backend utiliza variables de entorno para las credenciales de la base de datos. Tienes dos opciones:
    *   **Opción A (Recomendada)**: Configura las variables de entorno en tu sistema o IDE:
        *   `DB_USERNAME`: Tu usuario de MySQL (por defecto `root`).
        *   `DB_PASSWORD`: Tu contraseña de MySQL.
    *   **Opción B**: Editar el archivo `src/main/resources/application.properties` y modificar `spring.datasource.username` y `spring.datasource.password`.

3.  **Lanzar la Aplicación**:
    Utiliza el Maven Wrapper incluido para compilar y ejecutar el proyecto:
    ```bash
    # En Windows
    .\mvnw.cmd spring-boot:run

    # En Linux/macOS
    ./mvnw spring-boot:run
    ```
    > [!NOTE]
    > Al arrancar por primera vez, el sistema creará las tablas automáticamente e insertará datos iniciales desde el archivo `src/main/resources/data.sql`.

4.  El servidor estará disponible en: **http://localhost:8080**

### 3. Configuración y Arranque del Frontend

1.  Abre una nueva terminal y navega a la carpeta del frontend:
    ```bash
    cd Iquea_front
    ```
2.  **Instalar Dependencias**:
    Ejecuta el gestor de paquetes de Node para descargar todas las librerías necesarias:
    ```bash
    npm install
    ```
3.  **Iniciar el Servidor de Desarrollo**:
    Lanza la aplicación en modo desarrollo:
    ```bash
    npm run dev
    ```
4.  La aplicación se abrirá por defecto en: **http://localhost:5173**

---

## 👤 Acceso de Usuarios (Datos de Prueba)

Puedes probar las funcionalidades del sistema con las siguientes cuentas preconfiguradas:

| Usuario | Contraseña | Rol / Permisos |
| :--- | :--- | :--- |
| `admin` | `password123` | **Administrador** (Gestión de productos y categorías) |
| `maria123` | `password123` | **Cliente** (Compra y gestión de pedidos) |
| `carlos99` | `password123` | **Cliente** (Compra y gestión de pedidos) |

---

## 🔍 Endpoints Principales de la API

La API REST está estructurada bajo el prefijo `/api`. Aquí algunos de los endpoints más relevantes:

*   **Públicos**:
    *   `POST /api/auth/login`: Autenticación y obtención de token JWT.
    *   `POST /api/auth/registro`: Registro de nuevos clientes.
    *   `GET /api/productos`: Listado completo de artículos.
    *   `GET /api/productos/buscar?nombre=...`: Buscador funcional.
*   **Protegidos (Requiere Cabecera Authorization)**:
    *   `POST /api/pedidos`: Creación de una nueva orden de compra.
    *   `GET /api/pedidos/mis-pedidos`: Historial de compras del usuario.
    *   `POST /api/productos`: (Solo Admin) Creación de nuevos productos.

---

## 🛠️ Solución de Problemas (Troubleshooting)

*   **Error de conexión a la base de datos**: Verifica que el servicio MySQL esté activo y que las credenciales en `application.properties` o variables de entorno sean correctas.
*   **Errores de CORS**: El backend está configurado para aceptar peticiones desde `http://localhost:5173`. Si usas otro puerto, deberás actualizar la configuración en `SecurityConfig.java`.
*   **Problemas con Node.js**: Asegúrate de estar usando una versión par de Node (18 o 20) para evitar incompatibilidades. Puedes usar `node -v` para verificarlo.
*   **Maven no compila**: Si tienes errores de compilación, intenta limpiar el proyecto con `.\mvnw.cmd clean`.

---

## 📝 Notas de Desarrollo

*   **MapStruct**: Se utiliza para el mapeo dinámico entre Entidades y DTOs. Si haces cambios en los mappers, asegúrate de recompilar para que se generen las implementaciones.
*   **Lombok**: El backend usa Lombok para reducir el código boilerplate. Asegúrate de tener instalado el plugin de Lombok en tu IDE (IntelliJ, VS Code, etc.).

---

