package com.appgate.test.dto;

import java.util.Date;

import lombok.Data;
/**
 * 
 * @author srcortes
 *
 */
@Data
public final class BookDTO {
	private Long idBook;
	private GenreDTO idGenre;
	private EditorialDTO idEditorial;
	private AuthorDTO idAuthor;
	private String title;
	private Double price;
	private Date datePublication;
	@Override
	public int hashCode() {
		return this.title.trim().length();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj instanceof BookDTO) {
			BookDTO editorial = (BookDTO)obj;
			if(this.title.trim().equalsIgnoreCase(editorial.title))
				return true;
		}
		return false;
	}
}
