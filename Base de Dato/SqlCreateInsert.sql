--Creacion Base de dato
CREATE DATABASE Trabajo_Final
GO
--Usar base de dato
USE Trabajo_Final

CREATE TABLE conditions_afip
  (
     id_condition_afip INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
     condition         VARCHAR (50),
     created_at        DATE DEFAULT Getdate() NOT NULL,
     update_at         DATE DEFAULT Getdate() NOT NULL
  );

CREATE TABLE categories_supplier
  (
     id_category_supplier INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
     category_supplier    VARCHAR (50),
     created_at           DATE DEFAULT Getdate() NOT NULL,
     update_at            DATE DEFAULT Getdate() NOT NULL
  );

CREATE TABLE countries
  (
     id_country INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
     country    VARCHAR (50),
     created_at DATE DEFAULT Getdate() NOT NULL,
     update_at  DATE DEFAULT Getdate() NOT NULL
  );

CREATE TABLE provinces
  (
     id_province INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
     id_country  INT,
     province    VARCHAR (50),
     created_at  DATE DEFAULT Getdate() NOT NULL,
     update_at   DATE DEFAULT Getdate() NOT NULL
     FOREIGN KEY (id_country) REFERENCES countries(id_country)
  );

CREATE TABLE directions
  (
     id_direction    INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
     id_province     INT,
     street_supplier VARCHAR(50),
     num_supplier    INT,
     cp_supplier     INT,
     location        VARCHAR(50),
     created_at      DATE DEFAULT Getdate() NOT NULL,
     update_at       DATE DEFAULT Getdate() NOT NULL
     FOREIGN KEY (id_province) REFERENCES provinces(id_province)
  );

CREATE TABLE contacts
  (
     id_contact        INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
     name_contact      VARCHAR(50),
     last_name_contact VARCHAR(50),
     tel_contact       BIGINT,
     email_contact     VARCHAR(50),
     rol_contact       VARCHAR(50),
     created_at        DATE DEFAULT Getdate() NOT NULL,
     update_at         DATE DEFAULT Getdate() NOT NULL
  );

CREATE TABLE suppliers
  (
     id_supplier          INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
     id_condition_afip    INT,
     id_category_supplier INT,
     id_contact           INT,
     id_direction         INT,
     url_supplier         VARCHAR(max) NULL,
     code_supplier        VARCHAR(50),
     name_supplier        VARCHAR(50),
     cuit_supplier        BIGINT,
     web_supplier         VARCHAR(200) NULL,
     email_supplier       VARCHAR(50),
     tel_supplier         BIGINT,
     created_at           DATE DEFAULT Getdate() NOT NULL,
     update_at            DATE DEFAULT Getdate() NOT NULL
     FOREIGN KEY (id_condition_afip) REFERENCES conditions_afip(
     id_condition_afip),
     FOREIGN KEY (id_category_supplier) REFERENCES categories_supplier(
     id_category_supplier),
     FOREIGN KEY (id_contact) REFERENCES contacts(id_contact),
     FOREIGN KEY (id_direction) REFERENCES directions(id_direction)
  );

CREATE TABLE categories_products
  (
     id_category_product INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
     category_product    VARCHAR (50),
     created_at          DATE DEFAULT Getdate() NOT NULL,
     update_at           DATE DEFAULT Getdate() NOT NULL
  );

CREATE TABLE products
  (
     id_product          INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
     id_category_product INT,
     id_supplier         INT,
     url_product         VARCHAR(max) NULL,
     code_product        VARCHAR(50),
     name_product        VARCHAR(50),
     description_product VARCHAR(200),
     price_product       FLOAT,
     created_at          DATE DEFAULT Getdate() NOT NULL,
     update_at           DATE DEFAULT Getdate() NOT NULL
     FOREIGN KEY (id_supplier) REFERENCES suppliers(id_supplier),
     FOREIGN KEY (id_category_product) REFERENCES categories_products(
     id_category_product)
  );

CREATE TABLE status_purchase_orders
  (
     id_status_order INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
     status          VARCHAR(50),
     created_at      DATE DEFAULT Getdate() NOT NULL,
     update_at       DATE DEFAULT Getdate() NOT NULL
  );

