package com.appgate.test.service.implement;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.appgate.test.constants.ConstantFileBook;
import com.appgate.test.exception.ManagerApiException;
import com.appgate.test.functionaInterface.ControlBook;
import com.appgate.test.json.BookRest;
import com.appgate.test.repositories.AuthorRepository;
import com.appgate.test.repositories.BookRepository;
import com.appgate.test.repositories.EditorialRepository;
import com.appgate.test.repositories.GenreRepository;
import com.appgate.test.service.BookService;
import com.appgate.test.util.IntegrationUtil;
import com.appgate.test.constants.DictionaryErrors;
import com.appgate.test.dto.AuthorDTO;
import com.appgate.test.dto.BookDTO;
import com.appgate.test.dto.EditorialDTO;
import com.appgate.test.dto.GenreDTO;
import com.appgate.test.entities.Author;
import com.appgate.test.entities.Book;
import com.appgate.test.entities.Editorial;
import com.appgate.test.entities.Genre;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author srcortes
 *
 */
@Service
@Slf4j
public final class BookServiceImplement implements BookService {
	@Autowired
	EditorialRepository editorialRepository;
	@Autowired
	GenreRepository genreRepository;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;
	private HashSet<GenreDTO> genres = new HashSet<>();
	private HashSet<AuthorDTO> authors = new HashSet<>();
	private HashSet<EditorialDTO> editorials = new HashSet<>();
	private HashSet<BookDTO> books = new HashSet<>();
	private ControlBook.ControlString controlString = IntegrationUtil::withOutSpaceAndUpperCase;
	private ControlBook.ControlKey key = IntegrationUtil::generateKey;
	private final ModelMapper modelMapper = new ModelMapper();	
	@Override
	public String prepareObjectBook() throws ManagerApiException {
		try {
			StreamFactory factory = StreamFactory.newInstance();
			InputStream in = this.getClass().getResourceAsStream(ConstantFileBook.PATH_FILE_CSV.getValue());
			factory.loadResource(ConstantFileBook.PATH_FILE_XML.getValue());
			BeanReader reader = factory.createReader(ConstantFileBook.NAME_FILE_TAG_XML.getValue(),
					new InputStreamReader(in));			
			Object record = null;
			while ((record = reader.read()) != null) {
				BookDTO bookDTO = (BookDTO) record;
				GenreDTO newGenre = new GenreDTO();
				newGenre.setIdGenre(Long.valueOf(key.generateNumber()));
				newGenre.setDescription(bookDTO.getIdGenre().getDescription());
				genres.add(newGenre);
				AuthorDTO author = new AuthorDTO();
				author.setIdAuthor(Long.valueOf(key.generateNumber()));
				author.setNameAuthor(controlString.withOutSpace(bookDTO.getIdAuthor().getNameAuthor()));
				authors.add(author);
				EditorialDTO editorial = new EditorialDTO();
				editorial.setIdEditorial(Long.valueOf(key.generateNumber()));
				editorial.setNameEditorial(controlString.withOutSpace(bookDTO.getIdEditorial().getNameEditorial()));
				editorials.add(editorial);
				BookDTO newBook = new BookDTO();
				newBook.setIdBook(Long.valueOf(key.generateNumber()));
				newBook.setTitle(controlString.withOutSpace(bookDTO.getTitle()));
				newBook.setIdGenre(genres.stream()
						.filter(j -> j.getDescription().equalsIgnoreCase(bookDTO.getIdGenre().getDescription()))
						.findFirst().get());
				newBook.setIdAuthor(authors.stream()
						.filter(j -> j.getNameAuthor().equalsIgnoreCase(bookDTO.getIdAuthor().getNameAuthor()))
						.findFirst().get());
				newBook.setPrice(bookDTO.getPrice());
				newBook.setIdEditorial(editorials.stream()
						.filter(j -> j.getNameEditorial().equalsIgnoreCase(bookDTO.getIdEditorial().getNameEditorial()))
						.findFirst().get());
				newBook.setDatePublication(bookDTO.getDatePublication());
				books.add(newBook);
			}
			reader.close();
			this.createEditorial(editorials);
			this.createAuthor(authors);
			this.createGenre(genres);
			this.createBook(books);
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(DictionaryErrors.ERROR_INTERNAL_SERVER.getDescriptionError() + ex);
			throw new ManagerApiException(HttpStatus.INTERNAL_SERVER_ERROR,
					DictionaryErrors.ERROR_INTERNAL_SERVER.getDescriptionError(), ex);
		}

		return null;
	}
	@Override
	public void createEditorial(Set<EditorialDTO> listEditorial) throws ManagerApiException {
		List<Editorial> entityEditorial = listEditorial.stream().map(i -> modelMapper.map(i, Editorial.class))
				.collect(Collectors.toList());
		entityEditorial.forEach(i -> {
			editorialRepository.save(i);
		});
	}
	@Override
	public void createGenre(Set<GenreDTO> listGenre) throws ManagerApiException {
		List<Genre> entityGenre = listGenre.stream().map(i -> modelMapper.map(i, Genre.class))
				.collect(Collectors.toList());
		entityGenre.forEach(i -> {
			genreRepository.save(i);
		});		
	}
	@Override
	public void createBook(Set<BookDTO> listBook) throws ManagerApiException {		
		List<Book> entityBook = listBook.stream().map(j -> modelMapper.map(j, Book.class))
				.collect(Collectors.toList());
		entityBook.forEach(i -> {
			bookRepository.save(i);
		});	
	}
	@Override
	public void createAuthor(Set<AuthorDTO> listAuthor) throws ManagerApiException {
		List<Author> entityAuthor = listAuthor.stream().map(i-> modelMapper.map(i, Author.class)).collect(Collectors.toList());
		entityAuthor.forEach(i->{
			authorRepository.save(i);
		});		
	}

	@Override
	public List<BookRest> getListBook() throws ManagerApiException {
		List<Book> listBook = bookRepository.findAll();		
	
		return listBook.stream().map(j-> modelMapper.map(j, BookRest.class)).collect(Collectors.toList());
		
	}	
}
