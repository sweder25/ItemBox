# Documentación técnica de la carpeta `itembox`

Última actualización: 2025-11-02

Este documento describe de forma estructurada y formal el contenido del paquete `com.mij.itembox` (carpeta `app/src/main/java/com/mij/itembox`) del proyecto ItemBox. Contiene la arquitectura, los modelos de datos, DAOs, repositorios, viewmodels, pantallas y flujos principales, así como instrucciones de ejecución, contratos y recomendaciones.

## Índice

- Estructura de carpetas y responsabilidades
- Base de datos (Room)
- Modelos de datos
- DAOs (Data Access Objects)
- Repositorios
- ViewModels y fábricas
- UI y navegación
- Flujo de compra (Tienda)
- Casos de error conocidos y notas de migración
- Cómo ejecutar la aplicación localmente
- Recomendaciones y siguientes pasos



## Estructura de carpetas y responsabilidades

Raíz del paquete: `app/src/main/java/com/mij/itembox`

- `MainActivity.kt` — Punto de entrada de la UI; contiene la configuración del Theme, NavHost y rutas de la aplicación.
- `data/` — Contiene todo lo relacionado con persistencia y modelos:
	- `AppDatabase.kt` — Configuración de Room y listado de entidades.
	- `dao/` — Interfaces DAO expositoras de consultas SQL para Room.
	- `model/` — Entidades anotadas con `@Entity` usadas por Room.
	- `dataclass/` — Clases de datos auxiliares (por ejemplo, `ProductoConCantidad`).
	- `repository/` — Implementaciones que exponen operaciones de alto nivel sobre los DAOs.
	- `viewmodel/` — ViewModels y fábricas para inyección en Compose.
- `ui/` — Contiene componentes de UI con Jetpack Compose:
	- `page/` — Pantallas principales y subcomponentes (por ejemplo, `Perfil`, `Tienda`, `VerProductos`).
	- `composables/` — Componentes reusables como `ProductoConDetalles`.
	- `theme/` — Temas, colores y tipografías.
- `util/` y `functions/` — utilidades de ayuda (por ejemplo, manejo de imágenes).

## Base de datos (Room)

Archivo: `AppDatabase.kt`

- Entidades registradas: `Producto`, `Inventario`, `Stock`, `Animal`, `Vegetal`, `Mineral`, `Elaborado`, `ProductoAnimal`.
- Versión actual: 3 .
- Configuración: `fallbackToDestructiveMigration()` activado. Esto implica que, si existe un desajuste de esquema entre la versión de la DB en el dispositivo y la versión codificada, Room recreará la base de datos (pérdida de datos locales posibles).

Identidad del esquema
- Si al abrir la base de datos aparece una excepción de identidad de esquema (p.ej. `Room cannot verify the data integrity`), la subida de versión y la opción de fallback mitigan el cierre de la app, pero implican recreación de la BD. Si se requieren migraciones conservadoras, hay que implementar migraciones explícitas en `Room.databaseBuilder(...).addMigrations(...)`.

## Modelos de datos

Se describen las entidades principales y sus campos relevantes.

- `Producto` (`app/src/main/java/.../data/model/Producto.kt`)
	- `id_producto: Long` (PrimaryKey, autoGenerate)
	- `nombre: String`
	- `tipo: String` ( categoría/ tipo de producto )
	- `precio: Double`
	- `imagenPath: String?` (ruta local opcional)

- `Inventario` (`data/model/Inventario.kt`)
	- `id_inventario: Long` (PrimaryKey, autoGenerate)
	- `nombre: String`
	- `dinero: Double` (saldo disponible)

- `Stock` (`data/model/Stock.kt`)
	- `id_stock: Long` (PrimaryKey, autoGenerate)
	- `id_inventario: Long` (FK a `Inventario`)
	- `id_producto: Long` (FK a `Producto`)
	- `cantidad: Int`

