package com.viewnext.kidaprojects.biblioteca1.service;

import java.util.List;

import com.viewnext.kidaprojects.biblioteca1.model.Libro;

/**
 * Interfaz que define los métodos para gestionar libros en la biblioteca.
 * 
 * <p>
 * La interfaz {@code LibroService} proporciona una API para realizar operaciones
 * relacionadas con la entidad {@code Libro} en la biblioteca. Esto incluye la
 * búsqueda de libros, la creación, actualización y eliminación de libros en la
 * base de datos.
 * </p>
 * 
 * <p>
 * Implementaciones concretas de esta interfaz proporcionan la lógica empresarial
 * necesaria para llevar a cabo estas operaciones.
 * </p>
 * 
 * <p>
 * El autor de esta interfaz es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 27 de septiembre de 2023
 */
public interface LibroService {

	public List<Libro> mostrarLibros();
	
	public Libro mostrarLibroPorIsbn(String isbn);
	
	public List<Libro> mostrarLibrosPorTitulo(String titulo);
	
	public List<Libro> mostrarLibrosPorAutor(String autor);
	
	public Libro crearLibro(Libro libro);
	
	public Libro actualizarLibro(Libro libro);
	
	public void deleteLibroPorIsbn(String isbn);
	
		
}
