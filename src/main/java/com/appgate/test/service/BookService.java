package com.appgate.test.service;

import java.util.Set;

import com.appgate.test.dto.AuthorDTO;
import com.appgate.test.dto.BookDTO;
import com.appgate.test.dto.EditorialDTO;
import com.appgate.test.dto.GenreDTO;
import com.appgate.test.exception.ManagerApiException;

/**
 * 
 * @author srcortes
 *
 */
public interface BookService {
	String prepareObjectBook() throws ManagerApiException;
	void createEditorial(Set<EditorialDTO> listEditorial) throws ManagerApiException;
	void createGenre(Set<GenreDTO>listGenre)throws ManagerApiException;
	void createAuthor(Set<AuthorDTO> listAuthor)throws ManagerApiException;
	void createBook(Set<BookDTO> listBook)throws ManagerApiException;
}