Además hay entidades específicas para productos por tipo en `data/model/productos/` (Animal, Vegetal, Mineral, Elaborado, ProductoAnimal). Estas amplían la información por tipo y son consultadas desde los composables específicos.

## DAOs (Data Access Objects)

Los DAOs exponen consultas SQL y son inyectados en los repositorios.

- `ProductoDao` — métodos principales: `getAll()`, `getById()`, `insert()`, `delete()`, `getPorTipo(tipo)` y `getProductoFlow(id)`.
- `InventarioDao` — métodos principales:
	- `getAll(): Flow<List<Inventario>>` — devuelve inventarios ordenados por `id_inventario DESC`.
	- `insert(inventario: Inventario)` (suspend)
	- `delete(inventario: Inventario)` (suspend)
	- `actualizarDinero(idInventario: Long, nuevoMonto: Double)` (suspend)
	- `getById(id: Long): Flow<Inventario>` — flujo de un inventario.
	- `getByIdSuspend(id: Long): Inventario` — recupera directamente (suspend). IMPORTANTE: esta función devuelve `Inventario` no-null; si la fila no existe Room lanzará excepción. Manejar con cuidado.
- `StockDao` — métodos relevantes:
	- `insertarStock(stock: Stock)` (suspend)
	- `obtenerStockPorInventario(inventarioId: Long): Flow<List<Stock>>`
	- `obtenerStockDeProducto(inventarioId: Long, productoId: Long): Stock?` (suspend)
	- `actualizarCantidad(stockId: Long, nuevaCantidad: Int)` (suspend)
	- `getProductosConCantidad(inventarioId: Long): List<ProductoConCantidad>` — JOIN con `productos` para devolver nombre y cantidad.

Observaciones: en varios lugares la API usa versiones `Flow` y `suspend` para operaciones de lectura/escritura; los `suspend` se llaman desde `viewModelScope.launch` o contextos de coroutine.

## Repositorios

Los repositorios encapsulan operaciones complejas usando los DAOs.

- `ProductoRepository` — expone `allProducto: Flow<List<Producto>>`, `getProductoDirecto(id)`, `updateImagenPath`, `insertYRetornaId`, `getPorTipo`.
- `InventarioRepository` — expone `allItems: Flow<List<Inventario>>`, `insert`, `delete`, `actualizarDinero`, `getInventario(id): Flow<Inventario>`, `descontarDinero(id, monto)` (usa `getByIdSuspend` internamente y actualiza dinero), `getByIdSuspend`.
- `StockRepository` — expone `getStockPorInventario`, `getStockDeProducto`, `insertarStock`, `actualizarCantidad`, `eliminarStock`, `agregarProductoAlInventario` (incrementa si existe o inserta nuevo), `realizarVenta` (valida cantidad y dinero, actualiza stock y dinero), `getProductosConCantidad`.

El repositorio `InventarioOperaciones.kt` contiene operaciones compuestas de negocio si existen (recomendar revisar este archivo para operaciones atomizadas adicionales).

## ViewModels y fábricas

- `ProductoViewModel` — expone `allProducto: Flow<List<Producto>>`, funciones de inserción, actualización de imagen y métodos de utilidad que llaman al repositorio desde `viewModelScope`.
- `StockViewModel` — expone funciones para agregar producto, actualizar cantidad, eliminar y obtener stock por inventario (flujo). También proporciona un método suspend `getStockDirecto`.
- `InventarioViewModel` — expone `allItems: Flow<List<Inventario>>`, `insert`, `delete`, `getInventario(id): Flow<Inventario>`, `getInventarioDirecto(id): Inventario` (suspend) y `actualizarDinero`. Además `getProductosConCantidad(inventarioId, onResult)` que ejecuta la consulta de `StockRepository` dentro de `viewModelScope.launch` y pasa el resultado al callback.

Fábricas (`Fabricadores`) existen para permitir la creación de ViewModels con parámetros en Compose:
- `ProductoViewModelFabricador` — crea `ProductoViewModel(application)`.
- `InventarioViewModelFabricador` — crea `InventarioViewModel(application, stockRepository)` utlizando la base de datos.