CREATE TABLE purchase_orders
  (
     id_purchase_order            INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
     id_supplier                  INT,
     id_status_order              INT,
     code_purchase_order          VARCHAR(50),
     date_issue_purchase_order    DATE,
     date_delivery_purchase_order DATE,
     reception_purchase_order     VARCHAR (150),
     total_purchase_order         FLOAT,
     created_at                   DATE DEFAULT Getdate() NOT NULL,
     update_at                    DATE DEFAULT Getdate() NOT NULL
     FOREIGN KEY (id_supplier) REFERENCES suppliers(id_supplier),
     FOREIGN KEY (id_status_order) REFERENCES status_purchase_orders(
     id_status_order)
  );

CREATE TABLE details_purchase_orders
  (
     id_detail_purchase INT IDENTITY(1, 1) NOT NULL PRIMARY KEY,
     id_purchase_order  INT,
     id_product         INT,
     quantity_detail    INT,
     price_detail       FLOAT,
     created_at         DATE DEFAULT Getdate() NOT NULL,
     update_at          DATE DEFAULT Getdate() NOT NULL
     FOREIGN KEY (id_product) REFERENCES products(id_product),
     FOREIGN KEY (id_purchase_order) REFERENCES purchase_orders(
     id_purchase_order)
  ); 


------------------------------------- CREACION DE INSERT -------------------------------------------------------------------
-- SE PUEDE CARGAR TODAS LAS TABLAS JUNTAS

INSERT INTO conditions_afip
            (condition,
             created_at,
             update_at)
VALUES      ('Responsable Inscripto',
             Getdate(),
             Getdate()),
            ('Monotributista',
             Getdate(),
             Getdate()),
            ('Consumidor Final',
             Getdate(),
             Getdate()),
            ('Exento',
             Getdate(),
             Getdate()),
            ('No Responsable',
             Getdate(),
             Getdate()),
            ('Otro',
             Getdate(),
             Getdate()); 

INSERT INTO categories_supplier
            (category_supplier,
             created_at,
             update_at)
VALUES      ('Tecnologico',
             Getdate(),
             Getdate()),
            ('Alimenticio',
             Getdate(),
             Getdate()),
            ('Textil',
             Getdate(),
             Getdate()),
            ('Farmaceutico',
             Getdate(),
             Getdate()),
            ('Electrodomosticos',
             Getdate(),
             Getdate()),
            ('Automotriz',
             Getdate(),
             Getdate()),
            ('Moda',
             Getdate(),
             Getdate()),
            ('Joyeria',
             Getdate(),
             Getdate()),
            ('Muebles y Decoracion',
             Getdate(),
             Getdate()),
            ('Cosmeticos',
             Getdate(),
             Getdate()),
            ('Otro',
             Getdate(),
             Getdate()); 

INSERT INTO countries
            (country,
             created_at,
             update_at)
VALUES      ('Argentina',
             Getdate(),
             Getdate()),
            ('Uruguay',
             Getdate(),
             Getdate()),
            ('Brasil',
             Getdate(),
             Getdate()),
            ('Chile',
             Getdate(),
             Getdate()),
            ('Paraguay',
             Getdate(),
             Getdate());

INSERT INTO provinces
            (province,
             id_country,
             created_at,
             update_at)
