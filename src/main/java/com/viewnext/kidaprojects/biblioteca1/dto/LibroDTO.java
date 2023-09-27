package com.viewnext.kidaprojects.biblioteca1.dto;

import java.util.Objects;

/**
 * Clase de transferencia de datos (DTO) para la entidad {@code Libro}.
 * 
 * <p>
 * Esta clase proporciona una estructura para transferir datos relacionados con
 * la entidad {@code Libro} entre diferentes capas de la aplicación, como la
 * capa de controladores y la capa de servicios. Está diseñada para ser
 * implementada en un futuro si es necesario utilizar objetos DTO en lugar de la
 * entidad {@code Libro} directamente.
 * </p>
 *
 * @version 1.0
 * @since 27 de septiembre de 2023
 * @unused Esta clase está creada pero no se está utilizando actualmente.
 */
public class LibroDTO {

	private String isbnDTO;
	private String tituloDTO;
	private String autorDTO;
	private int precioDTO;
	
	
	public LibroDTO(String isbnDTO, String tituloDTO, String autorDTO, int precioDTO) {
		super();
		this.isbnDTO = isbnDTO;
		this.tituloDTO = tituloDTO;
		this.autorDTO = autorDTO;
		this.precioDTO = precioDTO;
	}
	
	public LibroDTO() {
		
	}

	public String getIsbnDTO() {
		return isbnDTO;
	}

	public void setIsbnDTO(String isbnDTO) {
		this.isbnDTO = isbnDTO;
	}

	public String getTituloDTO() {
		return tituloDTO;
	}

	public void setTituloDTO(String tituloDTO) {
		this.tituloDTO = tituloDTO;
	}

	public String getAutorDTO() {
		return autorDTO;
	}

	public void setAutorDTO(String autorDTO) {
		this.autorDTO = autorDTO;
	}

	public int getPrecioDTO() {
		return precioDTO;
	}

	public void setPrecioDTO(int precioDTO) {
		this.precioDTO = precioDTO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbnDTO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibroDTO other = (LibroDTO) obj;
		return Objects.equals(isbnDTO, other.isbnDTO);
	}

	@Override
	public String toString() {
		return "LibroDTO [isbnDTO=" + isbnDTO + ", tituloDTO=" + tituloDTO + ", autorDTO=" + autorDTO + ", precioDTO="
				+ precioDTO + "]";
	}
	
	
	
	
	
	
}
