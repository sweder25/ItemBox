-- Script adaptado para Room + SQLite

PRAGMA foreign_keys = ON;

CREATE TABLE Calidad (
    id INTEGER PRIMARY KEY,
    descripcion TEXT,
    modificador REAL
);

INSERT INTO Calidad (id, descripcion, modificador) VALUES (1, 'Obra Maestra', 2);
INSERT INTO Calidad (id, descripcion, modificador) VALUES (2, 'Exelente', 1.5);
INSERT INTO Calidad (id, descripcion, modificador) VALUES (3, 'Buena', 1.25);
INSERT INTO Calidad (id, descripcion, modificador) VALUES (4, 'Normal', 1);
INSERT INTO Calidad (id, descripcion, modificador) VALUES (5, 'Mediocre', 0.75);
INSERT INTO Calidad (id, descripcion, modificador) VALUES (6, 'Mala', 0.5);
INSERT INTO Calidad (id, descripcion, modificador) VALUES (7, 'Basura', 0.01);

CREATE TABLE Resistencia (
    id INTEGER PRIMARY KEY,
    descripcion TEXT
);

INSERT INTO Resistencia (id, descripcion) VALUES (1, 'Extrema');
INSERT INTO Resistencia (id, descripcion) VALUES (2, 'Buena');
INSERT INTO Resistencia (id, descripcion) VALUES (3, 'Normal');
INSERT INTO Resistencia (id, descripcion) VALUES (4, 'Mala');
INSERT INTO Resistencia (id, descripcion) VALUES (5, 'Mortal');

CREATE TABLE Temporada (
    id INTEGER PRIMARY KEY,
    descripcion TEXT
);

INSERT INTO Temporada (id, descripcion) VALUES (1, 'Invierno');
INSERT INTO Temporada (id, descripcion) VALUES (2, 'Primavera');
INSERT INTO Temporada (id, descripcion) VALUES (3, 'Verano');
INSERT INTO Temporada (id, descripcion) VALUES (4, 'Otoño');

CREATE TABLE Rareza (
    id INTEGER PRIMARY KEY,
    descripcion TEXT
);

INSERT INTO Rareza (id, descripcion) VALUES (1, 'Común');
INSERT INTO Rareza (id, descripcion) VALUES (2, 'Poco Común');
INSERT INTO Rareza (id, descripcion) VALUES (3, 'Raro');
INSERT INTO Rareza (id, descripcion) VALUES (4, 'Muy Raro');
INSERT INTO Rareza (id, descripcion) VALUES (5, 'Legendario');

CREATE TABLE Bioma (
    id INTEGER PRIMARY KEY,
    nombre TEXT,
    descripcion TEXT
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
    id INTEGER PRIMARY KEY,
    nombre TEXT,
    bioma_principal INTEGER,
    FOREIGN KEY (bioma_principal) REFERENCES Bioma(id)
);

CREATE TABLE Vecino (
    id_region_a INTEGER,
    id_region_b INTEGER,
    PRIMARY KEY (id_region_a, id_region_b),
    FOREIGN KEY (id_region_a) REFERENCES Region(id),
    FOREIGN KEY (id_region_b) REFERENCES Region(id)
);

CREATE TABLE Enemistad (
    id_region_a INTEGER,
    id_region_b INTEGER,
    PRIMARY KEY (id_region_a, id_region_b),
    FOREIGN KEY (id_region_a) REFERENCES Region(id),
    FOREIGN KEY (id_region_b) REFERENCES Region(id)
);

CREATE TABLE Tratado (
    id_region_a INTEGER,
    id_region_b INTEGER,
    descripcion_tratado TEXT,
    PRIMARY KEY (id_region_a, id_region_b),
    FOREIGN KEY (id_region_a) REFERENCES Region(id),
    FOREIGN KEY (id_region_b) REFERENCES Region(id)
);

CREATE TABLE Alianza (
    id_region_a INTEGER,
    id_region_b INTEGER,
    descripcion_alianza TEXT,
    fecha_termino TEXT,
    PRIMARY KEY (id_region_a, id_region_b),
    FOREIGN KEY (id_region_a) REFERENCES Region(id),
    FOREIGN KEY (id_region_b) REFERENCES Region(id)
);