VALUES      ('Buenos Aires',
             1,
             Getdate(),
             Getdate()), -- Provincias de Argentina
            ('Cordoba',
             1,
             Getdate(),
             Getdate()),
            ('Santa Fe',
             1,
             Getdate(),
             Getdate()),
            ('Mendoza',
             1,
             Getdate(),
             Getdate()),
            ('Tucuman',
             1,
             Getdate(),
             Getdate()),
            ('Entre Rios',
             1,
             Getdate(),
             Getdate()),
            ('Salta',
             1,
             Getdate(),
             Getdate()),
            ('Misiones',
             1,
             Getdate(),
             Getdate()),
            ('Chaco',
             1,
             Getdate(),
             Getdate()),
            ('Corrientes',
             1,
             Getdate(),
             Getdate()),
            ('Santiago del Estero',
             1,
             Getdate(),
             Getdate()),
            ('San Juan',
             1,
             Getdate(),
             Getdate()),
            ('Jujuy',
             1,
             Getdate(),
             Getdate()),
            ('Rio Negro',
             1,
             Getdate(),
             Getdate()),
            ('Formosa',
             1,
             Getdate(),
             Getdate()),
            ('Neuquen',
             1,
             Getdate(),
             Getdate()),
            ('Chubut',
             1,
             Getdate(),
             Getdate()),
            ('San Luis',
             1,
             Getdate(),
             Getdate()),
            ('Catamarca',
             1,
             Getdate(),
             Getdate()),
            ('La Rioja',
             1,
             Getdate(),
             Getdate()),
            ('La Pampa',
             1,
             Getdate(),
             Getdate()),
            ('Santa Cruz',
             1,
             Getdate(),
             Getdate()),
            ('Tierra del Fuego',
             1,
             Getdate(),
             Getdate()),
            ('Montevideo',
             2,
             Getdate(),
             Getdate()), -- Provincias de Uruguay
            ('Canelones',
             2,
             Getdate(),
             Getdate()),
            ('Maldonado',
             2,
             Getdate(),
             Getdate()),
            ('Colonia',
             2,
             Getdate(),
             Getdate()),
            ('San Jose',
             2,
             Getdate(),
             Getdate()),
            ('Rio Negro',
             2,
             Getdate(),
             Getdate()),
            ('Artigas',
             2,
             Getdate(),
             Getdate()),
            ('Sao Paulo',
             3,
             Getdate(),
             Getdate()), -- Provincias de Brasil
            ('Rio de Janeiro',
             3,
             Getdate(),
             Getdate()),
            ('Minas Gerais',
             3,
             Getdate(),
             Getdate()),
            ('Bahia',
             3,
             Getdate(),
             Getdate()),
            ('Parana',
             3,
             Getdate(),
             Getdate()),
            ('Rio Grande do Sul',
             3,
             Getdate(),
             Getdate()),
            ('Amazonas',
             3,
             Getdate(),
             Getdate()),
            ('Santiago',
             4,
             Getdate(),
             Getdate()), -- Pronvicias de Chile
            ('Valparaiso',
             4,
             Getdate(),
             Getdate()),
            ('Biobio',
             4,
             Getdate(),
             Getdate()),
            ('Coquimbo',
             4,
             Getdate(),
             Getdate()),
            ('Asuncion',
             5,
             Getdate(),
             Getdate()), -- Provincia de Paraguay
            ('Central',
             5,
             Getdate(),
             Getdate()),
            ('Cordillera',
             5,
             Getdate(),
             Getdate()),
            ('Alto Paraguay',
             5,
             Getdate(),
             Getdate()); 

INSERT INTO directions
            (street_supplier,
             num_supplier,
             cp_supplier,
             location,
             id_province,
             created_at,
             update_at)
VALUES      ('Av. Rivadavia',
             123,
             1405,
             'Buenos Aires',
             1,
             Getdate(),
             Getdate()),
            ('Rua Augusta',
             456,
             01305,
             'Sao Paulo',
             31,
             Getdate(),
             Getdate()),
            ('Avenida 18 de Julio',
             789,
             11200,
             'Montevideo',
             24,
             Getdate(),
             Getdate()),
            ('Rua Oscar Freire',
             789,
             01426,
             'Rio Janeiro',
             31,
             Getdate(),
             Getdate()),
            ('Calle Florida',
             456,
             1005,
             'Cordoba',
             2,
             Getdate(),
             Getdate()),
            ('Rambla Sur',
             123,
             20100,
             'Canelones',
             25,
             Getdate(),
             Getdate()),
            ('Avenida Paulista',
             987,
             01311,
             'Minas Gerais',
             33,
             Getdate(),
             Getdate()),
            ('Calle de la Ciudad Vieja',
             567,
             11000,
             'Artigas',
             30,
             Getdate(),
             Getdate()),
            ('Avenida Copacabana',
             456,
             22020,
             'Rio de Janeiro',
             32,
             Getdate(),
             Getdate()),
            ('Plaza Independencia',
             789,
             11000,
             'Montevideo',
             12,
             Getdate(),
             Getdate()),
            ('Calle Corrientes',
             101,
             1043,
             'Buenos Aires',
             15,
             Getdate(),
             Getdate()),
            ('Rua das Palmeiras',
             234,
             04135,
             'Sao Paulo',
             30,
             Getdate(),
             Getdate()),
            ('Av. de Mayo',
             567,
             1084,
             'Buenos Aires',
             16,
             Getdate(),
             Getdate()),
            ('Rua Bela Cintra',
             789,
             01415,
             'Sao Paulo',
             3,
             Getdate(),
             Getdate()),
            ('Rambla Mahatma Gandhi',
             101,
             20000,
             'Montevideo',
             10,
             Getdate(),
             Getdate()); 

