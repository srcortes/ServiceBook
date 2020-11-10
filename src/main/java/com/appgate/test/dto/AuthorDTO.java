package com.appgate.test.dto;

import java.util.List;

import com.appgate.test.entities.Book;

import lombok.Data;
/**
 * 
 * @author srcortes
 *
 */
@Data
public final class AuthorDTO {
	private Long idAuthor;
	private String nameAuthor;
	private List<Book> bookAuthor;
	@Override
	public int hashCode() {
		return this.nameAuthor.trim().length();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj instanceof AuthorDTO) {
			AuthorDTO author = (AuthorDTO)obj;
			if(this.nameAuthor.trim().equalsIgnoreCase(author.nameAuthor))
				return true;
		}
		return false;
	}
}
