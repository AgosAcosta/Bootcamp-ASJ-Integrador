INSERT INTO conditions_afip
            (condition,
             created_at,
             update_at)
VALUES      ('Responsable Inscripto',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP),
            ('Monotributista',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP),
            ('Consumidor Final',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP),
            ('Exento',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP),
            ('No Responsable',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP),
            ('Otro',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP); 

INSERT INTO categories_supplier
            (category_supplier,
             created_at,
             update_at,
             DELETE_CATEGORY_SUPPLIER
             )
VALUES      ('Tecnologico',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false),
            ('Alimenticio',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false),
            ('Textil',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false),
            ('Farmaceutico',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false),
            ('Electrodomosticos',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false),
            ('Automotriz',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false),
            ('Moda',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false),
            ('Joyeria',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false),
            ('Muebles y Decoracion',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false),
            ('Cosmeticos',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false);          

INSERT INTO countries
            (country
             )
VALUES      ('Argentina'),
            ('Uruguay'),
            ('Brasil'),
            ('Chile'),
            ('Paraguay');

INSERT INTO provinces
            (province,
             id_country)
VALUES      ('Buenos Aires',
             1), -- Provincias de Argentina
            ('Cordoba',
             1),
            ('Santa Fe',
             1),
            ('Mendoza',
             1),
            ('Tucuman',
             1),
            ('Entre Rios',
             1),
            ('Salta',
             1),
            ('Misiones',
             1),
            ('Chaco',
             1),
            ('Corrientes',
             1),
            ('Santiago del Estero',
             1),
            ('San Juan',
             1),
            ('Jujuy',
             1),
            ('Rio Negro',
             1),
            ('Formosa',
             1),
            ('Neuquen',
             1),
            ('Chubut',
             1),
            ('San Luis',
             1),
            ('Catamarca',
             1),
            ('La Rioja',
             1),
            ('La Pampa',
             1),
            ('Santa Cruz',
             1),
            ('Tierra del Fuego',
             1),
            ('Montevideo',
             2), -- Provincias de Uruguay
            ('Canelones',
             2),
            ('Maldonado',
             2),
            ('Colonia',
             2),
            ('San Jose',
             2),
            ('Rio Negro',
             2),
            ('Artigas',
             2),
            ('Sao Paulo',
             3), -- Provincias de Brasil
            ('Rio de Janeiro',
             3),
            ('Minas Gerais',
             3),
            ('Bahia',
             3),
            ('Parana',
             3),
            ('Rio Grande do Sul',
             3),
            ('Amazonas',
             3),
            ('Santiago',
             4), -- Pronvicias de Chile
            ('Valparaiso',
             4),
            ('Biobio',
             4),
            ('Coquimbo',
             4),
            ('Asuncion',
             5), -- Provincia de Paraguay
            ('Central',
             5),
            ('Cordillera',
             5),
            ('Alto Paraguay',
             5); 

INSERT INTO directions
            (street_supplier,
             num_supplier,
             cp_supplier,
             location,
             id_province)
VALUES      ('Av. Rivadavia',
             123,
             1405,
             'Buenos Aires',
             1),
            ('Rua Augusta',
             456,
             0130,
             'Sao Paulo',
             31),
            ('Avenida 18 de Julio',
             789,
             1120,
             'Montevideo',
             24),
            ('Rua Oscar Freire',
             789,
             0146,
             'Rio Janeiro',
             31),
            ('Calle Florida',
             456,
             1005,
             'Cordoba',
             2),
            ('Rambla Sur',
             123,
             2010,
             'Canelones',
             25),
            ('Avenida Paulista',
             987,
             0111,
             'Minas Gerais',
             33),
            ('Calle de la Ciudad Vieja',
             567,
             1100,
             'Artigas',
             30),
            ('Avenida Copacabana',
             456,
             2220,
             'Rio de Janeiro',
             32),
            ('Plaza Independencia',
             789,
             1100,
             'Montevideo',
             12),
            ('Calle Corrientes',
             101,
             1043,
             'Buenos Aires',
             15),
            ('Rua das Palmeiras',
             234,
             0435,
             'Sao Paulo',
             30),
            ('Av. de Mayo',
             567,
             1084,
             'Buenos Aires',
             16),
            ('Rua Bela Cintra',
             789,
             1415,
             'Sao Paulo',
             3),
            ('Rambla Mahatma Gandhi',
             101,
             2000,
             'Montevideo',
             10); 

INSERT INTO contacts
            (name_contact,
             last_name_contact,
             tel_contact,
             email_contact,
             rol_contact)
