# BIBLIOTECA1 - Documentación

## Descripción
Este proyecto es una aplicación de ejemplo que implementa un CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar libros. La aplicación permite realizar las siguientes operaciones:

- Obtener la lista de todos los libros.
- Obtener un libro por su ISBN.
- Obtener una lista de libros por su título.
- Obetner una lista de libros por su autor.
- Crear un nuevo libro.
- Actualizar la información de un libro.
- Eliminar un libro por su ISBN.


La aplicación está construida en Java y utiliza Spring Boot para crear un servicio REST que expone las operaciones mencionadas.

## Estructura del Proyecto
El proyecto está organizado de la siguiente manera:

- `src/main/java/com/viewnext/kidaprojects/biblioteca1/model`: Contiene la clase `Libro`, que representa el modelo de datos de un libro.
- `src/main/java/com/viewnext/kidaprojects/biblioteca1/service`: Contiene la interfaz `LibroService` y su implementación `LibroServiceImpl`, que define y realiza las operaciones de gestión de libros.

- `src/main/java/com/viewnext/kidaprojects/biblioteca1/controller`: Contiene el controlador REST `LibroRestController`, que define los puntos de entrada de la API y gestiona las solicitudes HTTP.
- `src/main/java/com/viewnext/kidaprojects/biblioteca1/biblioteca1Application.java`: La clase principal que inicia la aplicación Spring Boot.


## Instrucciones de Uso
Puedes utilizar esta aplicación para realizar operaciones CRUD en libros. Aquí hay algunos ejemplos de cómo usarla:

### Obtener la lista de todos los libros
- Método: GET
- URL: `http://localhost:8080/libros`

### Obtener un libro por su ISBN
- Método: GET
- URL: `http://localhost:8080/libro/{isbn}`

### Obtener una lista de libros por su título
- Método: GET
- URL: `http://localhost:8080/libro/titulo/{titulo}`

### Obtener una lista de libros por su autor
- Método: GET
- URL: `http://localhost:8080/libro/autor/{autor}`

### Dar de alta un nuevo libro
- Método: POST
- URL: `http://localhost:8080/libro`
- Cuerpo de la solicitud (JSON):
```json
{
  "isbn": "50",
  "titulo": "Wesel wesel",
  "autor": "El barto"
  "precio": 25
}

### Actualizar la información de un libro
- Método: PUT
- URL: `http://localhost:8080/libro`
- Cuerpo de la solicitud (JSON):
```json
{
  "isbn": "50",
  "titulo": "Wesel wesel 2",
  "autor": "El barto"
  "precio": 32
}


### Eliminar un libro por su ISBN
- Método: DELETE
- URL: `http://localhost:8080/libro/{isbn}`

### Uso de Postman
Puedes utilizar herramientas como [Postman](https://www.postman.com/) para probar y consumir la API de manera más conveniente. Simplemente crea solicitudes HTTP en Postman con las URL y los datos de solicitud correspondientes.

## Requisitos
Asegúrate de tener instalado lo siguiente antes de ejecutar la aplicación:

- Java 8 o superior.
- Eclipse o cualquier otro IDE de tu elección.
- Maven para gestionar las dependencias del proyecto.

## Ejecución
Para ejecutar la aplicación, sigue estos pasos:

Abre el proyecto en tu IDE (por ejemplo, Eclipse).

1. Busca la clase `Biblioteca1Application` en el paquete `com.viewnext.kidaprojects.biblioteca1`.

2. Haz clic derecho en la clase y selecciona "Run as" (Ejecutar como) > "Java Application" (Aplicación Java).

3. La aplicación se iniciará en `http://localhost:8080`. Puedes acceder a la API utilizando las URL mencionadas anteriormente.

## Contribución
Si deseas contribuir a este proyecto, ¡te damos la bienvenida! Puedes fork el repositorio y enviar tus contribuciones a través de pull requests.

## Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para obtener más detalles.

¡Gracias por usar `biblioteca1`!