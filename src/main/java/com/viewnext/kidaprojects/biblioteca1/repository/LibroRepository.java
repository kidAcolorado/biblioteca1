package com.viewnext.kidaprojects.biblioteca1.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.viewnext.kidaprojects.biblioteca1.model.Libro;

/**
 * Repositorio de datos para la entidad Libro.
 * 
 * <p>
 * El repositorio {@code LibroRepository} proporciona métodos para realizar operaciones
 * CRUD (Crear, Leer, Actualizar y Eliminar) en la base de datos relacionadas con la entidad
 * {@code Libro}. Extiende la interfaz {@code JpaRepository} de Spring Data JPA, que proporciona
 * implementaciones predeterminadas de estos métodos basados en convenciones de nomenclatura.
 * </p>
 * 
 * <p>
 * Para interactuar con la base de datos y realizar operaciones específicas, puedes agregar
 * métodos personalizados a esta interfaz y Spring Data JPA generará automáticamente
 * las consultas SQL correspondientes.
 * </p>
 * 
 * <p>
 * El autor de esta clase es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 27 de septiembre de 2023
 */
public interface LibroRepository extends JpaRepository<Libro, String>{

	
	@Query("SELECT libro FROM Libro libro WHERE libro.titulo = :titulo")
	List<Libro> findLibrosByTitulo(String titulo);
	
	@Query("SELECT libro FROM Libro libro WHERE libro.autor = :autor")
	List<Libro> findLibrosByAutor(String autor);
}