VALUES      ('Alejandro',
             'Perez',
             3514556677,
             'alejandro.perez@gmail.com',
             'Coordinador de Compras'),
            ('Ana María',
             'Fernandez',
             3512334455,
             'ana.fernandez@hotmail.com',
             'Gerente en Recursos Humanos'),
            ('Pedro',
             'García',
             3518776655,
             'pedro.garcia@gmail.com',
             'Director Financiero'),
            ('Sofía',
             'Hernandez',
             3515443322,
             'sofia.hernandez@gmail.com',
             'Administracion'),
            ('Roberto',
             'Díaz',
             3518990011,
             'roberto.diaz@gmail.com',
             'Jefe de Producci�n'),
            ('Carolina',
             'Luna',
             3513445566,
             'carolina.luna@gmail.com',
             'Coordinadora de Compras'),
            ('Francisco',
             'Vega',
             3518991122,
             'francisco.vega@gmail.com',
             'Administracion'),
            ('Daniela',
             'Suárez',
             3514556677,
             'daniela.suarez@gmail.com',
             'Administracion'),
            ('Javier',
             'Morales',
             3512334455,
             'javier.morales@hotmail.com',
             'Gerente General'),
            ('Elena',
             'Gutierrez',
             3518776655,
             'elena.gutierrez@hotmail.com',
             'Dueña'); 

INSERT INTO categories_products
            (category_product,
             created_at,
             update_at,
             DELETE_CATEGORY_PRODUCT)
