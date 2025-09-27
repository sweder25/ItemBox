# ItemBox
# Objetivo del Proyecto

Este proyecto tiene como finalidad desarrollar un sistema de almacenamiento (storage) que permita consultar precios de objetos de forma dinámica y personalizada, orientado a campañas de rol como Dungeons & Dragons (D&D).

## Funcionalidades Principales

- **Consulta de precios**: Búsqueda por nombre, aplicación de filtros y visualización de características como:
  - Precio por región
  - Producción local
  - Tratados comerciales
  - Alianzas y proximidad geográfica

- **Gestión de datos**:
    - Modificación manual de tablas mediante una interfaz
    - Actualización automática y segura mediante la conexión directa a la base de datos Oracle SQL alojada en la nube

## Estructura de la Base de Datos

La base de datos se aloja en Oracle SQL, gestionada y alojada en la nube. Esta base de datos actúa como fuente principal de información y está protegida contra edición directa por parte de los jugadores.

- **Acceso de jugadores**:
    - Pueden visualizar y cotizar precios
    - No tienen permisos para editar o añadir datos directamente en la base de datos

- **Gestión de inventario**:
  - Los jugadores pueden administrar su inventario desde la app
  - Pueden realizar compras y ver:
    - Objetos adquiridos
    - Calidad
    - Descripción
    - Cantidad disponible

- **Gestión de dinero**:
  - Solo el DM (Dungeon Master) puede añadir o modificar el dinero de los jugadores
  - Los jugadores únicamente pueden gastar dinero al comprar objetos

## Integración con reglas de D&D

La aplicación respeta las reglas económicas del sistema de juego, permitiendo una experiencia coherente y automatizada para la gestión de recursos dentro de la campaña.

---

Este enfoque modular y accesible busca facilitar la administración de recursos en campañas de rol, manteniendo la integridad de los datos y ofreciendo una experiencia fluida tanto para el DM como para los jugadores.