INSERT INTO contacts
            (name_contact,
             last_name_contact,
             tel_contact,
             email_contact,
             rol_contact,
             created_at,
             update_at)
VALUES      ('Alejandro',
             'P�rez',
             3514556677,
             'alejandro.perez@gmail.com',
             'Coordinador de Compras',
             Getdate(),
             Getdate()),
            ('Ana',
             'Fern�ndez',
             3512334455,
             'ana.fernandez@hotmail.com',
             'Gerente en Recursos Humanos',
             Getdate(),
             Getdate()),
            ('Pedro',
             'Garc�a',
             3518776655,
             'pedro.garcia@gmail.com',
             'Director Financiero',
             Getdate(),
             Getdate()),
            ('Sof�a',
             'Hern�ndez',
             3515443322,
             'sofia.hernandez@gmail.com',
             'Administracion',
             Getdate(),
             Getdate()),
            ('Roberto',
             'D�az',
             3518990011,
             'roberto.diaz@gmail.com',
             'Jefe de Producci�n',
             Getdate(),
             Getdate()),
            ('Carolina',
             'Luna',
             3513445566,
             'carolina.luna@gmail.com',
             'Coordinadora de Compras',
             Getdate(),
             Getdate()),
            ('Francisco',
             'Vega',
             3518991122,
             'francisco.vega@gmail.com',
             'Administracion',
             Getdate(),
             Getdate()),
            ('Daniela',
             'Su�rez',
             3514556677,
             'daniela.suarez@gmail.com',
             'Administracion',
             Getdate(),
             Getdate()),
            ('Javier',
             'Morales',
             3512334455,
             'javier.morales@hotmail.com',
             'Gerente General',
             Getdate(),
             Getdate()),
            ('Elena',
             'Guti�rrez',
             3518776655,
             'elena.gutierrez@hotmail.com',
             'Due�a',
             Getdate(),
             Getdate()); 

INSERT INTO categories_products
            (category_product,
             created_at,
             update_at)
VALUES      ('Frutas y Verduras',
             Getdate(),
             Getdate()),
            ('Productos Lacteos',
             Getdate(),
             Getdate()),
            ('Bebidas y Jugos',
             Getdate(),
             Getdate()),
            ('Panaderia y Pasteleria',
             Getdate(),
             Getdate()),
            ('Smartphones',
             Getdate(),
             Getdate()),
            ('Computadoras Portatiles',
             Getdate(),
             Getdate()),
            ('Electronica de Consumo',
             Getdate(),
             Getdate()),
            ('Dispositivos de Audio',
             Getdate(),
             Getdate()),
            ('Electrodomesticos de Cocina',
             Getdate(),
             Getdate()),
            ('Ropa de Hombre',
             Getdate(),
             Getdate()),
            ('Ropa de Mujer',
             Getdate(),
             Getdate()),
            ('Calzado',
             Getdate(),
             Getdate()),
            ('Accesorios de Moda',
             Getdate(),
             Getdate()),
            ('Muebles de Sala',
             Getdate(),
             Getdate()),
            ('Muebles de Dormitorio',
             Getdate(),
             Getdate()),
            ('Decoracion del Hogar',
             Getdate(),
             Getdate()),
            ('Iluminacion',
             Getdate(),
             Getdate()),
            ('Repuestos y Accesorios',
             Getdate(),
             Getdate()),
            ('Aceites y Lubricantes',
             Getdate(),
             Getdate()),
            ('Alimentos Varios',
             Getdate(),
             Getdate()),
            ('Cuidado Personal',
             Getdate(),
             Getdate()); 

