# ItemBox
# Objetivo del Proyecto

Este proyecto tiene como finalidad desarrollar un sistema de almacenamiento (storage) que permita consultar precios de objetos de forma dinámica y personalizada, orientado a campañas de rol como Dungeons & Dragons (D&D).

## Funcionalidades Principales

  - Consulta de precios 
  - Búsqueda por nombre
  - Aplicación de filtros y visualización de características como:
    - Precios por región según su distribución
    - Producción local
    - Tratados comerciales
    - Alianzas y proximidad geográfica

- **Gestión de datos**:
    - Modificación manual de tablas mediante una interfaz
    - Actualización automática y segura mediante la conexión directa a la base de datos Oracle SQL alojada en la nube

## Estructura de la Base de Datos

La base de datos se aloja en el dispositivo del DM. Esta base de datos actúa como fuente principal de información y está protegida contra edición directa por parte de los jugadores.

## Integración con reglas de D&D

La aplicación respeta las reglas económicas del sistema de juego, permitiendo una experiencia coherente y automatizada para la gestión de recursos dentro de la campaña.

## Planes a Futuro

Se planea desarrollar una aplicación móvil que permita a los DM (Dungeon Masters) y jugadores interactuar con la base de datos de manera sencilla y eficiente, alojando la base de datos en el dispositivo móvil del DM quien tendrá control total sobre la misma y actuara como servidor para los jugadores los cuales se uniran a la base de datos de la Campaña con un código de acceso, esto pensando en que de esta forma los jugadores podran gestionar su inventario, recursos y equipos de forma agil.

Se espera que los DM puedan gestionar multiples campañas y cada una contara con su propia base de datos independiente.

Los jugadores podran comprar y vender acorde a los precios establecidos en la base de datos y segun las reglas economicas del sistema de juego y el DM podra gestionar la economia de la campaña de forma sencilla, se añadira un apartado para la opcion de regatear precios segun los datos ingresados por el DM.

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
  - Los jugadores únicamente pueden gastar dinero al comprar objetos o vender objetos de su inventario

---

Este enfoque modular y accesible busca facilitar la administración de recursos en campañas de rol, manteniendo la integridad de los datos y ofreciendo una experiencia fluida tanto para el DM como para los jugadores.