Nota crítica: Algunos métodos del repositorio devuelven entidades no-null en operaciones suspendidas (`getByIdSuspend`). Si el ID no existe, Room lanzará una excepción; las llamadas deben controlarse o cambiar la firma a nullable si se desea robustez.

## UI y navegación

El archivo `MainActivity.kt` configura la navegación (NavHost) y registra rutas principales:

- Rutas relevantes:
	- `home` → `HomePage()`
	- `perfil` → `PerfilPage(...)` (se pasa la lambda `onIrAComprar` que navega a `Tienda/{inventarioId}` o `CrearInventario` si no hay inventario activo)
	- `ajustes` → `AjustesPage()`
	- `CrearProducto` y `CrearProductoPaso2/{id}/{tipo}` → flujo para crear productos
	- `verProductos` → `VerProductos(...)` (lista y filtro por ID)
	- `CrearInventario` → `CrearInventarioPage(...)`
	- `VerInventarios` → `VerInventarioPage(...)`
	- `Tienda/{inventarioId}` → `TiendaPage(inventarioId)`

Pantallas claves

- `PerfilPage` (`ui/page/Perfil.kt`)
	- Lista inventarios (Card por inventario).
	- Tap simple: selecciona/expande los detalles del inventario (muestra productos con cantidades).
	- Doble tap: marca/desmarca el inventario como activo para operaciones.
	- Botón `Ir a comprar`: navega a `Tienda` con el inventario activo; si no hay inventario activo navega a `CrearInventario`.

- `VerProductos` (`ui/page/menuopciones/VerProductos.kt`)
	- Busca por ID (campo numérico). Muestra listado con `ProductoConDetalles`.

- `Tienda` (`ui/page/menuopciones/Tienda.kt`)
	- Campo de búsqueda por ID (reutiliza la fuente de `ProductoViewModel.allProducto`).
	- Por cada producto: contador `cantidad` con botones `-` y `+` y botón `Comprar`.
	- Lógica de compra: valida cantidad > 0, verifica inventario y saldo, usa `StockRepository.agregarProductoAlInventario` y `InventarioRepository.descontarDinero`. Tras compra exitosa el contador se resetea a 0. Mensajes de estado se muestran en la pantalla.

## Flujo de compra (resumen técnico)

Contrato y pasos (Comprar producto desde Tienda)

Inputs:
- `inventarioId: Long` (ID del inventario activo)
- `producto.id_producto: Long` (ID del producto a comprar)
- `cantidad: Int` (> 0)

Proceso (en `Tienda`):
1. El usuario fija `cantidad` y pulsa `Comprar`.
2. UI lanza una coroutine que:
	 - Recupera el inventario con `inventarioRepo.getByIdSuspend(inventarioId)` (suspend).
	 - Calcula `total = producto.precio * cantidad`.
	 - Si `inventario.dinero < total` → aborta y muestra "Dinero insuficiente".
	 - Llama `stockRepo.agregarProductoAlInventario(inventarioId, producto.id_producto, cantidad)` (suspend).
	 - Llama `inventarioRepo.descontarDinero(inventarioId, total)` (suspend) — este método usa `getByIdSuspend` y `actualizarDinero` internamente.
	 - Si todo OK: muestra mensaje de éxito y resetea `cantidad = 0`.

Notas sobre concurrencia y atomicidad:
- Las operaciones `agregarProductoAlInventario` y `descontarDinero` no están envueltas en una transacción única a nivel de Room en la implementación actual. Si se requiere atomicidad (ambas operaciones deben ocurrir o ninguna), se recomienda mover la lógica al repositorio e implementarla dentro de una función anotada con `@Transaction` en el DAO o ejecutar las dos operaciones dentro de `RoomDatabase.withTransaction{...}`.

## Casos de error conocidos y notas de migración

