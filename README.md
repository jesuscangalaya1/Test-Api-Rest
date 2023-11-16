
# Sistema para administrar productos en el inventario.

"CRUD documentado en Swagger, con validaciones,
excepciones, exportación a PDF y Excel, y gestión
de inventario."

## Tecnologias

- **Java Development Kit (JDK) 17:** Asegúrese de tener instalado JDK 17 en su sistema. Puede descargarlo desde [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) o [OpenJDK](https://adoptopenjdk.net/).

- **Spring Boot: 2.7.15**.

- **Base de datos MySQL**.

- **Swagger: http://localhost:8080/swagger-ui/index.html**


## Funciones

- CRUD de Producto.
- Validaciones básicas.
- Documentación con Swagger.
- Base de Datos MySql.
- Reportes a PDF y EXCEL con PAGINACIÓN.
- Eliminación lógica.
  ![Eliminación l´ógica](src/main/resources/static/img_deleted.png)
- Uso de DTO para tranferencia de datos.
- MapStruct para simplificar mapeo de objetos Java y obtener un mejor performance a diferencia a otras librerias.
- @RestControllerAdvice para manejar excepciones globales en mi proyecto.
- Paginación eficiente para no sobrecargar con mucha data.
- Uso de Constantes para Mejor Legibilidad.
- Utilización de Genéricos para Flexibilidad.
- Campos validados:
  ![Validaciones de campos](src/main/resources/static/img_9.png)




## Screenshots

![Vista Previa de la Aplicación](src/main/resources/static/img_6.png)

En la imagen de arriba,se ejecutara la aplicación y se insertarán automáticamente 5 productos por defecto.


![Base de Datos MYSQL](src/main/resources/static/img_7.png)

En la imagen de arriba, se muestra la interfaz de Workbench de la base de datos MySQL con los 5 datos.


![Documentación de Endpoints con Swagger](src/main/resources/static/img_8.png)

La imagen anterior muestra la documentación de todos los endpoints de la API, que se encuentra en `http://localhost:8080/swagger-ui/index.html`.