CREATE TABLE Producto (
    id INTEGER PRIMARY KEY,
    nombre TEXT,
    tipo TEXT
);

CREATE TABLE Vegetal (
    id INTEGER PRIMARY KEY,
    rareza INTEGER,
    temporada INTEGER,
    resistencia_frio INTEGER,
    resistencia_calor INTEGER,
    resistencia_humedad INTEGER,
    resistencia_sequia INTEGER,
    resistencia_luz INTEGER,
    descripcion TEXT,
    valor_base REAL,
    propiedades TEXT,
    bioma_ideal INTEGER,
    magia INTEGER,
    principal_provehedor INTEGER,
    peso REAL,
    FOREIGN KEY (id) REFERENCES Producto(id),
    FOREIGN KEY (rareza) REFERENCES Rareza(id),
    FOREIGN KEY (temporada) REFERENCES Temporada(id),
    FOREIGN KEY (bioma_ideal) REFERENCES Bioma(id),
    FOREIGN KEY (principal_provehedor) REFERENCES Region(id)
);

CREATE TABLE Mineral (
    id INTEGER PRIMARY KEY,
    rareza INTEGER,
    magia INTEGER,
    valor_base REAL,
    descripcion_objeto TEXT,
    principal_provehedor INTEGER,
    bioma_ideal INTEGER,
    peso REAL,
    FOREIGN KEY (id) REFERENCES Producto(id),
    FOREIGN KEY (rareza) REFERENCES Rareza(id),
    FOREIGN KEY (bioma_ideal) REFERENCES Bioma(id),
    FOREIGN KEY (principal_provehedor) REFERENCES Region(id)
);

CREATE TABLE Animal (
    id INTEGER PRIMARY KEY,
    rareza INTEGER,
    valor_base REAL,
    descripcion_especie TEXT,
    magia INTEGER,
    bioma_ideal INTEGER,
    principal_provehedor INTEGER,
    peso REAL,
    FOREIGN KEY (id) REFERENCES Producto(id),
    FOREIGN KEY (rareza) REFERENCES Rareza(id),
    FOREIGN KEY (bioma_ideal) REFERENCES Bioma(id),
    FOREIGN KEY (principal_provehedor) REFERENCES Region(id)
);

CREATE TABLE Producto_Animal (
    id INTEGER PRIMARY KEY,
    rareza INTEGER,
    descripcion_origen TEXT,
    descripcion_propiedades TEXT,
    magia INTEGER,
    principal_provehedor INTEGER,
    valor_base REAL,
    peso REAL,
    FOREIGN KEY (id) REFERENCES Producto(id),
    FOREIGN KEY (rareza) REFERENCES Rareza(id),
    FOREIGN KEY (principal_provehedor) REFERENCES Region(id)
);

CREATE TABLE Elaborado (
    id INTEGER PRIMARY KEY,
    valor_base REAL,
    rareza INTEGER,
    magia INTEGER,
    descripcion_objeto TEXT,
    descripcion_propiedades TEXT,
    principal_provehedor INTEGER,
    peso REAL,
    FOREIGN KEY (id) REFERENCES Producto(id),
    FOREIGN KEY (rareza) REFERENCES Rareza(id),
    FOREIGN KEY (principal_provehedor) REFERENCES Region(id)
);

CREATE TABLE Produccion (
    id_region INTEGER,
    id_producto INTEGER,
    PRIMARY KEY (id_region, id_producto),
    FOREIGN KEY (id_region) REFERENCES Region(id),
    FOREIGN KEY (id_producto) REFERENCES Producto(id)
);

CREATE TABLE Distancia(
    id_distancia INTEGER PRIMARY KEY,
    descripcion TEXT,
    modificador REAL
);

INSERT INTO Distancia (id_distancia, descripcion, modificador) VALUES (1, 'otro continente', 2);
INSERT INTO Distancia (id_distancia, descripcion, modificador) VALUES (2, 'a 2 o más regiones', 1.5);
INSERT INTO Distancia (id_distancia, descripcion, modificador) VALUES (3, 'a 1 region', 1.25);
INSERT INTO Distancia (id_distancia, descripcion, modificador) VALUES (4, 'vecino', 1);