- Error de identidad de esquema de Room: si la base de datos en el dispositivo difiere del esquema esperado, la app lanzaba `IllegalStateException: Room cannot verify the data integrity`. Se ha incrementado la versión de la base de datos a `3` y se habilitó `fallbackToDestructiveMigration()` para evitar el cierre abrupto. Consecuencia: pérdida de datos locales si hay desajuste de esquema.
- Recomendación: Si se desean conservar datos en actualizaciones de esquema, implementar migraciones explícitas mediante `Migration` objects y registrarlas en `databaseBuilder.addMigrations(...)`.
- Posible NullPointer/NoSuchRow: métodos suspend que devuelven entidades no-null (p.ej. `getByIdSuspend`) lanzarán si la fila no existe. Se sugiere, para robustez, cambiar la firma a retornar nullable (`Inventario?`) o manejar la excepción donde se invoque.

## Cómo ejecutar la aplicación localmente

Requisitos
- Android Studio (Arctic Fox o posterior recomendado) con plugins de Kotlin y Compose.
- SDK y compilador configurados según `build.gradle` del proyecto (abrir el proyecto para que Gradle descargue dependencias).

Pasos
1. Abrir el proyecto `ItemBox` en Android Studio.
2. Sincronizar Gradle (Build → Sync Project with Gradle Files).
3. Construir y ejecutar la app en emulador o dispositivo físico (Run → Run 'app').
4. En caso de `Room` schema mismatch, la app actualmente recreará la BD por `fallbackToDestructiveMigration()`; si se desea conservación, añadir migraciones y revertir esta política.

Verificación de flujos
- Crear inventario: Navegar a `CrearInventario` y completar nombre y dinero inicial.
- Seleccionar inventario: `Perfil` → tap/double-tap para seleccionar/activar.
- Comprar: `Ir a comprar` → ajustar cantidad → `Comprar`.

## Recomendaciones y siguientes pasos

1. Migraciones de Room. Implementar migraciones explícitas para evitar pérdida de datos en producciones.
2. Atomicidad en compras. Implementar transacción atómica para `agregarProductoAlInventario` + `descontarDinero`.
3. Manejo de errores. Cambiar firmas de `getByIdSuspend` a devolver nullable (`Inventario?`) o capturar excepciones en llamadas que puedan fallar.
4. UI/UX: reemplazar mensajes de texto por `Snackbar` para feedback de operaciones en `Tienda` y `Perfil` y añadir indicación visual para `inventarioActivo` (bordes o icono).
5. Tests unitarios e instrumentados: añadir pruebas para repositorios (operaciones de stock/compra) y pruebas de integración para flujos críticos.

## Anexos (mapa rápido de archivos relevantes)

- `app/src/main/java/com/mij/itembox/MainActivity.kt` — navegación y wiring principal.
- `app/src/main/java/com/mij/itembox/data/AppDatabase.kt` — configuración Room (versión: 3).
- `app/src/main/java/com/mij/itembox/data/model/` — entidades (`Producto.kt`, `Inventario.kt`, `Stock.kt`, `productos/*`).
- `app/src/main/java/com/mij/itembox/data/dao/` — DAOs: `ProductoDao.kt`, `InventarioDao.kt`, `StockDao.kt`, `productos/*`.
- `app/src/main/java/com/mij/itembox/data/repository/` — repositorios `ProductoRepository.kt`, `InventarioRepository.kt`, `StockRepository.kt`, `productos/*`.
- `app/src/main/java/com/mij/itembox/data/viewmodel/` — `ProductoViewModel.kt`, `InventarioViewModel.kt`, `StockViewModel.kt`, fábricas en `Fabricadores/`.
- `app/src/main/java/com/mij/itembox/ui/page/Perfil.kt` — UI de inventarios y navegación a tienda.
- `app/src/main/java/com/mij/itembox/ui/page/menuopciones/Tienda.kt` — UI de tienda (búsqueda, contador y compra).

---


