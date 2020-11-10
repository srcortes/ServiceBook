package com.appgate.test.dto;

import java.util.List;

import com.appgate.test.entities.Book;

import lombok.Data;
/**
 * 
 * @author USUARIO
 *
 */
@Data
public final class GenreDTO {
	private Long idGenre;
	private String description;
	private List<Book> bookGenre;
	@Override
	public int hashCode() {
		return this.description.trim().length();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj instanceof GenreDTO) {
			GenreDTO genre = (GenreDTO)obj;
			if(this.description.trim().equalsIgnoreCase(genre.description))
				return true;
		}
		return false;
	}
}
