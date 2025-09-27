CREATE TABLE Calidad (
    id NUMBER(4) PRIMARY KEY,
    descripcion VARCHAR2(30),
    modificador NUMBER(5,2)
);

INSERT INTO Calidad (id, descripcion, modificador) VALUES (1, 'Obra Maestra', 2);
INSERT INTO Calidad (id, descripcion, modificador) VALUES (2, 'Exelente', 1.5);
INSERT INTO Calidad (id, descripcion, modificador) VALUES (3, 'Buena', 1.25);
INSERT INTO Calidad (id, descripcion, modificador) VALUES (4, 'Normal', 1);
INSERT INTO Calidad (id, descripcion, modificador) VALUES (5, 'Mediocre', 0.75);
INSERT INTO Calidad (id, descripcion, modificador) VALUES (6, 'Mala', 0.5);
INSERT INTO Calidad (id, descripcion, modificador) VALUES (7, 'Basura', 0.01);

CREATE TABLE Resistencia (
    id NUMBER(4) PRIMARY KEY,
    descripcion VARCHAR2(20)
);

INSERT INTO Resistencia (id, descripcion) VALUES (1, 'Extrema');
INSERT INTO Resistencia (id, descripcion) VALUES (2, 'Buena');
INSERT INTO Resistencia (id, descripcion) VALUES (3, 'Normal');
INSERT INTO Resistencia (id, descripcion) VALUES (4, 'Mala');
INSERT INTO Resistencia (id, descripcion) VALUES (5, 'Mortal');

CREATE TABLE Temporada (
    id NUMBER(2) PRIMARY KEY,
    descripcion VARCHAR2(15)
);

INSERT INTO Temporada (id, descripcion) VALUES (1, 'Invierno');
INSERT INTO Temporada (id, descripcion) VALUES (2, 'Primavera');
INSERT INTO Temporada (id, descripcion) VALUES (3, 'Verano');
INSERT INTO Temporada (id, descripcion) VALUES (4, 'Otoño');

CREATE TABLE Rareza (
    id NUMBER(2) PRIMARY KEY,
    descripcion VARCHAR2(20)
);

INSERT INTO Rareza (id, descripcion) VALUES (1, 'Común');
INSERT INTO Rareza (id, descripcion) VALUES (2, 'Poco Común');
INSERT INTO Rareza (id, descripcion) VALUES (3, 'Raro');
INSERT INTO Rareza (id, descripcion) VALUES (4, 'Muy Raro');
INSERT INTO Rareza (id, descripcion) VALUES (5, 'Legendario');

CREATE TABLE Bioma (
    id NUMBER(4) PRIMARY KEY,
    nombre VARCHAR2(40),
    descripcion VARCHAR2(200)
);

