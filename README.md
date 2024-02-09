# Proyect Integrador Final

Desarrollo de un *Sistema de Gestión Compras* para manejar información de Proveedores, Productos y Órdenes de compra. Además de poder gestionar los rubros de proveedores y categorías de productos.

## Ejecutar localmente

Pasos necesarios para correr el proyecto localmente:

- Crear una base de datos llamada:
```sql
  CREATE DATABASE bd_proyecto;
```
- En el proyecto de Java se debe ejecutar:
  1. En el archivo POM:
  Boton derecho -> Run As -> 4 Maven Install
  
  2. Cambiar credenciales en application.properties:

  src/main/resources -> application.properties, cambiar el primer reglon por el siguiente
```java
  spring.datasource.url = jdbc:sqlserver://localhost;encrypt=false;user=*NOMBRE DE USUARIO DE SQL*;password=*CONTRASEÑA DE SQL*;databaseName=bd_proyecto
```
  3. Ejecutar proyecto (*puerto 8080*). Para verificar que este corriendo de manera existosa, se puede verificar en consola que muestre el mensaje de "Proyecto Funcionando" o se puede probar algunas de las siguientes URL:

  *http://localhost:8080/supplier -> Verifica los proveedores activos.
  *http://localhost:8080/product -> Verifica los productos activos.
  *http://localhost:8080/purchaseOrder -> Verifica las ordenes de compra pendientes.

- En el proyecto de Angular se debe ejecutar:
  1. Dentro del proyecto de Angular se debe ejecutar en Terminal el comando:
```javascript
 npm install
```
  2. Ejecutar proyecto (*puerto 4200*) con el comando
  ```angular
 ng s -o
  ```
Automaticamente se va abrir el proyecto en el navegador de preferencia.


Clave de acceso al proyecto (Login):
user: usuario
password: 123456


## Este proyecto fue desarrollado por: **Agostina Acosta**
