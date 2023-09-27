package com.viewnext.kidaprojects.biblioteca1.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.viewnext.kidaprojects.biblioteca1.dto.LibroDTO;
import com.viewnext.kidaprojects.biblioteca1.model.Libro;



/**
 * Esta clase proporciona métodos para mapear entre objetos de tipo Libro y LibroDTO.
 *
 * <p>
 * El autor de esta clase es Víctor Colorado "Kid A".
 * </p>
 *
 * @version 1.0
 * @since 25 de Septiembre de 2023
 * @unused Esta clase está creada pero no se está utilizando actualmente.
 */
@Component
public class LibroMapper {

    /**
     * Convierte un objeto Libro en un objeto LibroDTO.
     *
     * @param libro El objeto Libro a convertir.
     * @return Un objeto LibroDTO con los mismos datos que el objeto Libro.
     */
    public LibroDTO toLibroDTO(Libro libro) {
        LibroDTO libroDTO = new LibroDTO();

        libroDTO.setIsbnDTO(libro.getIsbn());
        libroDTO.setTituloDTO(libro.getTitulo());
        libroDTO.setAutorDTO(libro.getAutor());
        libroDTO.setPrecioDTO(libro.getPrecio());

        return libroDTO;
    }

    /**
     * Convierte un objeto LibroDTO en un objeto Libro.
     *
     * @param libroDTO El objeto LibroDTO a convertir.
     * @return Un objeto Libro con los mismos datos que el objeto LibroDTO.
     */
    public Libro toLibro(LibroDTO libroDTO) {
        Libro libro = new Libro();

        libro.setIsbn(libroDTO.getIsbnDTO());
        libro.setTitulo(libroDTO.getTituloDTO());
        libro.setAutor(libroDTO.getAutorDTO());
        libro.setPrecio(libroDTO.getPrecioDTO());
        return libro;
    }

    /**
     * Convierte una lista de objetos Libro en una lista de objetos LibroDTO.
     *
     * @param listaLibros La lista de objetos Libro a convertir.
     * @return Una lista de objetos LibroDTO con los mismos datos que los objetos Libro.
     */
    public List<LibroDTO> toListaLibrosDTO(List<Libro> listaLibros) {

        return listaLibros.stream()
                .map(this::toLibroDTO)
                .toList();
    }

    /**
     * Convierte una lista de objetos LibroDTO en una lista de objetos Libro.
     *
     * @param listaLibrosDTO La lista de objetos LibroDTO a convertir.
     * @return Una lista de objetos Libro con los mismos datos que los objetos LibroDTO.
     */
    public List<Libro> toListaLibros(List<LibroDTO> listaLibrosDTO){

        return listaLibrosDTO.stream()
                .map(this::toLibro)
                .toList();
    }
}