INSERT INTO Status_Purchase_Orders(status,created_at, update_at)
VALUES 
('Pendiente', GETDATE(), GETDATE()),
('Cancelado', GETDATE(), GETDATE()),
('Entregado', GETDATE(), GETDATE());

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
             update_at)
VALUES      (1,
             1,
             1,
             1,
'https://ams3.digitaloceanspaces.com/graffica/2023/02/cocacola-logo.jpeg',
'Prov1',
'Coca Cola SRL',
20345678901,
'http://coca-cola.com',
'info@cocacola.com',
3511234567,
Getdate(),
Getdate()),
            (1,
             1,
             2,
             2,
'https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Arcor_logo.svg/581px-Arcor_logo.svg.png'
             ,
'Prov2',
'Arcor SRL',
30512345678,
'http://arcor.com',
'info@arcor.com',
3519876543,
Getdate(),
Getdate()),
            (2,
             10,
             3,
             3,
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgcBrSKkvAgui_g7S1UL-J8AFZ-LTamau-d-qFYX3pQQ&s'
             ,
'Prov3',
'Dove SA',
40198765432,
'http://doveArg.com',
'dove@gmail.com',
3515551212,
Getdate(),
Getdate()),
            (1,
             4,
             4,
             4,
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9H-rkD3nIjBvpxvD6m_c5vaDNVEloqUmAPVcQzxxC-A&s'
             ,
'Prov4',
'Loreal Argentina SA',
50123456789,
'http://lorealArg.com',
'info@loreal.com',
3518765432,
Getdate(),
Getdate()),
            (3,
             1,
             5,
             5,
'https://images.samsung.com/is/image/samsung/assets/global/about-us/brand/logo/360_197_1.png?$FB_TYPE_B_PNG$'
             ,
'Prov5',
'Samsung SA',
60587654321,
'http://samsung.com',
'contactosamsung@gmail.com',
3512345678,
Getdate(),
Getdate()),
            (4,
             5,
             6,
             6,
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_2y6M-YsloFiFFAxenUmmE_S1rRRxEU5RXXrCHqMlpZfbe0vNL4qbl4f-_g&s'
             ,
'Prov6',
'WhirlPool Argentina SA',
70321098765,
'http://WhirlPoolArgentina.com',
'WhirlPoolArgentina@hotmail.com',
3518901234,
Getdate(),
Getdate()),
            (1,
             3,
             7,
             7,
'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM8eUfBUXVsOR5irjwFJEx_JPC57_u0lfkUIwJs9KwxLdtfvbYwHLJDp-zrg&s'
             ,
'Prov7',
'Adidas SRL',
80365432109,
'http://adidas.com',
'info@adidas.com',
3512345678,
Getdate(),
Getdate()),
            (5,
             8,
             8,
             8,
             NULL,
             'Prov8',
             'Juanita Perez',
             90987654321,
             'http://tiendanubeJuanita.com',
             'juani@hotmail.com',
             3518765432,
             Getdate(),
             Getdate()),
            (1,
             9,
             9,
             9,
             NULL,
             'Prov9',
             'Todo Muebles SRL',
             '30123456789',
             'http://todomuebles.com',
             'muebles@hotmail.com',
             3512345678,
             Getdate(),
             Getdate()),
            (2,
             9,
             10,
             10,
             NULL,
             'prov10',
             'Todo Sillas',
             '30987654321',
             'http://todosillas.com',
             'sillas@hotmail.com',
             3518765432,
             Getdate(),
             Getdate()); 

INSERT INTO products
            (id_category_product,
             id_supplier,
             url_product,
             code_product,
             name_product,
             description_product,
             price_product,
             created_at,
             update_at)
