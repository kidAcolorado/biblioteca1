package com.viewnext.kidaprojects.biblioteca1.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.viewnext.kidaprojects.biblioteca1.model.Libro;
import com.viewnext.kidaprojects.biblioteca1.repository.LibroRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * Servicio de gestión de libros en la biblioteca.
 * 
 * <p>
 * El servicio {@code Libroservice} proporciona métodos para realizar
 * operaciones relacionadas con la entidad {@code Libro}. Esta clase implementa
 * la interfaz {@code LibroRepository} y, por lo tanto, proporciona métodos de
 * acceso a la base de datos para interactuar con los libros.
 * </p>
 * 
 * <p>
 * El autor de esta clase es [Tu Nombre].
 * </p>
 *
 * @version 1.0
 * @since 27 de septiembre de 2023
 */
@Service
public class LibroserviceImpl implements LibroRepository, LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	
	//###########################################################
	//################### MÉTODOS DE BÚSQUEDA ###################
	//###########################################################
	
	/**
	 * Recupera una lista de todos los libros en la base de datos.
	 *
	 * @return Una lista de objetos {@code Libro} que representan todos los libros
	 *         en la base de datos.
	 */
	@Override
	public List<Libro> findAll() {
		return libroRepository.findAll();
	}
	
	
	/**
	 * Recupera una lista de todos los libros en la base de datos.
	 *
	 * @return Una lista de objetos {@code Libro} que representan todos los libros
	 *         en la base de datos.
	 */
	@Override
	public List<Libro> mostrarLibros(){
		return libroRepository.findAll();
	}
	
	

	/**
	 * Busca un libro en la base de datos por su identificador (ISBN).
	 *
	 * @param id El identificador (ISBN) del libro que se desea buscar.
	 * @return Un objeto {@code Optional<Libro>} que contiene el libro si se
	 *         encuentra, o un valor vacío si no se encuentra.
	 */
	@Override
	public Optional<Libro> findById(String id) {

		return libroRepository.findById(id);
	}
	
	
	/**
	 * Busca un libro en la base de datos por su número de ISBN y lo devuelve.
	 *
	 * @param isbn El número de ISBN del libro que se desea buscar.
	 * @return Un objeto {@code Libro} que representa el libro si se encuentra.
	 * @throws EntityNotFoundException Si no se encuentra ningún libro con el número
	 *                                 de ISBN especificado.
	 */
	@Override
	public Libro mostrarLibroPorIsbn(String isbn) throws EntityNotFoundException {
		Optional<Libro> optionalLibro = findById(isbn);

		if (optionalLibro.isPresent()) {
			return optionalLibro.get();
		} else {
			throw new EntityNotFoundException();
		}

	}
	

	/**
	 * Busca libros en la base de datos por el título y devuelve una lista de los libros que coinciden.
	 *
	 * @param titulo El título de los libros que se desea buscar.
	 * @return Una lista de objetos {@code Libro} que representan los libros con el título especificado.
	 */
	@Override
	public List<Libro> findLibrosByTitulo(String titulo) {
	    return libroRepository.findLibrosByTitulo(titulo);
	}

	/**
	 * Busca libros en la base de datos por el título y devuelve una lista de los libros que coinciden.
	 *
	 * @param titulo El título de los libros que se desea buscar.
	 * @return Una lista de objetos {@code Libro} que representan los libros con el título especificado.
	 * @throws EntityNotFoundException Si no se encuentran libros con el título especificado.
	 */
	@Override
	public List<Libro> mostrarLibrosPorTitulo(String titulo) throws EntityNotFoundException {
	    List<Libro> listaLibrosByTitulo = libroRepository.findLibrosByTitulo(titulo);

	    if (listaLibrosByTitulo.isEmpty()) {
	        throw new EntityNotFoundException();
	    } 

	    return listaLibrosByTitulo;
	}

	/**
	 * Busca libros en la base de datos por el nombre del autor y devuelve una lista de los libros que coinciden.
	 *
	 * @param autor El nombre del autor de los libros que se desea buscar.
	 * @return Una lista de objetos {@code Libro} que representan los libros escritos por el autor especificado.
	 */
	@Override
	public List<Libro> findLibrosByAutor(String autor) {
	    return libroRepository.findLibrosByAutor(autor);
	}

	/**
	 * Busca libros en la base de datos por el nombre del autor y devuelve una lista de los libros que coinciden.
	 *
	 * @param autor El nombre del autor de los libros que se desea buscar.
	 * @return Una lista de objetos {@code Libro} que representan los libros escritos por el autor especificado.
	 * @throws EntityNotFoundException Si no se encuentran libros escritos por el autor especificado.
	 */
	@Override
	public List<Libro> mostrarLibrosPorAutor(String autor) throws EntityNotFoundException {
	    List<Libro> listaLibrosByAutor = libroRepository.findLibrosByAutor(autor);

	    if (listaLibrosByAutor.isEmpty()) {
	        throw new EntityNotFoundException();
	    } 

	    return listaLibrosByAutor;
	}

	
	
	//###########################################################
	//################### MÉTODOS DE CREACIÓN ###################
	//###########################################################
	
	/**
	 * Guarda un libro en la base de datos.
	 *
	 * @param entity El objeto {@code Libro} que se desea guardar en la base de datos.
	 * @return El objeto {@code Libro} guardado en la base de datos.
	 */
	@Override
	public <S extends Libro> S save(S entity) {
		libroRepository.save(entity);
		return entity;
	}
	
	/**
	 * Crea un nuevo libro en la base de datos a partir de los datos proporcionados.
	 *
	 * @param libro El objeto {@code Libro} que se desea crear y guardar en la base de datos.
	 * @return El libro creado y guardado en la base de datos.
	 */
	@Override
	public Libro crearLibro(Libro libro) {
		libroRepository.save(libro);
		return libro;
	}
	
	
	
	
	
	//###########################################################
	//################### MÉTODOS DE BORRADO ####################
	//###########################################################
	
	
	
	/**
	 * Verifica si existe un libro en la base de datos con el ISBN especificado.
	 *
	 * @param isbn El ISBN del libro que se desea verificar si existe.
	 * @return {@code true} si existe un libro con el ISBN especificado en la base de datos, {@code false} en caso contrario.
	 */
	@Override
	public boolean existsById(String isbn) {
		
		return libroRepository.existsById(isbn);
	}
	
	
	/**
	 * Elimina un libro de la base de datos por su ISBN.
	 *
	 * @param isbn El ISBN del libro que se desea eliminar.
	 */
	@Override
	public void deleteById(String isbn) {
	    libroRepository.deleteById(isbn);
	}

	/**
	 * Elimina un libro de la base de datos por su ISBN, verificando previamente si existe.
	 *
	 * @param isbn El ISBN del libro que se desea eliminar.
	 * @throws EntityNotFoundException Si no se encuentra ningún libro con el ISBN especificado.
	 */
	@Override
	public void deleteLibroPorIsbn(String isbn) throws EntityNotFoundException {
	    if (!existsById(isbn)) {
	        throw new EntityNotFoundException();
	    }
	    
	    deleteById(isbn);
	}

	
	
	
	//###########################################################
	//#################### MÉTODOS DE UPDATE ####################
	//###########################################################
	
	
	/**
	 * Actualiza la información de un libro en la base de datos.
	 *
	 * @param libroForUpdate El objeto {@code Libro} con la información actualizada del libro.
	 * @return El objeto {@code Libro} actualizado.
	 * @throws EntityNotFoundException Si no se encuentra ningún libro con el ISBN especificado.
	 */
	@Override
	public Libro actualizarLibro(Libro libroForUpdate) throws EntityNotFoundException {
		Optional<Libro> optionalLibro = libroRepository.findById(libroForUpdate.getIsbn());
		
		if(optionalLibro.isEmpty()) {
			throw new EntityNotFoundException();
		}
		
		Libro libroActualizado;
		
		libroActualizado = libroRepository.save(libroForUpdate);
		
		return libroActualizado;
	}
	
	
	
	
	//###########################################################
	//########### MÉTODOS A IMPLEMENTAR EN UN FUTURO ############
	//###########################################################
	
	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Libro> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Libro> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Libro> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Libro getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro getReferenceById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Libro> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Libro> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Libro> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public void delete(Libro entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Libro> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Libro> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Libro> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Libro> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Libro> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Libro> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Libro> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Libro, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}



}