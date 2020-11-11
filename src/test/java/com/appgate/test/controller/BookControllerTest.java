package com.appgate.test.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author srcortes
 *
 */
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.appgate.test.entities.Author;
import com.appgate.test.entities.Editorial;
import com.appgate.test.entities.Genre;
import com.appgate.test.exception.ManagerApiException;
import com.appgate.test.json.BookRest;
import com.appgate.test.response.ManagerApiResponse;
import com.appgate.test.service.BookService;

public class BookControllerTest {
	private final String SUCCES_STATUS = "Succes";
	private final String SUCCES_CODE = "200 OK";
	private final String SUCCES_MESSAGE = "OK";
	private final String SUCCES_OPERATION = "The books were kept";
	private final String SUCCES_DELETE_BOOK = "Book removing succes..";
	private final List<BookRest> LIST_BOOK_REST = new ArrayList<>();
	private final BookRest BOOK_REST = new BookRest();
	private final Genre GENRE = new Genre();
	private final Editorial EDITORIAL = new Editorial();
	private final Author AUTHOR = new Author();
	@Mock
	private BookService bookService;
	@InjectMocks
	private BookController bookController;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		BOOK_REST.setIdBook(1L);
		BOOK_REST.setTitle("Harry potter y la orden del fenix");
		BOOK_REST.setPrice(39000D);
		BOOK_REST.setDatePublication(new Date());
		GENRE.setIdGenre(1l);
		GENRE.setDescription("Fantasia");
		BOOK_REST.setIdGenre(GENRE);
		EDITORIAL.setIdEditorial(1L);
		EDITORIAL.setNameEditorial("Salamandra");
		BOOK_REST.setIdEditorial(EDITORIAL);
		AUTHOR.setIdAuthor(1L);
		AUTHOR.setNameAuthor("J.k. Rowling");
		BOOK_REST.setIdAuthor(AUTHOR);
		LIST_BOOK_REST.add(BOOK_REST);
		
	}
	@Test
	public void createEmployeTest()throws ManagerApiException{
		Mockito.when(bookService.prepareObjectBook()).thenReturn(SUCCES_OPERATION);
		final ManagerApiResponse<String> response = bookController.createBook();
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), SUCCES_MESSAGE);
		assertEquals(response.getDataInformation(),SUCCES_OPERATION);
	}
	@Test
	public void getInformationBooksTest()throws ManagerApiException{
		Mockito.when(bookService.getListBook()).thenReturn(LIST_BOOK_REST);
		final ManagerApiResponse<List<BookRest>> response = bookController.getInformationBooks();
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), SUCCES_MESSAGE);
		assertFalse(response.getDataInformation().isEmpty());
		assertEquals(response.getDataInformation().size(), 1);
		assertNotNull(response.getDataInformation());
	}
	@Test
	public void deleteBookTest()throws Exception{
		Mockito.when(bookService.deleteBook(BOOK_REST.getIdBook())).thenReturn(SUCCES_DELETE_BOOK);
		final ManagerApiResponse<String> response = bookController.deleteBook(BOOK_REST.getIdBook());
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), SUCCES_MESSAGE);
		assertEquals(response.getDataInformation(), SUCCES_DELETE_BOOK);
	}
	

}