CREATE TABLE DistanciaEntreRegiones (
    id_region_a INTEGER,
    id_region_b INTEGER,
    distancia INTEGER,
    PRIMARY KEY (id_region_a, id_region_b),
    FOREIGN KEY (id_region_a) REFERENCES Region(id),
    FOREIGN KEY (id_region_b) REFERENCES Region(id),
    FOREIGN KEY (distancia) REFERENCES Distancia(id_distancia)
);

CREATE TABLE Inventario (
    id_inventario INTEGER PRIMARY KEY,
    id_producto INTEGER,
    cantidad INTEGER,
    FOREIGN KEY (id_producto) REFERENCES Elaborado(id)
);

CREATE TABLE Player (
    id_player INTEGER PRIMARY KEY,
    nick_player TEXT,
    dinero REAL,
    inventario INTEGER,
    FOREIGN KEY (inventario) REFERENCES Inventario(id_inventario)
);


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


INSERT INTO Vegetal (id, rareza, temporada, resistencia_frio, resistencia_calor, resistencia_humedad, resistencia_sequia, resistencia_luz, descripcion, valor_base, propiedades, bioma_ideal, magia, principal_provehedor, peso)
VALUES (1001, 1, 3, 2, 3, 2, 2, 3, 'Fruta roja y dulce, común en climas templados.', 5.00, 'Alimento, comercio', 17, 0, 1, 0.2);
INSERT INTO Vegetal (id, rareza, temporada, resistencia_frio, resistencia_calor, resistencia_humedad, resistencia_sequia, resistencia_luz, descripcion, valor_base, propiedades, bioma_ideal, magia, principal_provehedor, peso)
VALUES (1002, 1, 2, 3, 2, 3, 3, 2, 'Cereal básico para pan y cerveza.', 2.00, 'Alimento, producción', 17, 0, 1, 0.1);


INSERT INTO Animal (id, rareza, valor_base, descripcion_especie, magia, bioma_ideal, principal_provehedor, peso)
VALUES (2001, 1, 50.00, 'Mamífero domesticado para carne y leche.', 0, 17, 1, 400);
INSERT INTO Animal (id, rareza, valor_base, descripcion_especie, magia, bioma_ideal, principal_provehedor, peso)
VALUES (2002, 1, 10.00, 'Ave domesticada para carne y huevos.', 0, 17, 1, 2);


INSERT INTO Mineral (id, rareza, magia, valor_base, descripcion_objeto, principal_provehedor, bioma_ideal, peso)
VALUES (3001, 3, 0, 100.00, 'Metal precioso usado como moneda y joyería.', 1, 29, 1);
INSERT INTO Mineral (id, rareza, magia, valor_base, descripcion_objeto, principal_provehedor, bioma_ideal, peso)
VALUES (3002, 2, 0, 20.00, 'Metal común para herramientas y armas.', 1, 29, 1);


INSERT INTO Producto_Animal (id, rareza, descripcion_origen, descripcion_propiedades, magia, principal_provehedor, valor_base, peso)
VALUES (4001, 1, 'Vaca', 'Alimento líquido, base para queso.', 0, 1, 2.00, 1);
INSERT INTO Producto_Animal (id, rareza, descripcion_origen, descripcion_propiedades, magia, principal_provehedor, valor_base, peso)
VALUES (4002, 1, 'Gallina', 'Alimento básico, fuente de proteína.', 0, 1, 1.00, 0.1);


INSERT INTO Elaborado (id, valor_base, rareza, magia, descripcion_objeto, descripcion_propiedades, principal_provehedor, peso)
VALUES (5001, 25.00, 2, 0, 'Arma blanca de filo, usada en combate.', 'Corte, defensa', 1, 3);
INSERT INTO Elaborado (id, valor_base, rareza, magia, descripcion_objeto, descripcion_propiedades, principal_provehedor, peso)
VALUES (5002, 3.00, 1, 0, 'Alimento horneado, básico en la dieta.', 'Nutrición, comercio', 1, 0.5);
