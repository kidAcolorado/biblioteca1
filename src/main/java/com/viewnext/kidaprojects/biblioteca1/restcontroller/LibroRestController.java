package com.viewnext.kidaprojects.biblioteca1.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.kidaprojects.biblioteca1.model.Libro;
import com.viewnext.kidaprojects.biblioteca1.service.LibroserviceImpl;

import jakarta.persistence.EntityNotFoundException;

/**
 * Clase que actúa como controlador REST para la gestión de libros en la
 * biblioteca.
 * 
 * <p>
 * El controlador {@code LibroRestController} proporciona una API REST para
 * realizar operaciones relacionadas con la entidad {@code Libro} en la
 * biblioteca. Esto incluye la búsqueda de libros por ISBN, título, autor, la
 * creación, actualización y eliminación de libros en la base de datos.
 * </p>
 * 
 * <p>
 * Este controlador utiliza inyección de dependencias para acceder al servicio
 * {@code LibroService}, que contiene la lógica empresarial para gestionar los
 * libros.
 * </p>
 * 
 * <p>
 * El autor de esta clase es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 27 de septiembre de 2023
 */
@RestController
public class LibroRestController {

	@Autowired
	private LibroserviceImpl libroService;

	private static final String LIBRO_NOT_FOUND = "Libro con los argumentos introducidos no encontrado";
	private static final String INVALID_PRECIO = "Formato de argumento(Precio) inválido";

	/**
	 * Obtiene una lista de todos los libros disponibles y devuelve una respuesta
	 * HTTP con la lista en formato JSON.
	 *
	 * @return Una respuesta HTTP con la lista de libros en formato JSON.
	 */
	@GetMapping(value = "libros", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> mostrarLibros() {
		List<Libro> listaLibros = libroService.findAll();

		return ResponseEntity.ok(listaLibros);
	}

	/**
	 * Busca un libro por su número de ISBN y devuelve una respuesta HTTP con el
	 * libro encontrado en formato JSON. Si el libro no se encuentra, se devuelve
	 * una respuesta HTTP con estado "NOT FOUND".
	 *
	 * @param isbn El número de ISBN del libro que se desea buscar.
	 * @return Una respuesta HTTP con el libro encontrado en formato JSON o una
	 *         respuesta "NOT FOUND" si el libro no se encuentra.
	 */
	@GetMapping(value = "libro/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> mostrarLibroByIsbn(@PathVariable("isbn") String isbn) {

		try {
			Libro libro = libroService.mostrarLibroPorIsbn(isbn);
			return ResponseEntity.ok(libro);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(LIBRO_NOT_FOUND);
		}

	}

	/**
	 * Busca libros por su título y devuelve una respuesta HTTP con la lista de
	 * libros encontrados en formato JSON. Si no se encuentran libros con el título
	 * especificado, se devuelve una respuesta HTTP con estado "NOT FOUND".
	 *
	 * @param titulo El título de los libros que se desean buscar.
	 * @return Una respuesta HTTP con la lista de libros encontrados en formato JSON
	 *         o una respuesta "NOT FOUND" si no se encuentran libros con el título
	 *         especificado.
	 */
	@GetMapping(value = "libro/titulo/{titulo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> mostrarLibroByTitulo(@PathVariable("titulo") String titulo) {
		try {
			List<Libro> listaLibrosByTitulo = libroService.mostrarLibrosPorTitulo(titulo);
			return ResponseEntity.ok(listaLibrosByTitulo);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(LIBRO_NOT_FOUND);
		}

	}

	/**
	 * Busca libros por el nombre del autor y devuelve una respuesta HTTP con la
	 * lista de libros encontrados en formato JSON. Si no se encuentran libros
	 * escritos por el autor especificado, se devuelve una respuesta HTTP con estado
	 * "NOT FOUND".
	 *
	 * @param autor El nombre del autor de los libros que se desean buscar.
	 * @return Una respuesta HTTP con la lista de libros escritos por el autor
	 *         encontrado en formato JSON o una respuesta "NOT FOUND" si no se
	 *         encuentran libros escritos por el autor especificado.
	 */
	@GetMapping(value = "libro/autor/{autor}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> mostrarLibrosByAutor(@PathVariable("autor") String autor) {
		try {
			List<Libro> listaLibrosByAutor = libroService.mostrarLibrosPorAutor(autor);
			return ResponseEntity.ok(listaLibrosByAutor);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(LIBRO_NOT_FOUND);
		}

	}

	/**
	 * Crea un nuevo libro en la base de datos a partir de los datos proporcionados
	 * en el cuerpo de la solicitud HTTP.
	 *
	 * @param libroForCreate El objeto {@code Libro} que se desea crear y guardar en la base
	 *              de datos.
	 * @return Una respuesta HTTP con el libro creado en formato JSON.
	 * @throws NumberFormatException Si el precio proporcionado no es un número válido.
	 */
	@PostMapping(value = "libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createLibro(@RequestBody Libro libroForCreate) {
	    try {
	        Libro libroCreado = libroService.crearLibro(libroForCreate);
	        return ResponseEntity.ok(libroCreado);
	    } catch (NumberFormatException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(INVALID_PRECIO);
	    }
	}

	/**
	 * Actualiza la información de un libro existente en la base de datos a partir
	 * de los datos proporcionados en el cuerpo de la solicitud HTTP.
	 *
	 * @param libroForUpdate El objeto {@code Libro} con la información actualizada
	 *                       del libro.
	 * @return Una respuesta HTTP con el libro actualizado en formato JSON.
	 * @throws EntityNotFoundException Si el libro a actualizar no se encuentra en la base de datos.
	 * @throws NumberFormatException Si el precio proporcionado no es un número válido.
	 */
	@PutMapping(value = "libro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateLibro(@RequestBody Libro libroForUpdate) {
	    try {
	        Libro libroActualizado = libroService.actualizarLibro(libroForUpdate);
	        return ResponseEntity.ok(libroActualizado);
	    } catch (EntityNotFoundException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(LIBRO_NOT_FOUND);
	    } catch (NumberFormatException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(INVALID_PRECIO);
	    }
	}


	/**
	 * Elimina un libro de la base de datos por su número de ISBN.
	 *
	 * @param isbn El número de ISBN del libro que se desea eliminar.
	 * @return Una respuesta HTTP sin contenido (204 No Content) si la eliminación
	 *         fue exitosa, o una respuesta "NOT FOUND" si el libro no se encuentra.
	 */
	@DeleteMapping(value = "libro/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteLibro(@PathVariable("isbn") String isbn) {

		try {
			libroService.deleteLibroPorIsbn(isbn);

			return ResponseEntity.noContent().build();

		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(LIBRO_NOT_FOUND);
		} 

	}

}
