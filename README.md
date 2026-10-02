# POO - Conexión JavaFX con MySQL

## Descripción

En este proyecto realicé la conexión de una aplicación de escritorio desarrollada con JavaFX a una base de datos MySQL.

Para la actividad utilicé la base de datos `cotizaciones_db` y seleccioné la tabla `contactos`, la cual contiene los registros enviados desde el formulario de contacto del proyecto web.

La aplicación consulta los datos almacenados en MySQL y los muestra mediante un TableView en JavaFX.

## Tecnologías utilizadas

- Java 21
- JavaFX
- MySQL 8.0
- MySQL Connector/J
- Maven
- IntelliJ IDEA
- Docker
- MySQL Workbench

## Base de datos

Base de datos utilizada:

`cotizaciones_db`

Tabla seleccionada:

`contactos`

La tabla contiene los siguientes campos:

- id
- nombre
- email
- asunto
- mensaje
- creado_en

Para obtener los registros se utiliza la consulta:

```sql
SELECT * FROM contactos;