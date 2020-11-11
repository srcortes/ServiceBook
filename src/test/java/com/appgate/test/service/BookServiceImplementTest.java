package com.appgate.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import org.beanio.BeanReader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.appgate.test.dto.AuthorDTO;
import com.appgate.test.dto.BookDTO;
import com.appgate.test.dto.EditorialDTO;
import com.appgate.test.dto.GenreDTO;
import com.appgate.test.entities.Author;
import com.appgate.test.entities.Book;
import com.appgate.test.entities.Editorial;
import com.appgate.test.entities.Genre;
import com.appgate.test.exception.ManagerApiException;
import com.appgate.test.exception.NotFoundException;
import com.appgate.test.functionaInterface.ControlBook;
import com.appgate.test.json.BookRest;
import com.appgate.test.repositories.AuthorRepository;
import com.appgate.test.repositories.BookRepository;
import com.appgate.test.repositories.EditorialRepository;
import com.appgate.test.repositories.GenreRepository;
import com.appgate.test.service.implement.BookServiceImplement;
import com.appgate.test.util.IntegrationUtil;

public class BookServiceImplementTest {
	private final EditorialDTO EDITORIAL_DTO = new EditorialDTO();
	private final GenreDTO GENRE_DTO = new GenreDTO();
	private final AuthorDTO AUTHOR_DTO = new AuthorDTO();
	private final BookDTO BOOK_DTO = new BookDTO();
	private final Book BOOK = new Book();
	private final Genre GENRE = new Genre();
	private final Author AUTHOR = new Author();
	private final Editorial EDITORIAL = new Editorial();
	private final Set<EditorialDTO> LIST_EDITORIAL_DTO = new HashSet<>();
	private final Set<GenreDTO> LIST_GENRE_DTO = new HashSet<>();
	private final Set<BookDTO> LIST_BOOK_DTO = new HashSet<>(); 
	private final Set<AuthorDTO> LIST_AUTHOR_DTO = new HashSet<>(); 
	private final List<Book> LIST_BOOK = new ArrayList<>();
	private final List<Book> LIST_BOOK_EMPTY = new ArrayList<>();
	private final String MESSAGE = "The books were kept";
	private final String MESSAGE_BOOK_REMOVE = "Book removing succes..";
	private final String MESSAGE_INTERNAL_SERVER = "INTERNAL SERVER ERROR CHECK LOG PLEASE.";
	@Mock
	private EditorialRepository editorialRepository;
	@Mock
	private GenreRepository genreRepository;
	@Mock
	private BookRepository bookRepository;
	@Mock
	private AuthorRepository authorRepository;
	@InjectMocks
	private BookServiceImplement bookServiceImplement;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		AUTHOR_DTO.setIdAuthor(5L);
		AUTHOR_DTO.setNameAuthor("J.k. Rowling");
		LIST_AUTHOR_DTO.add(AUTHOR_DTO);
		EDITORIAL_DTO.setIdEditorial(1L);
		EDITORIAL_DTO.setNameEditorial("Salamandra");
		LIST_EDITORIAL_DTO.add(EDITORIAL_DTO);
		GENRE_DTO.setIdGenre(2L);
		GENRE_DTO.setDescription("Tecnologia");
		LIST_GENRE_DTO.add(GENRE_DTO);
		BOOK_DTO.setIdBook(4L);
		BOOK_DTO.setIdGenre(GENRE_DTO);
		BOOK_DTO.setIdEditorial(EDITORIAL_DTO);
		BOOK_DTO.setIdAuthor(AUTHOR_DTO);
		BOOK_DTO.setTitle("harry potter y las reliquias de la muerte");
		BOOK_DTO.setPrice(45000D);
		BOOK_DTO.setDatePublication(new Date());
		LIST_BOOK_DTO.add(BOOK_DTO);
		BOOK.setIdBook(8L);
		GENRE.setIdGenre(9L);
		GENRE.setDescription("NOVELAS");
		BOOK.setIdGenre(GENRE);
		EDITORIAL.setIdEditorial(10L);
		EDITORIAL.setNameEditorial("Salamandra");
		BOOK.setIdEditorial(EDITORIAL);
		AUTHOR.setIdAuthor(11L);
		AUTHOR.setNameAuthor("GABRIEL GARCIA MARQUEZ");
		BOOK.setIdAuthor(AUTHOR);
		BOOK.setTitle("CRONICA DE UNA MUERTA ANUNCIADA");
		BOOK.setPrice(98000D);
		BOOK.setDatePublication(new Date());
		LIST_BOOK.add(BOOK);		
	}
	@Test
	public void createEditorialTest() throws ManagerApiException {
		Mockito.when(editorialRepository.save(Mockito.any(Editorial.class))).thenReturn(new Editorial());
		bookServiceImplement.createEditorial(LIST_EDITORIAL_DTO);
	}
	@Test(expected = ManagerApiException.class)
	public void createEditorialErrorTest() throws ManagerApiException {
		Mockito.doThrow(ManagerApiException.class).when(editorialRepository).save(Mockito.any(Editorial.class));
		bookServiceImplement.createEditorial(LIST_EDITORIAL_DTO);	
		fail();
	}
	@Test
	public void createGenreTest()throws ManagerApiException{
		Mockito.when(genreRepository.save(Mockito.any(Genre.class))).thenReturn(new Genre());
		bookServiceImplement.createGenre(LIST_GENRE_DTO);
	}
	@Test(expected = ManagerApiException.class)
	public void createGenreErrorTest()throws ManagerApiException{
		Mockito.doThrow(ManagerApiException.class).when(genreRepository).save(Mockito.any(Genre.class));	
		bookServiceImplement.createGenre(LIST_GENRE_DTO);
		fail();
	}
	@Test
	public void createBookTest() throws ManagerApiException{
		Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(new Book());
		bookServiceImplement.createBook(LIST_BOOK_DTO);
	}
	@Test(expected = ManagerApiException.class)
	public void createBookErrorTest() throws ManagerApiException{
		Mockito.doThrow(ManagerApiException.class).when(bookRepository).save(Mockito.any(Book.class));		
		bookServiceImplement.createBook(LIST_BOOK_DTO);
		fail();
	}
	@Test
	public void createAuthorTest()throws ManagerApiException{
		Mockito.when(authorRepository.save(Mockito.any(Author.class))).thenReturn(new Author());
		bookServiceImplement.createAuthor(LIST_AUTHOR_DTO);
	}
	@Test
	public void prepareObjectTest() throws ManagerApiException{
		String message = bookServiceImplement.prepareObjectBook();
		assertEquals(message, MESSAGE);
		assertNotNull(message);
	}
	@Test(expected = Exception.class)
	public void prepareObjectErrorTest() throws ManagerApiException{
		Mockito.doThrow(ManagerApiException.class).when(bookRepository).save(Mockito.any(Book.class));
		Mockito.doThrow(ManagerApiException.class).when(editorialRepository).save(Mockito.any(Editorial.class));
		String message = bookServiceImplement.prepareObjectBook();		
		fail();
		
	}
	@Test
	public void getListBookTest()throws ManagerApiException{
		Mockito.when(bookRepository.findAll()).thenReturn(LIST_BOOK);
		List<BookRest> list= bookServiceImplement.getListBook();
		assertEquals(list.size(), 1);
		assertNotNull(list.isEmpty());
	}	
	@Test
	public void deleteBookTest() throws Exception {		
		Mockito.when(bookRepository.findAll()).thenReturn(LIST_BOOK);
		Mockito.doNothing().when(bookRepository).deleteById(BOOK.getIdBook());
		String message = bookServiceImplement.deleteBook(BOOK.getIdBook());
        assertEquals(message, MESSAGE_BOOK_REMOVE +" -> "+BOOK.getIdBook());	
	}
	@Test(expected = NotFoundException.class)
	public void deleteBookErrorNotFoundTest() throws Exception {
		Mockito.when(bookRepository.findAll()).thenReturn(LIST_BOOK_EMPTY);
		bookServiceImplement.deleteBook(1L);
		fail();
	}
	@Test(expected = Exception.class)
	public void deleteBookErrorInternalServer() throws Exception{
		Mockito.doThrow(Exception.class).when(bookRepository).findAll();
		bookServiceImplement.deleteBook(1L);
		fail();
	}

}