VALUES      (3,
             1,
'https://jumboargentina.vtexassets.com/arquivos/ids/783070-800-auto?v=638206690815300000&width=800&height=auto&aspect=true'
             ,
'Prod1',
'Gaseosa Coca-cola',
'Sabor Original 2.25 L',
2200,
Getdate(),
Getdate()),
            (3,
             1,
'https://jumboargentina.vtexassets.com/arquivos/ids/784006-800-auto?v=638215869813300000&width=800&height=auto&aspect=true'
             ,
'Prod2',
'Gaseosa Sprite',
'Lima-lim�n 1.5 L',
1780,
Getdate(),
Getdate()),
            (20,
             2,
'https://jumboargentina.vtexassets.com/arquivos/ids/596857-800-auto?v=637321952338700000&width=800&height=auto&aspect=true'
             ,
'Prod3',
'Helado',
'Pote Bon O Bon X250gr',
4000,
Getdate(),
Getdate()),
            (20,
             2,
'https://jumboargentina.vtexassets.com/arquivos/ids/674442-800-auto?v=637716164583130000&width=800&height=auto&aspect=true'
             ,
'Prod4',
'Mermelada',
'Arcor Light Frutilla X390g',
2500,
Getdate(),
Getdate()),
            (20,
             2,
'https://jumboargentina.vtexassets.com/arquivos/ids/651270-800-auto?v=637600152733670000&width=800&height=auto&aspect=true'
             ,
'Prod5',
'Caramelos Butter Toffees',
'Dulce De Leche 140g',
1500,
Getdate(),
Getdate()),
            (21,
             3,
'https://jumboargentina.vtexassets.com/arquivos/ids/792866-800-auto?v=638300434318370000&width=800&height=auto&aspect=true'
             ,
'Prod6',
'Desodorante Dove',
'Original Antitranspirante 150 Ml',
1400,
Getdate(),
Getdate()),
            (21,
             4,
'https://jumboargentina.vtexassets.com/arquivos/ids/792662-800-auto?v=638297949751970000&width=800&height=auto&aspect=true'
             ,
'Prod7',
'Crema Tratamiento Elvive',
'Elvive Rt5 Keratin 300gr',
4500,
Getdate(),
Getdate()),
            (5,
             5,
'https://samsungar.vtexassets.com/arquivos/ids/191579-800-auto?width=800&height=auto&aspect=true'
             ,
'Prod8',
'Galaxy S21',
'5G Graphite 128GB',
959000,
Getdate(),
Getdate()),
            (6,
             5,
'https://samsungar.vtexassets.com/arquivos/ids/188322-800-auto?width=800&height=auto&aspect=true'
             ,
'Prod9',
'Galaxy Book3',
'(15.6", i3, 8GB)',
1300000,
Getdate(),
Getdate()),
            (9,
             6,
'https://medias.musimundo.com/medias/size515-148167-01.jpg?context=bWFzdGVyfGltYWdlc3wzMDMzMnxpbWFnZS9qcGVnfGg0NS9oZTAvMTA1MjcxMDEyODg0Nzgvc2l6ZTUxNV8xNDgxNjdfMDEuanBnfGQ5ODRjMzU4MThmMjJlMTVmMzIyYjczMzAwZjVjZWNjMjg3M2JkZjRjZTRkZjc2NWFlN2VlYTgyZTJkNjRiYTQ'
             ,
'Prod10',
'Lavarropas',
'Secarropas por calor. Capacidad 7kg.',
750000,
Getdate(),
Getdate()),
            (11,
             7,
'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/38b72f141ce047dcad98ade20046cb36_9366/Remera_Badge_of_Sport_Basic_Negro_HH9000_01_laydown.jpg'
             ,
'Prod11',
'Remera Badge',
'Las remeras m�s cool, como las personas m�s cool',
30000,
Getdate(),
Getdate()),
            (11,
             7,
'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/e785d14ee892427ea254ac4600eda2ce_9366/Buzo_con_Capucha_Essentials_Camouflage_Blanco_GL0018_01_laydown.jpg'
             ,
'Prod12',
'Buzo con capucha',
'Actualiz� tu colecci�n de ropa con este buzo con capucha de corte informal. El logo de adidas con estampado de camuflaje moderniza su imagen cl�sica.' ,
92000,
Getdate(),
Getdate()),
            (14,
             9,
'https://www.rioshopdeco.com.ar/10856-thickbox_default/mesa-industrial-140x82x73-atakama-art-mkh140-at.jpg'
             ,
'Prod13',
'Mesa Industrial Atakama',
'Material: Madera; Contiene: Mesa industrial rectangular; Modelo: Atakama',
230000,
Getdate(),
Getdate()),
            (15,
             10,
'https://www.rioshopdeco.com.ar/10394-thickbox_default/silla-gamer-pro-negra-y-blanca-art-2153.jpg'
             ,
'Prod14',
'Silla Gamer Pro',
'Material: Pl�stico, Sint�tico; Contiene: Silla gamer pro; Colores: Negro con detalles en blanco',
230000,
Getdate(),
Getdate()); 

