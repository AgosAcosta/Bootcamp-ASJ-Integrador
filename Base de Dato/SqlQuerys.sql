USE Trabajo_Final

-- 1- Obtener todos los productos, mostrando nombre del producto, categoría, proveedor (razón social y codigo proveedor), precio.

SELECT p.name_product      AS 'Nombre del producto',
       cp.category_product AS 'Categoria del producto',
       s.name_supplier     AS 'Proveedor',
       s.code_supplier     AS 'Codigo del proveedor',
       p.price_product     AS 'Precio'
FROM   products p
       JOIN suppliers s
         ON S.id_supplier = p.id_supplier
       JOIN categories_products cp
         ON cp.id_category_product = p.id_category_product
ORDER  BY 'Nombre del producto'; 

-- 2 - En el listado anterior, además de los datos mostrados, traer el campo imagen aunque el producto NO tenga una. Sino tiene imagen, mostrar "-".

SELECT p.name_product             AS 'Nombre del producto',
       cp.category_product        AS 'Categoria del producto',
       s.name_supplier            AS 'Proveedor',
       s.code_supplier            AS 'Codigo del proveedor',
       p.price_product            AS 'Precio',
       Isnull(p.url_product, '-') AS 'URL de la imagen'
FROM   products p
       JOIN suppliers s
         ON S.id_supplier = p.id_supplier
       JOIN categories_products cp
         ON cp.id_category_product = p.id_category_product
ORDER  BY 'Nombre del producto'; 


-- 3- Mostrar los datos que se pueden modificar (en el front) del producto con ID = 2. 

--(No muestro Codigo y Proveedor, ya que es un campo no editable)
SELECT p.url_product         AS 'URL',
       cp.category_product   AS 'Categoria',
       p.name_product        AS 'Nombre del producto',
       p.description_product AS 'Descripcion',
       p.price_product       AS 'Precio'
FROM   products p
       JOIN suppliers s
         ON S.id_supplier = p.id_supplier
       JOIN categories_products cp
         ON cp.id_category_product = p.id_category_product
WHERE  id_product = 2; 

-- 4 - Listar todo los proveedores cuyo teléfono tenga la característica de Córdoba o que la provincia sea igual a alguna de las 3 con más proveedores.

SELECT s.name_supplier AS 'Razon Social',
       s.tel_supplier  AS 'Tel. Contacto',
       p.province      AS 'Provincia'
FROM   suppliers s
       JOIN directions d
         ON s.id_direction = d.id_direction
       JOIN provinces p
         ON d.id_province = p.id_province
WHERE  s.tel_supplier LIKE '351%'
        OR p.province IN (SELECT TOP 3 p.province AS 'Nombre'
                          FROM   suppliers s
                                 JOIN directions d
                                   ON s.id_direction = d.id_direction
                                 JOIN provinces p
                                   ON d.id_province = p.id_province
                          GROUP  BY p.province
                          ORDER  BY Count(s.id_supplier) DESC); 


-- 5 - Traer un listado de todos los proveedores que no hayan sido eliminados , y ordenados por razon social, codigo proveedor y fecha en que se dió de alta ASC.
--De este listado mostrar los datos que correspondan con su tabla del front. (REvisar como los presentos en el list)

SELECT s.url_supplier                              AS 'Logo',
       s.code_supplier                             AS 'Codigo',
       s.name_supplier                             AS 'Razon Social',
       s.web_supplier + '| | ' + s.email_supplier
       + '| | ' + CONVERT(VARCHAR, s.tel_supplier) AS 'Informacion Contacto',
       c.name_contact                              AS 'Nombre de Contacto',
       c.last_name_contact                         AS 'Apellido de Contacto'
FROM   suppliers s
       JOIN contacts c
         ON s.id_contact = c.id_contact
ORDER  BY s.name_supplier,
          s.code_supplier,
          s.created_at ASC; 


-- 6 - Obtener razon social, codigo proveedor, imagen, web, email, teléfono y los datos del contacto del proveedor con más ordenes de compra cargadas.

