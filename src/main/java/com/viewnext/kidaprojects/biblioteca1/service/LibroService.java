package com.viewnext.kidaprojects.biblioteca1.service;

import java.util.List;

import com.viewnext.kidaprojects.biblioteca1.model.Libro;

public interface LibroService {

	public List<Libro> mostrarLibros();
	
	public Libro mostrarLibroPorIsbn(String isbn);
	
	public List<Libro> mostrarLibrosPorTitulo(String titulo);
	
	public List<Libro> mostrarLibrosPorAutor(String autor);
	
	public Libro crearLibro(Libro libro);
	
	public Libro actualizarLibro(Libro libro);
	
	public void deleteLibroPorIsbn(String isbn);
		
	
}