VALUES      ('Frutas y Verduras',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Productos Lacteos',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Bebidas y Jugos',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Panaderia y Pasteleria',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Smartphones',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Computadoras Portatiles',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Electronica de Consumo',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Dispositivos de Audio',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Electrodomesticos de Cocina',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Ropa de Hombre',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Ropa de Mujer',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Calzado',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Accesorios de Moda',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Muebles de Sala',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Muebles de Dormitorio',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Decoracion del Hogar',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Iluminacion',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Repuestos y Accesorios',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Aceites y Lubricantes',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Alimentos Varios',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false),
            ('Cuidado Personal',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP,false); 
             
             
INSERT INTO Status_Purchase_Orders(status)
VALUES 
('Pendiente'),
('Cancelado'),
('Entregado');

INSERT INTO suppliers
            (id_condition_afip,
             id_category_supplier,
             id_contact,
             id_direction,
             url_supplier,
             code_supplier,
             name_supplier,
             cuit_supplier,
             web_supplier,
             email_supplier,
             tel_supplier,
             created_at,
             update_at,DELETE_SUPPLIER )
VALUES      (1,
             1,
             1,
             1,
'https://ams3.digitaloceanspaces.com/graffica/2023/02/cocacola-logo.jpeg',
'Prov1',
'Coca Cola SRL',
'20-34567890-1',
'http://coca-cola.com',
'info@cocacola.com',
'3511234567',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, false),
            (1,
             1,
             2,
             2,
'https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Arcor_logo.svg/581px-Arcor_logo.svg.png'
             ,
'Prov2',
'Arcor SRL',
'30-51234567-8',
'http://arcor.com',
'info@arcor.com',
'3519876543',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, false),
            (2,
             10,
             3,
             3,
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgcBrSKkvAgui_g7S1UL-J8AFZ-LTamau-d-qFYX3pQQ&s'
             ,
'Prov3',
'Dove SA',
'40-19876543-2',
'http://doveArg.com',
'dove@gmail.com',
'3515551212',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, false),
            (1,
             4,
             4,
             4,
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9H-rkD3nIjBvpxvD6m_c5vaDNVEloqUmAPVcQzxxC-A&s'
             ,
'Prov4',
'Loreal Argentina SA',
'50-12345678-9',
'http://lorealArg.com',
'info@loreal.com',
'3518765432',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, false),
            (3,
             1,
             5,
             5,
'https://images.samsung.com/is/image/samsung/assets/global/about-us/brand/logo/360_197_1.png?$FB_TYPE_B_PNG$'
             ,
'Prov5',
'Samsung SA',
'60-58765432-1',
'http://samsung.com',
'contactosamsung@gmail.com',
'3512345678',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, false),
            (4,
             5,
             6,
             6,
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_2y6M-YsloFiFFAxenUmmE_S1rRRxEU5RXXrCHqMlpZfbe0vNL4qbl4f-_g&s'
             ,
'Prov6',
'WhirlPool Argentina SA',
'70-32109876-5',
'http://WhirlPoolArgentina.com',
'WhirlPoolArgentina@hotmail.com',
'3518901234',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, false),
            (1,
             3,
             7,
             7,
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM8eUfBUXVsOR5irjwFJEx_JPC57_u0lfkUIwJs9KwxLdtfvbYwHLJDp-zrg&s'
             ,
'Prov7',
'Adidas SRL',
'80-36543210-9',
'http://adidas.com',
'info@adidas.com',
'3512345678',
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, false),
            (5,
             8,
             8,
             8,
             NULL,
             'Prov8',
             'Juanita Perez',
             '90-98765432-1',
             'http://tiendanubeJuanita.com',
             'juani@hotmail.com',
             '3518765432',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false),
            (1,
             9,
             9,
             9,
             NULL,
             'Prov9',
             'Todo Muebles SRL',
             '30-12345678-9',
             'http://todomuebles.com',
             'muebles@hotmail.com',
             '3512345678',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false),
            (2,
             9,
             10,
             10,
             NULL,
             'prov10',
             'Todo Sillas',
             '30-98765432-1',
             'http://todosillas.com',
             'sillas@hotmail.com',
             '3518765432',
             CURRENT_TIMESTAMP,
             CURRENT_TIMESTAMP, false); 
             
INSERT INTO products
            (id_category_product,
             id_supplier,
             url_product,
             code_product,
             name_product,
             description_product,
             price_product,
             created_at,
             update_at,DELETE_PRODUCT )
VALUES      (3,
             1,
'https://jumboargentina.vtexassets.com/arquivos/ids/783070-800-auto?v=638206690815300000&width=800&height=auto&aspect=true'
             ,
'Prod1',
'Gaseosa Coca-cola',
'Sabor Original 2.25 L',
2200,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE ),
            (3,
             1,
'https://jumboargentina.vtexassets.com/arquivos/ids/784006-800-auto?v=638215869813300000&width=800&height=auto&aspect=true'
             ,
'Prod2',
'Gaseosa Sprite',
'Lima-lim�n 1.5 L',
1780,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE),
            (20,
             2,
'https://jumboargentina.vtexassets.com/arquivos/ids/596857-800-auto?v=637321952338700000&width=800&height=auto&aspect=true'
             ,
'Prod3',
'Helado',
'Pote Bon O Bon X250gr',
4000,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE),
            (20,
             2,
'https://jumboargentina.vtexassets.com/arquivos/ids/674442-800-auto?v=637716164583130000&width=800&height=auto&aspect=true'
             ,
'Prod4',
'Mermelada',
'Arcor Light Frutilla X390g',
2500,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE),
            (20,
             2,
'https://jumboargentina.vtexassets.com/arquivos/ids/651270-800-auto?v=637600152733670000&width=800&height=auto&aspect=true'
             ,
'Prod5',
'Caramelos Butter Toffees',
'Dulce De Leche 140g',
1500,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE),
            (21,
             3,
'https://jumboargentina.vtexassets.com/arquivos/ids/792866-800-auto?v=638300434318370000&width=800&height=auto&aspect=true'
             ,
'Prod6',
'Desodorante Dove',
'Original Antitranspirante 150 Ml',
1400,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE),
            (21,
             4,
'https://jumboargentina.vtexassets.com/arquivos/ids/792662-800-auto?v=638297949751970000&width=800&height=auto&aspect=true'
             ,
'Prod7',
'Crema Tratamiento Elvive',
'Elvive Rt5 Keratin 300gr',
4500,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE),
            (5,
             5,
'https://samsungar.vtexassets.com/arquivos/ids/191579-800-auto?width=800&height=auto&aspect=true'
             ,
'Prod8',
'Galaxy S21',
'5G Graphite 128GB',
959000,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE),
            (6,
             5,
'https://samsungar.vtexassets.com/arquivos/ids/188322-800-auto?width=800&height=auto&aspect=true'
             ,
'Prod9',
'Galaxy Book3',
'(15.6", i3, 8GB)',
1300000,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE),
            (9,
             6,
'https://medias.musimundo.com/medias/size515-148167-01.jpg?context=bWFzdGVyfGltYWdlc3wzMDMzMnxpbWFnZS9qcGVnfGg0NS9oZTAvMTA1MjcxMDEyODg0Nzgvc2l6ZTUxNV8xNDgxNjdfMDEuanBnfGQ5ODRjMzU4MThmMjJlMTVmMzIyYjczMzAwZjVjZWNjMjg3M2JkZjRjZTRkZjc2NWFlN2VlYTgyZTJkNjRiYTQ'
             ,
'Prod10',
'Lavarropas',
'Secarropas por calor. Capacidad 7kg.',
750000,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE),
            (11,
             7,
'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/38b72f141ce047dcad98ade20046cb36_9366/Remera_Badge_of_Sport_Basic_Negro_HH9000_01_laydown.jpg'
             ,
'Prod11',
'Remera Badge',
'Las remeras m�s cool, como las personas m�s cool',
30000,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE),
            (11,
             7,
'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/e785d14ee892427ea254ac4600eda2ce_9366/Buzo_con_Capucha_Essentials_Camouflage_Blanco_GL0018_01_laydown.jpg'
             ,
'Prod12',
'Buzo con capucha',
'Actualiz� tu colecci�n de ropa con este buzo con capucha de corte informal. El logo de adidas con estampado de camuflaje moderniza su imagen cl�sica.' ,
92000,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE),
            (14,
             9,
'https://www.rioshopdeco.com.ar/10856-thickbox_default/mesa-industrial-140x82x73-atakama-art-mkh140-at.jpg'
             ,
'Prod13',
'Mesa Industrial Atakama',
'Material: Madera; Contiene: Mesa industrial rectangular; Modelo: Atakama',
230000,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE),
            (15,
             10,
'https://www.rioshopdeco.com.ar/10394-thickbox_default/silla-gamer-pro-negra-y-blanca-art-2153.jpg'
             ,
'Prod14',
'Silla Gamer Pro',
'Material: Plastico, Sintetico; Contiene: Silla gamer pro; Colores: Negro con detalles en blanco',
230000,
CURRENT_TIMESTAMP,
CURRENT_TIMESTAMP, FALSE); 