SELECT TOP 1 s.name_supplier                            AS 'Nombre Proveedor',
             s.code_supplier                            AS 'Codigo',
             s.url_supplier                             AS 'URL',
             s.web_supplier                             AS 'Pag. WEB',
             s.email_supplier                           AS 'Email',
             s.tel_supplier                             AS 'Telefono',
             c.name_contact + ',' + c.last_name_contact AS 'Datos Contacto',
             Count(po.id_purchase_order)                AS 'Cant. Ordenes'
FROM   suppliers s
       JOIN contacts c
         ON c.id_contact = s.id_contact
       JOIN purchase_orders po
         ON s.id_supplier = po.id_supplier
GROUP  BY s.name_supplier,
          s.code_supplier,
          s.url_supplier,
          s.web_supplier,
          s.email_supplier,
          s.tel_supplier,
          c.name_contact,
          c.last_name_contact
ORDER  BY Count(po.id_purchase_order) DESC; 

-- 7 - Mostrar la fecha emisión, nº de orden, razon social y codigo de proveedor, y la cantidad de productos de la orden 

--(Sume la cantidad final de productos).

SELECT po.date_issue_purchase_order AS 'Fecha Emision',
       po.id_purchase_order         AS 'N° Order',
       s.name_supplier              AS 'Nombre Proveedor',
       s.code_supplier              AS 'Codigo Proveedor',
       Sum(dp.quantity_detail)      AS 'Cant. Productos en Total'
FROM   suppliers s
       JOIN purchase_orders po
         ON s.id_supplier = po.id_supplier
       JOIN details_purchase_orders dp
         ON po.id_purchase_order = dp.id_purchase_order
GROUP  BY po.date_issue_purchase_order,
          po.id_purchase_order,
          s.name_supplier,
          s.code_supplier
ORDER  BY 'Fecha Emision'; 


-- 8 - En el listado anterior, diferenciar cuando una orden está Cancelada o no, y el total de la misma.

SELECT po.date_issue_purchase_order AS 'Fecha Emision',
       po.id_purchase_order         AS 'N° Order',
       s.name_supplier              AS 'Nombre Proveedor',
       s.code_supplier              AS 'Codigo Proveedor',
       Sum(dp.quantity_detail)      AS 'Cant. Productos en Total',
       po.total_purchase_order      AS 'Total',
       sp.status                    AS 'Estado'
FROM   suppliers s
       JOIN purchase_orders po
         ON s.id_supplier = po.id_supplier
       JOIN details_purchase_orders dp
         ON po.id_purchase_order = dp.id_purchase_order
       JOIN status_purchase_orders sp
         ON sp.id_status_order = po.id_status_order
GROUP  BY po.date_issue_purchase_order,
          po.id_purchase_order,
          s.name_supplier,
          s.code_supplier,
          po.total_purchase_order,
          sp.status
ORDER  BY 'Fecha Emision'; 

-- 9 - Mostrar el detalle de una orden de compra del proveedor 3, trayendo: SKU del producto, nombre producto, cantidad y subtotal.

SELECT pr.code_product                            AS 'Codigo',
       pr.name_product                            AS 'Producto',
       dp.quantity_detail                         AS 'Cantidad',
       Sum(dp.quantity_detail * pr.price_product) AS 'Subtotal'
FROM   suppliers s
       JOIN purchase_orders po
         ON s.id_supplier = po.id_supplier
       JOIN details_purchase_orders dp
         ON po.id_purchase_order = dp.id_purchase_order
       JOIN products pr
         ON pr.id_product = dp.id_product
WHERE  s.id_supplier = 3
GROUP  BY pr.code_product,
          pr.name_product,
          dp.quantity_detail; 

-- 10 - Cambiar el estado a Cancelada y la fecha de modificación a la orden de compra con ID = 1.

UPDATE purchase_orders
SET    id_status_order = (SELECT id_status_order
                          FROM   status_purchase_orders
                          WHERE  id_status_order = 2),
       update_at = '2024-01-13'
WHERE  id_purchase_order = 1; 

-- 11 - Escribir la sentencia para eliminar el producto con id = 1 (NO EJECUTAR, SÓLO MOSTRAR SENTENCIA)
/*
DELETE FROM products
WHERE  id_product = 1; 
*/