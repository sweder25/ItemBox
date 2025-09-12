# ItemBox
Objetivo del Proyecto
    Explicación:
    Desarrollar un storage que permita consultar precios de objetos acorde a la necesidad del usuario, permitiendo generar filtros, buscar por nombre e identificar funciones y caracteristicas tales como el precio en cada region, acorde a su produccion y la de sus tratados comerciales, alianzas y cercanias. Tambien se espera poder modificar las tablas desde la misma app a necesidad tanto de forma manual con una interfaz amigable, como mediante un nuevo archivo excel que mantenga el mismo formato y sobre escriba el excel utilizado como base de datos, previniendo errores por corrupcion y datos mal ingresados.


Base de Datos 
    (por implementar en un excel)
    
    Calidad:
        id int PK
        descripcion String
        modificador Double

                7,'Obra Maestra',2
                6,'Exelente',1.5
                5,'Buena',1.25
                4,'Normal',1
                3,'Mediocre,0.75
                2,'Mala',0.5
                1,'Basura',0.01


    Resistencia:
        id int PK
        descripcion String

                5,'Extrema'
                4,'Buena'
                3,'Normal'
                2,'Mala'
                1,'Incapaz de Sobrevivir'
    
    Temporada:
        id int PK
        descripcion String

                4,'Invierno'
                3,'Primavera'
                2,'Verano'
                1,'Otoño'

    Rareza:
        id int PK
        descripcion String

                5,'Legendaria'
                4,'Muy Rara'
                3,'Rara'
                2,'Poco Comun'
                1,'Normal'

    Bioma:
        id int PK
        nombre String
        descripcion String

                1, 'Bosque encantado', 'Bosque mágico donde la flora y fauna pueden tener propiedades sobrenaturales; hogar de dríadas, unicornios y espíritus.'
                2, 'Desierto abrasador', 'Región árida con dunas interminables, ruinas antiguas y criaturas adaptadas al calor extremo como escorpiones gigantes.'
                3, 'Tundra helada', 'Extensión fría y desolada con suelo congelado, ventiscas constantes y bestias resistentes como lobos blancos y yetis.'
                4, 'Montañas escarpadas', 'Cordilleras imponentes con riscos peligrosos, cavernas ocultas y nidos de dragones o grifos.'
                5, 'Pantano sombrío', 'Zona húmeda y fangosa, cubierta de niebla, ideal para encuentros con brujas, muertos vivientes y criaturas anfibias.'
                6, 'Pradera dorada', 'Llanuras abiertas con hierba alta, hogar de tribus nómadas, manadas de bestias y ocasionales ruinas enterradas.'
                7, 'Bosque oscuro', 'Bosque denso donde la luz apenas penetra, habitado por criaturas nocturnas, arañas gigantes y cultos secretos.'
                8, 'Tierras volcánicas', 'Región de actividad geotérmica, con ríos de lava, géiseres y criaturas ígneas como elementales de fuego.'
                9, 'Islas flotantes', 'Archipiélago suspendido en el cielo, accesible por magia o criaturas voladoras; hogar de sabios, templos y secretos antiguos.'
                10, 'Mar cristalino', 'Océano de aguas claras, con arrecifes mágicos, sirenas, krakens y ruinas sumergidas.'
                11, 'Bosque fúngico', 'Bioma subterráneo o sombrío dominado por hongos gigantes, esporas tóxicas y criaturas como los miconidas.'
                12, 'Tierras sombrías', 'Región corrompida por magia oscura, con vegetación retorcida, cielos perpetuamente nublados y presencia de muertos vivientes.'
                13, 'Selva tropical', 'Bioma cálido y húmedo con vegetación exuberante, ruinas cubiertas de musgo y criaturas exóticas como dinosaurios o serpientes gigantes.'
                14, 'Tierras de cristal', 'Región mágica donde el terreno está cubierto por cristales brillantes, con propiedades arcanas y criaturas elementales.'
                15, 'Campos nevados eternos', 'Zona de hielo perpetuo, con ventiscas constantes, glaciares y criaturas como mamuts o dragones blancos.'
                16, 'Caverna abisal', 'Sistema de túneles subterráneos profundos, hogar de aberraciones, duergars y ecos de antiguas civilizaciones.'
                17, 'Tierras fértiles', 'Región templada ideal para asentamientos, con campos cultivables, ríos tranquilos y fauna domesticable.'
                18, 'Ruinas flotantes', 'Restos de una civilización antigua suspendidos en el aire por magia residual, habitadas por espectros y guardianes arcanos.'
                19, 'Bosque de ceniza', 'Bosque quemado por fuego mágico o natural, con árboles carbonizados, suelo estéril y criaturas adaptadas a la devastación.'
                20, 'Tierras feéricas', 'Bioma encantado donde las reglas del tiempo y espacio son inestables, habitado por criaturas del Feywild.'
                21, 'Bosque templado caducifolio', 'Bosque con estaciones marcadas, árboles que pierden sus hojas en otoño y fauna diversa.'
                22, 'Bosque boreal (taiga)', 'Bosque frío de coníferas, con inviernos largos y fauna adaptada al clima extremo.'
                23, 'Sabana', 'Región cálida con pastizales y árboles dispersos, hogar de grandes herbívoros y depredadores.'
                24, 'Pradera templada', 'Llanuras de hierba con clima moderado, ideales para la agricultura y el pastoreo.'
                25, 'Desierto frío', 'Zona árida con temperaturas bajas, escasa vegetación y vientos intensos.'
                26, 'Manglar', 'Ecosistema costero tropical con árboles adaptados a aguas salobres, vital para la protección de costas.'
                27, 'Bosque lluvioso templado', 'Bosque húmedo en zonas templadas, con árboles altos, musgos y una rica biodiversidad.'
                28, 'Estuario', 'Zona de transición entre ríos y mares, con mezcla de agua dulce y salada, rica en nutrientes.'
                29, 'Bioma alpino', 'Región montañosa con clima frío, vegetación escasa y fauna adaptada a la altitud.'
                30, 'Arrecife de coral', 'Ecosistema marino tropical formado por corales, con altísima biodiversidad acuática.'

    Region:
        id int PK
        nombre String
        bioma_principal int FK

    Vecino:
        id_region_a int PK FK
        id_region_b int PK FK        
        
    Enemistad:
        id_region_a int PK FK
        id_region_b int PK FK        
    
    Tratado:
        id_region_a int PK FK
        id_region_b int PK FK
        descripcion_tratado String

    Alianza:
        id_region_a int PK FK
        id_region_b int PK FK
        descripcion_alianza String
        fecha_termino String

    Vegetal:
        id int PK
        nombre String
        rareza int FK
        temporada int FK
        resistencia_frio int FK
        resistencia_calor int FK
        resistencia_humedad int FK
        resistencia_sequia int FK
        resistencia_luz int FK
        descripcion String
        valor_base Double
        propiedades String
        bioma_ideal int FK
        magia Boolean
        principal_provehedor int FK

    Mineral:
        id int PK
        nombre String
        rareza inf FK
        magia Boolean
        valor_base Double
        descripcion_objeto String
        principal_provehedor int FK
        bioma_ideal int FK

    Animal:
        id int PK
        nombre String
        rareza int FK
        valor_base Double
        descripcion_especie String
        magia Boolean
        bioma_ideal int FK
        principal_provehedor int FK

    Producto_Animal:
        id int PK
        nombre String
        rareza int FK
        descripcion_origen String
        descripcion_propiedades String
        magia Boolean
        principal_provehedor int FK
        valor_base Double

    Elaborado:
        id int PK
        nombre String
        valor_base Double
        rareza int FK
        magia Boolean
        descripcion_objeto
        descripcion_propiedades
        principal_provehedor int FK

    Produccion:
        id_region PK FK
        id_producto PK FK