INSERT INTO purchase_orders
            (id_supplier,
             id_status_order,
             code_purchase_order,
             date_issue_purchase_order,
             date_delivery_purchase_order,
             reception_purchase_order,
             total_purchase_order,
             created_at,
             update_at)
VALUES      (1,
             1,
             'Orden1',
             '2024-01-10',
             '2024-01-15',
             'Tocar el timbre',
             18960,
             Getdate(),
             Getdate()),
            (2,
             1,
             'Orden2',
             '2024-01-12',
             '2024-01-18',
             'Dejar en la puerta',
             27000,
             Getdate(),
             Getdate()),
            (3,
             2,
             'Orden3',
             '2024-01-14',
             '2024-01-20',
             'Llamar al tel�fono',
             2800,
             Getdate(),
             Getdate()),
            (4,
             2,
             'Orden4',
             '2024-01-16',
             '2024-01-22',
             'Avisar cuando salga el pedido',
             9000,
             Getdate(),
             Getdate()),
            (5,
             1,
             'Orden5',
             '2024-01-18',
             '2024-01-25',
             'Entregar al portero',
             2259000,
             Getdate(),
             Getdate()),
            (7,
             1,
             'Orden6',
             '2024-01-20',
             '2024-01-28',
             'Avisar cuando salga el pedido',
             30000,
             Getdate(),
             Getdate()),
            (9,
             2,
             'Orden7',
             '2023-11-19',
             '2023-11-28',
             NULL,
             460000,
             Getdate(),
             Getdate()),
            (10,
             2,
             'Orden8',
             '2023-07-19',
             '2023-07-28',
             NULL,
             460000,
             Getdate(),
             Getdate()),
            (7,
             2,
             'Orden9',
             '2022-10-20',
             '2022-11-01',
             'Entregar al portero',
             92000,
             Getdate(),
             Getdate()),
            (6,
             2,
             'Orden10',
             '2022-11-20',
             '2022-11-25',
             'Venir con ayuda para bajarlo',
             750000,
             Getdate(),
             Getdate()); 

INSERT INTO details_purchase_orders
            (id_purchase_order,
             id_product,
             quantity_detail,
             price_detail,
             created_at,
             update_at)
VALUES      (1,
             1,
             7,
             15400,
             Getdate(),
             Getdate()),
            (1,
             2,
             2,
             3560,
             Getdate(),
             Getdate()),
            (2,
             3,
             2,
             8000,
             Getdate(),
             Getdate()),
            (2,
             4,
             4,
             10000,
             Getdate(),
             Getdate()),
            (2,
             5,
             6,
             9000,
             Getdate(),
             Getdate()),
            (3,
             6,
             2,
             2800,
             Getdate(),
             Getdate()),
            (4,
             7,
             2,
             9000,
             Getdate(),
             Getdate()),
            (5,
             8,
             1,
             959000,
             Getdate(),
             Getdate()),
            (5,
             9,
             1,
             1300000,
             Getdate(),
             Getdate()),
            (6,
             11,
             1,
             30000,
             Getdate(),
             Getdate()),
            (7,
             13,
             2,
             460000,
             Getdate(),
             Getdate()),
            (8,
             14,
             2,
             460000,
             Getdate(),
             Getdate()),
            (9,
             7,
             1,
             92000,
             Getdate(),
             Getdate()),
            (10,
             6,
             1,
             750000,
             Getdate(),
             Getdate());


