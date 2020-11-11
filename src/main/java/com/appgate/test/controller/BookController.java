package com.appgate.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.test.exception.ManagerApiException;
import com.appgate.test.exception.NotFoundException;
import com.appgate.test.json.BookRest;
import com.appgate.test.response.ManagerApiResponse;
import com.appgate.test.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * 
 * @author srcortes
 *
 */
@RestController
@RequestMapping(produces = "application/json")
@Validated
@CrossOrigin(origins = "*")
public class BookController {
	@Autowired
	BookService bookService;
	@ApiOperation(notes = "Service is responsable for load book from file csv", value = "N/A")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = Integer.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ManagerApiException.class) })
	@PostMapping(value = "/createBook")
	public ManagerApiResponse<String> createBook() throws ManagerApiException{
		
		return new ManagerApiResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				bookService.prepareObjectBook());
	}
	@ApiOperation(notes = "Service is responsable for generate list books from DB", value = "N/A")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = BookRest.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = ManagerApiException.class) })
	@GetMapping(value = "/getInformationBooks")
	public ManagerApiResponse<List<BookRest>> getInformationBooks()throws ManagerApiException{
		
		return new ManagerApiResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				bookService.getListBook());
	}
	@ApiOperation(notes = "Service is responsable oof close bet for id roulette", value = "Id roulette in state opening")
	@ApiResponses({ @ApiResponse(code = 200, message = "Ok", response = String.class),			
			@ApiResponse(code = 400, message = "Book not found", response = NotFoundException.class),
			@ApiResponse(code = 500, message = "Internar Server Error", response = ManagerApiException.class)})
	@PutMapping(value = "/deleteBook/{idBook}")
	public ManagerApiResponse<String> deleteBook(@PathVariable("idBook") Long idBook) throws Exception{
		
		return new ManagerApiResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				bookService.deleteBook(idBook));		
	}
}