INSERT INTO Bioma (id, nombre, descripcion) VALUES (1, 'Bosque encantado', 'Bosque mágico donde la flora y fauna pueden tener propiedades sobrenaturales; hogar de dríadas, unicornios y espíritus.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (2, 'Desierto abrasador', 'Región árida con dunas interminables, ruinas antiguas y criaturas adaptadas al calor extremo como escorpiones gigantes.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (3, 'Tundra helada', 'Extensión fría y desolada con suelo congelado, ventiscas constantes y bestias resistentes como lobos blancos y yetis.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (4, 'Montañas escarpadas', 'Cordilleras imponentes con riscos peligrosos, cavernas ocultas y nidos de dragones o grifos.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (5, 'Pantano sombrío', 'Zona húmeda y fangosa, cubierta de niebla, ideal para encuentros con brujas, muertos vivientes y criaturas anfibias.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (6, 'Pradera dorada', 'Llanuras abiertas con hierba alta, hogar de tribus nómadas, manadas de bestias y ocasionales ruinas enterradas.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (7, 'Bosque oscuro', 'Bosque denso donde la luz apenas penetra, habitado por criaturas nocturnas, arañas gigantes y cultos secretos.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (8, 'Tierras volcánicas', 'Región de actividad geotérmica, con ríos de lava, géiseres y criaturas ígneas como elementales de fuego.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (9, 'Islas flotantes', 'Archipiélago suspendido en el cielo, accesible por magia o criaturas voladoras; hogar de sabios, templos y secretos antiguos.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (10, 'Mar cristalino', 'Océano de aguas claras, con arrecifes mágicos, sirenas, krakens y ruinas sumergidas.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (11, 'Bosque fúngico', 'Bioma subterráneo o sombrío dominado por hongos gigantes, esporas tóxicas y criaturas como los miconidas.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (12, 'Tierras sombrías', 'Región corrompida por magia oscura, con vegetación retorcida, cielos perpetuamente nublados y presencia de muertos vivientes.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (13, 'Selva tropical', 'Bioma cálido y húmedo con vegetación exuberante, ruinas cubiertas de musgo y criaturas exóticas como dinosaurios o serpientes gigantes.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (14, 'Tierras de cristal', 'Región mágica donde el terreno está cubierto por cristales brillantes, con propiedades arcanas y criaturas elementales.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (15, 'Campos nevados eternos', 'Zona de hielo perpetuo, con ventiscas constantes, glaciares y criaturas como mamuts o dragones blancos.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (16, 'Caverna abisal', 'Sistema de túneles subterráneos profundos, hogar de aberraciones, duergars y ecos de antiguas civilizaciones.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (17, 'Tierras fértiles', 'Región templada ideal para asentamientos, con campos cultivables, ríos tranquilos y fauna domesticable.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (18, 'Ruinas flotantes', 'Restos de una civilización antigua suspendidos en el aire por magia residual, habitadas por espectros y guardianes arcanos.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (19, 'Bosque de ceniza', 'Bosque quemado por fuego mágico o natural, con árboles carbonizados, suelo estéril y criaturas adaptadas a la devastación.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (20, 'Tierras feéricas', 'Bioma encantado donde las reglas del tiempo y espacio son inestables, habitado por criaturas del Feywild.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (21, 'Bosque templado caducifolio', 'Bosque con estaciones marcadas, árboles que pierden sus hojas en otoño y fauna diversa.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (22, 'Bosque boreal (taiga)', 'Bosque frío de coníferas, con inviernos largos y fauna adaptada al clima extremo.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (23, 'Sabana', 'Región cálida con pastizales y árboles dispersos, hogar de grandes herbívoros y depredadores.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (24, 'Pradera templada', 'Llanuras de hierba con clima moderado, ideales para la agricultura y el pastoreo.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (25, 'Desierto frío', 'Zona árida con temperaturas bajas, escasa vegetación y vientos intensos.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (26, 'Manglar', 'Ecosistema costero tropical con árboles adaptados a aguas salobres, vital para la protección de costas.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (27, 'Bosque lluvioso templado', 'Bosque húmedo en zonas templadas, con árboles altos, musgos y una rica biodiversidad.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (28, 'Estuario', 'Zona de transición entre ríos y mares, con mezcla de agua dulce y salada, rica en nutrientes.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (29, 'Bioma alpino', 'Región montañosa con clima frío, vegetación escasa y fauna adaptada a la altitud.');
INSERT INTO Bioma (id, nombre, descripcion) VALUES (30, 'Arrecife de coral', 'Ecosistema marino tropical formado por corales, con altísima biodiversidad acuática.');

CREATE TABLE Region (
    id NUMBER(4) PRIMARY KEY,
    nombre VARCHAR2(40),
    bioma_principal NUMBER(4),
    FOREIGN KEY (bioma_principal) REFERENCES Bioma(id)
);

CREATE TABLE Vecino (
    id_region_a NUMBER(4),
    id_region_b NUMBER(4),
    PRIMARY KEY (id_region_a, id_region_b),
    FOREIGN KEY (id_region_a) REFERENCES Region(id),
    FOREIGN KEY (id_region_b) REFERENCES Region(id)
);

CREATE TABLE Enemistad (
    id_region_a NUMBER(4),
    id_region_b NUMBER(4),
    PRIMARY KEY (id_region_a, id_region_b),
    FOREIGN KEY (id_region_a) REFERENCES Region(id),
    FOREIGN KEY (id_region_b) REFERENCES Region(id)
);

CREATE TABLE Tratado (
    id_region_a NUMBER(4),
    id_region_b NUMBER(4),
    descripcion_tratado VARCHAR2(100),
    PRIMARY KEY (id_region_a, id_region_b),
    FOREIGN KEY (id_region_a) REFERENCES Region(id),
    FOREIGN KEY (id_region_b) REFERENCES Region(id)
);

CREATE TABLE Alianza (
    id_region_a NUMBER(4),
    id_region_b NUMBER(4),
    descripcion_alianza VARCHAR2(100),
    fecha_termino DATE,
    PRIMARY KEY (id_region_a, id_region_b),
    FOREIGN KEY (id_region_a) REFERENCES Region(id),
    FOREIGN KEY (id_region_b) REFERENCES Region(id)
);

-- Tabla padre Producto
CREATE TABLE Producto (
    id NUMBER(6) PRIMARY KEY,
    nombre VARCHAR2(40),
    tipo VARCHAR2(20) -- 'Vegetal', 'Animal', 'Elaborado', 'Producto_Animal', 'Mineral'
);

CREATE TABLE Vegetal (
    id NUMBER(6) PRIMARY KEY,
    rareza NUMBER(2),
    temporada NUMBER(2),
    resistencia_frio NUMBER(2),
    resistencia_calor NUMBER(2),
    resistencia_humedad NUMBER(2),
    resistencia_sequia NUMBER(2),
    resistencia_luz NUMBER(2),
    descripcion VARCHAR2(200),
    valor_base NUMBER(10,2),
    propiedades VARCHAR2(100),
    bioma_ideal NUMBER(4),
    magia NUMBER(1),
    principal_provehedor NUMBER(4),
    peso NUMBER(8,2),
    FOREIGN KEY (id) REFERENCES Producto(id),
    FOREIGN KEY (rareza) REFERENCES Rareza(id),
    FOREIGN KEY (temporada) REFERENCES Temporada(id),
    FOREIGN KEY (bioma_ideal) REFERENCES Bioma(id),
    FOREIGN KEY (principal_provehedor) REFERENCES Region(id)
);

CREATE TABLE Mineral (
    id NUMBER(6) PRIMARY KEY,
    rareza NUMBER(2),
    magia NUMBER(1),
    valor_base NUMBER(10,2),
    descripcion_objeto VARCHAR2(200),
    principal_provehedor NUMBER(4),
    bioma_ideal NUMBER(4),
    peso NUMBER(8,2),
    FOREIGN KEY (id) REFERENCES Producto(id),
    FOREIGN KEY (rareza) REFERENCES Rareza(id),
    FOREIGN KEY (bioma_ideal) REFERENCES Bioma(id),
    FOREIGN KEY (principal_provehedor) REFERENCES Region(id)
);

CREATE TABLE Animal (
    id NUMBER(6) PRIMARY KEY,
    rareza NUMBER(2),
    valor_base NUMBER(10,2),
    descripcion_especie VARCHAR2(200),
    magia NUMBER(1),
    bioma_ideal NUMBER(4),
    principal_provehedor NUMBER(4),
    peso NUMBER(8,2),
    FOREIGN KEY (id) REFERENCES Producto(id),
    FOREIGN KEY (rareza) REFERENCES Rareza(id),
    FOREIGN KEY (bioma_ideal) REFERENCES Bioma(id),
    FOREIGN KEY (principal_provehedor) REFERENCES Region(id)
);

CREATE TABLE Producto_Animal (
    id NUMBER(6) PRIMARY KEY,
    rareza NUMBER(2),
    descripcion_origen VARCHAR2(100),
    descripcion_propiedades VARCHAR2(100),
    magia NUMBER(1),
    principal_provehedor NUMBER(4),
    valor_base NUMBER(10,2),
    peso NUMBER(8,2),
    FOREIGN KEY (id) REFERENCES Producto(id),
    FOREIGN KEY (rareza) REFERENCES Rareza(id),
    FOREIGN KEY (principal_provehedor) REFERENCES Region(id)
);

CREATE TABLE Elaborado (
    id NUMBER(6) PRIMARY KEY,
    valor_base NUMBER(10,2),
    rareza NUMBER(2),
    magia NUMBER(1),
    descripcion_objeto VARCHAR2(200),
    descripcion_propiedades VARCHAR2(100),
    principal_provehedor NUMBER(4),
    peso NUMBER(8,2),
    FOREIGN KEY (id) REFERENCES Producto(id),
    FOREIGN KEY (rareza) REFERENCES Rareza(id),
    FOREIGN KEY (principal_provehedor) REFERENCES Region(id)
);

CREATE TABLE Produccion (
    id_region NUMBER(4),
    id_producto NUMBER(6),
    PRIMARY KEY (id_region, id_producto),
    FOREIGN KEY (id_region) REFERENCES Region(id),
    FOREIGN KEY (id_producto) REFERENCES Producto(id)
);

CREATE TABLE Distancia(
    id_distancia NUMBER(4) PRIMARY KEY,
    descripcion VARCHAR2(20),
    modificador NUMBER(5,2)
);

INSERT INTO Distancia (id_distancia, descripcion, modificador) VALUES (1, 'otro continente', 2);
INSERT INTO Distancia (id_distancia, descripcion, modificador) VALUES (2, 'a 2 o más regiones', 1.5);
INSERT INTO Distancia (id_distancia, descripcion, modificador) VALUES (3, 'a 1 region', 1.25);
INSERT INTO Distancia (id_distancia, descripcion, modificador) VALUES (4, 'vecino', 1);

CREATE TABLE DistanciaEntreRegiones (
    id_region_a NUMBER(4),
    id_region_b NUMBER(4),
    distancia NUMBER(4),
    PRIMARY KEY (id_region_a, id_region_b),
    FOREIGN KEY (id_region_a) REFERENCES Region(id),
    FOREIGN KEY (id_region_b) REFERENCES Region(id),
    FOREIGN KEY (distancia) REFERENCES Distancia(id_distancia)
);

CREATE TABLE Inventario (
    id_inventario NUMBER(4) PRIMARY KEY,
    id_producto NUMBER(6),
    cantidad NUMBER,
    FOREIGN KEY (id_producto) REFERENCES Elaborado(id)
);

CREATE TABLE Player (
    id_player NUMBER(4) PRIMARY KEY,
    nick_player VARCHAR2(20),
    dinero NUMBER,
    inventario NUMBER(4),
    FOREIGN KEY (inventario) REFERENCES Inventario(id_inventario)
);


------------------ ELEMENTOS DE BASE DE DATOS ADICIONALES ------------------

-- PROCEDIMIENTO: Actualizar inventario

CREATE OR REPLACE PROCEDURE actualizar_inventario(p_id_producto NUMBER, p_cantidad NUMBER) IS
BEGIN
    UPDATE Inventario SET cantidad = cantidad + p_cantidad WHERE id_producto = p_id_producto;
END;
/

-- FUNCIÓN: Calcular precio de producto considerando calidad y distancia y usando Producto
CREATE OR REPLACE FUNCTION calcular_precio(
    p_id_producto NUMBER,
    p_id_calidad NUMBER,
    p_id_distancia NUMBER
) RETURN NUMBER IS
    v_precio_base NUMBER;
    v_mod_calidad NUMBER;
    v_mod_distancia NUMBER;
    v_tipo_producto VARCHAR2(20);
    v_precio_final NUMBER;
BEGIN
    SELECT tipo INTO v_tipo_producto FROM Producto WHERE id = p_id_producto;
    -- Obtener valor_base según tipo de producto
    IF v_tipo_producto = 'Vegetal' THEN
        SELECT valor_base INTO v_precio_base FROM Vegetal WHERE id = p_id_producto;
    ELSIF v_tipo_producto = 'Animal' THEN
        SELECT valor_base INTO v_precio_base FROM Animal WHERE id = p_id_producto;
    ELSIF v_tipo_producto = 'Mineral' THEN
        SELECT valor_base INTO v_precio_base FROM Mineral WHERE id = p_id_producto;
    ELSIF v_tipo_producto = 'Producto_Animal' THEN
        SELECT valor_base INTO v_precio_base FROM Producto_Animal WHERE id = p_id_producto;
    ELSIF v_tipo_producto = 'Elaborado' THEN
        SELECT valor_base INTO v_precio_base FROM Elaborado WHERE id = p_id_producto;
    ELSE
        v_precio_base := 0;
    END IF;
    SELECT modificador INTO v_mod_calidad FROM Calidad WHERE id = p_id_calidad;
    SELECT modificador INTO v_mod_distancia FROM Distancia WHERE id = p_id_distancia;
    v_precio_final := v_precio_base * v_mod_calidad * v_mod_distancia;
    RETURN v_precio_final;
END;
/

-- PACKAGE: Gestión de inventario actualizado para Producto
CREATE OR REPLACE PACKAGE gestion_inventario AS
    PROCEDURE actualizar_inventario(p_id_producto NUMBER, p_cantidad NUMBER);
    FUNCTION calcular_precio(p_id_producto NUMBER, p_id_calidad NUMBER, p_id_distancia NUMBER) RETURN NUMBER;
END gestion_inventario;
/

CREATE OR REPLACE PACKAGE BODY gestion_inventario AS
    PROCEDURE actualizar_inventario(p_id_producto NUMBER, p_cantidad NUMBER) IS
    BEGIN
        UPDATE Inventario SET cantidad = cantidad + p_cantidad WHERE id_producto = p_id_producto;
    END;
    FUNCTION calcular_precio(p_id_producto NUMBER, p_id_calidad NUMBER, p_id_distancia NUMBER) RETURN NUMBER IS
        v_precio_base NUMBER;
        v_mod_calidad NUMBER;
        v_mod_distancia NUMBER;
        v_tipo_producto VARCHAR2(20);
        v_precio_final NUMBER;
    BEGIN
        SELECT tipo INTO v_tipo_producto FROM Producto WHERE id = p_id_producto;
        IF v_tipo_producto = 'Vegetal' THEN
            SELECT valor_base INTO v_precio_base FROM Vegetal WHERE id = p_id_producto;
        ELSIF v_tipo_producto = 'Animal' THEN
            SELECT valor_base INTO v_precio_base FROM Animal WHERE id = p_id_producto;
        ELSIF v_tipo_producto = 'Mineral' THEN
            SELECT valor_base INTO v_precio_base FROM Mineral WHERE id = p_id_producto;
        ELSIF v_tipo_producto = 'Producto_Animal' THEN
            SELECT valor_base INTO v_precio_base FROM Producto_Animal WHERE id = p_id_producto;
        ELSIF v_tipo_producto = 'Elaborado' THEN
            SELECT valor_base INTO v_precio_base FROM Elaborado WHERE id = p_id_producto;
        ELSE
            v_precio_base := 0;
        END IF;
        SELECT modificador INTO v_mod_calidad FROM Calidad WHERE id = p_id_calidad;
        SELECT modificador INTO v_mod_distancia FROM Distancia WHERE id = p_id_distancia;
        v_precio_final := v_precio_base * v_mod_calidad * v_mod_distancia;
        RETURN v_precio_final;
    END;
END gestion_inventario;
/

-- TRIGGER: Auditoría de compras

CREATE TABLE Auditoria (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    accion VARCHAR2(50),
    fecha DATE
);

CREATE OR REPLACE TRIGGER tr_auditoria_compra
AFTER INSERT ON Elaborado
FOR EACH ROW
BEGIN
    INSERT INTO Auditoria (accion, fecha) VALUES ('Compra', SYSDATE);
END;

-- Poblar tabla Producto con ejemplos
INSERT INTO Producto (id, nombre, tipo) VALUES (1001, 'Manzana', 'Vegetal');
INSERT INTO Producto (id, nombre, tipo) VALUES (1002, 'Trigo', 'Vegetal');
INSERT INTO Producto (id, nombre, tipo) VALUES (2001, 'Vaca', 'Animal');
INSERT INTO Producto (id, nombre, tipo) VALUES (2002, 'Gallina', 'Animal');
INSERT INTO Producto (id, nombre, tipo) VALUES (3001, 'Oro', 'Mineral');
INSERT INTO Producto (id, nombre, tipo) VALUES (3002, 'Hierro', 'Mineral');
INSERT INTO Producto (id, nombre, tipo) VALUES (4001, 'Leche', 'Producto_Animal');
INSERT INTO Producto (id, nombre, tipo) VALUES (4002, 'Huevo', 'Producto_Animal');
INSERT INTO Producto (id, nombre, tipo) VALUES (5001, 'Espada', 'Elaborado');
INSERT INTO Producto (id, nombre, tipo) VALUES (5002, 'Pan', 'Elaborado');

-- Poblar tabla Vegetal
INSERT INTO Vegetal (id, rareza, temporada, resistencia_frio, resistencia_calor, resistencia_humedad, resistencia_sequia, resistencia_luz, descripcion, valor_base, propiedades, bioma_ideal, magia, principal_provehedor, peso)
VALUES (1001, 1, 3, 2, 3, 2, 2, 3, 'Fruta roja y dulce, común en climas templados.', 5.00, 'Alimento, comercio', 17, 0, 1, 0.2);
INSERT INTO Vegetal (id, rareza, temporada, resistencia_frio, resistencia_calor, resistencia_humedad, resistencia_sequia, resistencia_luz, descripcion, valor_base, propiedades, bioma_ideal, magia, principal_provehedor, peso)
VALUES (1002, 1, 2, 3, 2, 3, 3, 2, 'Cereal básico para pan y cerveza.', 2.00, 'Alimento, producción', 17, 0, 1, 0.1);

-- Poblar tabla Animal
INSERT INTO Animal (id, rareza, valor_base, descripcion_especie, magia, bioma_ideal, principal_provehedor, peso)
VALUES (2001, 1, 50.00, 'Mamífero domesticado para carne y leche.', 0, 17, 1, 400);
INSERT INTO Animal (id, rareza, valor_base, descripcion_especie, magia, bioma_ideal, principal_provehedor, peso)
VALUES (2002, 1, 10.00, 'Ave domesticada para carne y huevos.', 0, 17, 1, 2);

-- Poblar tabla Mineral
INSERT INTO Mineral (id, rareza, magia, valor_base, descripcion_objeto, principal_provehedor, bioma_ideal, peso)
VALUES (3001, 3, 0, 100.00, 'Metal precioso usado como moneda y joyería.', 1, 29, 1);
INSERT INTO Mineral (id, rareza, magia, valor_base, descripcion_objeto, principal_provehedor, bioma_ideal, peso)
VALUES (3002, 2, 0, 20.00, 'Metal común para herramientas y armas.', 1, 29, 1);

-- Poblar tabla Producto_Animal
INSERT INTO Producto_Animal (id, rareza, descripcion_origen, descripcion_propiedades, magia, principal_provehedor, valor_base, peso)
VALUES (4001, 1, 'Vaca', 'Alimento líquido, base para queso.', 0, 1, 2.00, 1);
INSERT INTO Producto_Animal (id, rareza, descripcion_origen, descripcion_propiedades, magia, principal_provehedor, valor_base, peso)
VALUES (4002, 1, 'Gallina', 'Alimento básico, fuente de proteína.', 0, 1, 1.00, 0.1);

-- Poblar tabla Elaborado
INSERT INTO Elaborado (id, valor_base, rareza, magia, descripcion_objeto, descripcion_propiedades, principal_provehedor, peso)
VALUES (5001, 25.00, 2, 0, 'Arma blanca de filo, usada en combate.', 'Corte, defensa', 1, 3);
INSERT INTO Elaborado (id, valor_base, rareza, magia, descripcion_objeto, descripcion_propiedades, principal_provehedor, peso)
VALUES (5002, 3.00, 1, 0, 'Alimento horneado, básico en la dieta.', 'Nutrición, comercio', 1, 0.5);