
# Puesta a punto

Dentro del módulo boot tenemos un Docker-compose, ejecutamos:

```bash
   docker-compose up 
```
Se ejecutará la aplicación junto con una base de datos postgres.

Tenemos una colección Postman en boot/postman para realizar las pruebas solicitadas junto con algunas adicionales.
Estas pruebas también se encuentran en los tests de integración en la carpeta boot.

# Tecnologías empleadas

Se ha empleado Java 17 y Spring Boot 2.7.14 debido a su estabilidad y la compatibilidad con las dependencias.

Para la reducción de código, se han utilizado Lombok y MapStruct.

Como base de datos relacional, se ha empleado PostgreSQL debido a su madurez y robustez.

Flyway ha sido utilizado para la inicialización de datos. Esta tecnología permite migrar y mantener un historial de los cambios en la base de datos.

Para los tests unitarios, se han utilizado JUnit 5, Mockito y MockMvc.

En cuanto a los tests de integración, se ha utilizado TestContainers. Esta librería crea un contenedor Docker con la imagen especificada y se elimina al finalizar la ejecución del test. Esta opción proporciona flexibilidad y asegura el uso del mismo tipo de base de datos que habría en producción para los tests de integración.

Swagger-codegen se empleó para cumplir con el estándar OpenAPI y la generación de código. También se siguió la metodología API-FIRST.

Docker se utilizó para el empaquetado de la aplicación.

# Arquitectura

Se ha empleado una arquitectura hexagonal modular.
La infraestructura de la aplicación se encuentra en las carpetas driving y driven, mientras que la lógica de negocio está en la carpeta application.

En la carpeta driving se han implementado los puertos de entrada, en este caso, la API REST.

En la carpeta driven se han implementado los puertos de salida, en este caso, la base de datos.

En la carpeta application se encuentra toda la lógica de negocio.

En la carpeta boot se encuentran las properties y el arranque de la aplicación.

Los tests unitarios están en las carpetas driving, driven y application, mientras que los tests de integración están en la carpeta boot.

# Extra
Se ha creado una excepción "PriceNotFound" en caso de que no se encuentre ningún registro en la base de datos.

Para la llamada POST, se han implementado todos los parámetros obligatorios para asegurar la correcta creación del nuevo Price en la base de datos.