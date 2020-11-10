package com.appgate.test.service;

import java.util.List;
import java.util.Set;

import com.appgate.test.dto.AuthorDTO;
import com.appgate.test.dto.BookDTO;
import com.appgate.test.dto.EditorialDTO;
import com.appgate.test.dto.GenreDTO;
import com.appgate.test.exception.ManagerApiException;
import com.appgate.test.json.BookRest;

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
	String deleteBook(Long idBook)throws Exception;
	List<BookRest> getListBook()throws ManagerApiException;
}
