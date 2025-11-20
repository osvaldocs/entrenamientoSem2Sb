# Proyecto H2 Spring Boot - Catálogo Persistente de Eventos

## Descripción

Este proyecto es una **API RESTful** de un catálogo de eventos con persistencia en **H2 Database**. Permite gestionar **Eventos** y sus **Venues**, incluyendo operaciones CRUD, validaciones, paginación y documentación con **Swagger/OpenAPI**.

Está desarrollado como parte de un proyecto de aprendizaje y práctica de **Spring Boot, JPA, H2, MapStruct y Validaciones**.

---

## Stack Tecnológico

* **Java 17**
* **Spring Boot 3.5.7**
* **Spring Data JPA**
* **H2 Database** (in-memory)
* **MapStruct** (mapeo DTO ↔ Entity)
* **Jakarta Validation** (`@Valid`, `@NotBlank`, etc.)
* **Swagger / OpenAPI** (`springdoc-openapi`)
* **Lombok**
* **Maven** como gestor de dependencias

---

## Estructura del Proyecto

```
com.riwi.H2
├── controller       # Endpoints REST (EventController)
├── dto              # Data Transfer Objects (EventDTO, VenueDTO)
├── exception        # Manejo de errores (BadRequestException, ResourceNotFoundException)
├── mapper           # MapStruct mappers (EventVenueMapper)
├── model
│   └── entity       # Entidades JPA (EventEntity, VenueEntity)
├── repository
│   └── interfaces   # Repositorios JPA (EventRepository, VenueRepository)
└── service
    ├── EventService
    └── impl         # Implementación de servicios (EventServiceImpl)
```

---

## Endpoints

Todos los endpoints se exponen bajo `/events`.

| Método | Ruta           | Descripción                    | Código Respuesta     |
| ------ | -------------- | ------------------------------ | -------------------- |
| GET    | `/events`      | Obtener todos los eventos      | 200 OK               |
| GET    | `/events/{id}` | Obtener un evento por ID       | 200 OK / 404         |
| POST   | `/events`      | Crear un nuevo evento          | 201 Created / 400    |
| PUT    | `/events/{id}` | Actualizar un evento existente | 200 OK / 400 / 404   |
| DELETE | `/events/{id}` | Eliminar un evento             | 204 No Content / 404 |

> Los endpoints incluyen validaciones y manejo de errores mediante excepciones personalizadas.

---

## Swagger / OpenAPI

La documentación interactiva se encuentra en:

```
http://localhost:8080/swagger-ui.html
```

O bien, usando **SpringDoc OpenAPI**:

```
http://localhost:8080/v3/api-docs
```

Allí podrás ver los endpoints, códigos de respuesta, ejemplos y modelos DTO.

---

## Ejemplos de uso (JSON)

**Crear evento**

```json
POST /events
{
  "name": "Concierto Rock",
  "date": "2025-12-10",
  "venueId": 1
}
```

**Respuesta**

```json
{
  "id": 1,
  "name": "Concierto Rock",
  "date": "2025-12-10",
  "venueId": 1
}
```

---

## Instalación y Ejecución

1. Clonar el repositorio:

```bash
git clone <url_del_repositorio>
cd H2
```

2. Construir el proyecto con Maven:

```bash
mvn clean install
```

3. Ejecutar la aplicación:

```bash
mvn spring-boot:run
```

4. Acceder a la API en:

```
http://localhost:8080/events
```

5. Acceder a Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

---

## Consideraciones

* La base de datos H2 es **in-memory**, por lo que los datos se pierden al detener la aplicación.
* Validaciones activas con **Jakarta Validation** (`@NotBlank`, `@Future`, etc.)
* MapStruct se utiliza para mapear entre **Entity ↔ DTO** de manera eficiente.
* Manejo global de errores mediante excepciones personalizadas.
* Preparado para integración futura con Spring Data JPA persistente.

---

## Autores

* **Pablo Campos** - Desarrollo Backend / Servicios REST
* Proyecto educativo para **Riwi Bootcamp**.

---

## Licencia

Proyecto de aprendizaje, sin licencia específica.
