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
public final class EditorialDTO {
	private Long idEditorial;
	private String nameEditorial;
	private List<Book> bookEditorial;
	@Override
	public int hashCode() {
		return this.nameEditorial.trim().length();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj instanceof EditorialDTO) {
			EditorialDTO editorial = (EditorialDTO)obj;
			if(this.nameEditorial.trim().equalsIgnoreCase(editorial.nameEditorial))
				return true;
		}
		return false;
	}
}
